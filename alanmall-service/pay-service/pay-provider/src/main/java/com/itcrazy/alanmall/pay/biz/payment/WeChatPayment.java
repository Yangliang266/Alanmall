package com.itcrazy.alanmall.pay.biz.payment;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.itcrazy.alanmall.common.client.util.Signature;
import com.itcrazy.alanmall.common.exception.BaseBusinessException;
import com.itcrazy.alanmall.common.exception.BizException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.common.util.UtilDate;
import com.itcrazy.alanmall.order.manager.IOrderService;
import com.itcrazy.alanmall.pay.biz.payconfig.WeChatPayConfig;
import com.itcrazy.alanmall.pay.biz.payconfig.WechatPayUtil;
import com.itcrazy.alanmall.pay.biz.paycontext.Context;
import com.itcrazy.alanmall.pay.biz.paycontext.WeChatPayContext;
import com.itcrazy.alanmall.pay.biz.payfactory.BasePayment;
import com.itcrazy.alanmall.pay.biz.payfactory.PayValidate;
import com.itcrazy.alanmall.pay.biz.payfactory.WeChatBuildRequest;
import com.itcrazy.alanmall.pay.constants.PayChannelEnum;
import com.itcrazy.alanmall.pay.constants.PayResultEnum;
import com.itcrazy.alanmall.pay.constants.PayReturnCodeEnum;
import com.itcrazy.alanmall.pay.constants.PaymentConstants;
import com.itcrazy.alanmall.pay.dal.entity.Payment;
import com.itcrazy.alanmall.pay.dal.mapper.PaymentMapper;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyRequest;
import com.itcrazy.alanmall.pay.dto.PaymentNotifyResponse;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.dto.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.omg.IOP.IOR;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: mathyoung
 * @description:
 */
@Service("WeChatPayment")
@Slf4j
public class WeChatPayment extends BasePayment {
    @DubboReference(timeout = 3000)
    IOrderService iOrderService;

    @Resource(name = "WechatValidate")
    PayValidate validate;

    @Resource(name = "WeChatPayConfig")
    WeChatPayConfig weChatPayConfig;

    @Autowired
    private Signature signature;

    @Autowired
    private WXPay wxPay;

    @Resource
    private PaymentMapper paymentMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    protected Context createContext(AbstractRequest request) {
        // test
        PaymentRequest paymentRequest = (PaymentRequest) request;
        WeChatPayContext wechatPaymentContext = new WeChatPayContext();
        wechatPaymentContext.setOutTradeNo(paymentRequest.getTradeNo());
        wechatPaymentContext.setProductId(paymentRequest.getTradeNo());
        wechatPaymentContext.setSpbillCreateIp(paymentRequest.getSpbillCreateIp());
        wechatPaymentContext.setTradeType(PaymentConstants.TradeTypeEnum.NATIVE.getType());
        wechatPaymentContext.setTotalFee(paymentRequest.getTotalFee());
        wechatPaymentContext.setBody(paymentRequest.getSubject());
        return wechatPaymentContext;
    }

    @Override
    protected PayValidate paramValidate() {
        return validate;
    }

    @Override
    protected void beforePrepare(Context context) {
        super.beforePrepare(context);
        SortedMap<String, String> paraMap = context.getSParaTemp();
        WeChatPayContext wechatPaymentContext = (WeChatPayContext) context;

        try {
            paraMap.put("body", wechatPaymentContext.getBody());
            paraMap.put("out_trade_no", wechatPaymentContext.getOutTradeNo());
            //单位分
            paraMap.put("total_fee", String.valueOf(wechatPaymentContext.getTotalFee().multiply(new BigDecimal("100")).intValue()));
            paraMap.put("spbill_create_ip", wechatPaymentContext.getSpbillCreateIp());
            paraMap.put("appid", weChatPayConfig.getWxappId());
            paraMap.put("mch_id", weChatPayConfig.getWxmchID());
            paraMap.put("nonce_str", signature.getNonceStr());
            paraMap.put("trade_type", wechatPaymentContext.getTradeType());
            paraMap.put("product_id", wechatPaymentContext.getProductId());
            paraMap.put("fee_type", "CNY");
            // 此路径是微信服务器调用支付结果通知路径
            paraMap.put("device_info", "WEB");
            paraMap.put("notify_url", weChatPayConfig.getWxnotifyUrl());
            //二维码的失效时间（5分钟）
            paraMap.put("time_expire", UtilDate.getExpireTime(30 * 60 * 1000L));
            // 验签加密
//        String sign = signature.security(paraMap, weChatPayConfig.getWxmchsecret());
            String sign = WeChatBuildRequest.createSign(paraMap, weChatPayConfig.getWxkey());
            paraMap.put("sign", sign);
        } catch (Exception e) {
            throw new BizException("签名错误", e.getMessage());
        }

    }

    @Override
    protected AbstractResponse generalProcess(Context context) {
        PaymentResponse response = new PaymentResponse();
        WeChatPayContext chatPayContext = (WeChatPayContext) context;
        // 微信预支付，返回结果(weixin默认加密算法 HMACSHA256)
        try {
            Map<String, String> resultMap = wxPay.unifiedOrder(chatPayContext.getSParaTemp());
            if (resultMap != null) {
                if ("SUCCESS".equals(resultMap.get("return_code"))) {
                    if ("SUCCESS".equals(resultMap.get("result_code"))) {
                        // 预支付，二维码
                        response.setPrepayId(resultMap.get("prepay_id"));
                        response.setCodeUrl(resultMap.get("code_url"));
                        response.setCode(PayReturnCodeEnum.SUCCESS.getCode());
                        response.setMsg(PayReturnCodeEnum.SUCCESS.getMsg());
                    } else {
                        String errMsg = resultMap.get("err_code") + ":" + resultMap.get("err_code_des");
                        response.setCode(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getCode());
                        response.setMsg(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getMsg(errMsg));
                    }
                } else {
                    response.setCode(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getCode());
                    response.setMsg(PayReturnCodeEnum.PAYMENT_PROCESSOR_FAILED.getMsg(resultMap.get("return_msg")));
                }
            }
        } catch (Exception e) {
            throw new BizException("支付错误", e.getMessage());
        }
        return response;
    }



    @Override
    protected void afterProcess(AbstractRequest request, AbstractResponse respond, Context context) {
        // todo
        log.info("WeChatPayment begin - afterProcess -request:" + request + "\n response:" + respond);

        PaymentRequest paymentRequest = (PaymentRequest) request;
        //插入支付记录表
        PaymentResponse response = (PaymentResponse) respond;
        Payment payment = new Payment();
        payment.setCreateTime(new Date());
        BigDecimal amount = paymentRequest.getOrderFee();
        payment.setOrderAmount(amount);
        payment.setOrderId(paymentRequest.getTradeNo());
        //payment.setTradeNo(globalIdGeneratorUtil.getNextSeq(COMMENT_GLOBAL_ID_CACHE_KEY, 1));
        payment.setPayerAmount(amount);
        payment.setPayerUid(paymentRequest.getUserId());
        payment.setPayerName("");//TODO
        payment.setPayWay(paymentRequest.getPayChannel());
        payment.setProductName(paymentRequest.getSubject());
        payment.setStatus(PayResultEnum.TRADE_PROCESSING.getCode());//
        payment.setRemark("微信支付");
        payment.setPayNo(response.getPrepayId());//第三方的交易id
        payment.setUpdateTime(new Date());
        paymentMapper.insert(payment);
    }

    @Override
    protected String getPayChannel() {
        return PayChannelEnum.WECHAT_PAY.getCode();
    }


    @Override
    public <T extends AbstractResponse> T completePayment(AbstractRequest request) {
        PaymentNotifyRequest paymentNotifyRequest = (PaymentNotifyRequest) request;
        paymentNotifyRequest.requestCheck();
        PaymentNotifyResponse response = new PaymentNotifyResponse();
        // 获取xml数据
        try {
            String xml = paymentNotifyRequest.getXml();
            Map<String, String> map = WXPayUtil.xmlToMap(xml);
            SortedMap<String, String> sortedMap = new TreeMap<>();
            map.forEach(sortedMap::put);

            // 由于支付结果中signtype为空, wxPay使用的加密算法为MD5与支付前的算法HMACSHA256不一致，不推荐使用
             wxPay.isPayResultNotifySignatureValid(sortedMap);

            // 由于支付结果中signtype为空, wxPay使用的加密算法与支付前的算法一致，推荐使用
            if (wxPay.isResponseSignatureValid(sortedMap)) {
                // 签名正确
                // 进行处理。
                // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
                String resultCode = sortedMap.get("return_code");
                if ("SUCCESS".equals(resultCode)) {
                    if ("SUCCESS".equals(sortedMap.get("result_code"))) {
                        //更新支付表
                        Payment payment = new Payment();
                        payment.setStatus(PayResultEnum.TRADE_SUCCESS.getCode());
                        payment.setPaySuccessTime((UtilDate.parseStrToDate(UtilDate.simple,sortedMap.get("time_end").toString(),new Date())));
                        Example example = new Example(Payment.class);
                        example.createCriteria().andEqualTo("orderId", sortedMap.get("out_trade_no"));
                        paymentMapper.updateByExampleSelective(payment, example);
                        //更新订单表状态
                        iOrderService.updateOrder(1, sortedMap.get("out_trade_no").toString());
                        response.setResult(WeChatBuildRequest.setXML("SUCCESS", "OK"));
                    }
                }
            }

        }catch (Exception e) {
            throw new BizException("微信返回结果签名验证失败");
        }

        return (T) response;
    }
}
