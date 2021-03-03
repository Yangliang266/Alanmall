package com.itcrazy.alanmall.pay.biz.payment;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePrecreateResponse;
import com.itcrazy.alanmall.common.exception.BizException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.pay.biz.payconfig.AliPayConfig;
import com.itcrazy.alanmall.pay.biz.paycontext.AliPayContext;
import com.itcrazy.alanmall.pay.biz.paycontext.Context;
import com.itcrazy.alanmall.pay.biz.payfactory.BasePayment;
import com.itcrazy.alanmall.pay.biz.payfactory.PayValidate;
import com.itcrazy.alanmall.pay.constants.PayChannelEnum;
import com.itcrazy.alanmall.pay.constants.PayReturnCodeEnum;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.dto.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Auther: mathyoung
 * @description:
 */
@Service("AliPayment")
@Slf4j
public class AliPayment extends BasePayment {
    @Resource(name = "AliPayValidate")
    PayValidate validate;

    @Autowired
    AliPayConfig aliPayConfig;

    @Override
    protected String getPayChannel() {
        return PayChannelEnum.ALI_PAY.getCode();
    }

    @Override
    protected PayValidate paramValidate() {
        return validate;
    }

    @Override
    protected Context createContext(AbstractRequest request) {
        // test
        PaymentRequest paymentRequest = (PaymentRequest) request;
        AliPayContext aliPayContext = new AliPayContext();
        aliPayContext.setOutTradeNo(paymentRequest.getTradeNo());
        aliPayContext.setSpbillCreateIp(paymentRequest.getSpbillCreateIp());
        aliPayContext.setTotalFee(paymentRequest.getTotalFee());
        aliPayContext.setBody(paymentRequest.getSubject());
        return aliPayContext;
    }

    @Override
    protected void beforePrepare(Context context) {
        AliPayContext aliPayContext = (AliPayContext) context;
        List<Object> goodsDetailList = new ArrayList<>();
        Map<String, Object> goodsDetail = new HashMap<>();
        goodsDetail.put("goods_id", aliPayContext.getProductId());
        goodsDetail.put("goods_name", aliPayContext.getBody());
        goodsDetailList.add(goodsDetail);
        context.setList(goodsDetailList);

    }

    @Override
    protected AbstractResponse generalProcess(Context context) {
        PaymentResponse paymentResponse = new PaymentResponse();
        AliPayContext aliPayContext = (AliPayContext) context;
        // 初始化配置
        Factory.setOptions(aliPayConfig.getOptions());

        try {
            AlipayTradePrecreateResponse response = Factory.Payment.FaceToFace()
                    // 调用optional扩展方法，完成可选业务参数（biz_content下的可选字段）的设置
                    .optional("goods_detail", context.getList())
                    .preCreate(aliPayContext.getBody(), aliPayContext.getOutTradeNo(), aliPayContext.getTotalFee().toString());

            if (ResponseChecker.success(response)) {
                paymentResponse.setCodeUrl(response.getQrCode());
                paymentResponse.setHtmlStr(response.getHttpBody());
            } else {
                System.err.println("调用失败，原因：" + response.msg + "，" + response.subMsg);
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new BizException("调用遭遇异常，原因：" + e.getMessage());
        }
        return paymentResponse;
    }

    @Override
    protected void afterProcess(AbstractRequest request, AbstractResponse response, Context context) {
        log.info("afterProcess:" + ((AliPayContext) context).getTest());
    }

    @Override
    public <T extends AbstractResponse> T completePayment(AbstractRequest request) {
        PaymentResponse response = new PaymentResponse();
        try {
            // 异步验签
            Map<String, String> parameters = new HashMap<>();
            parameters.put("charset", "UTF-8");
            parameters.put("sign", "GM0CbuqaEivqgb......");
            parameters.put("app_id", "2018091261392200");
            parameters.put("sign_type", "RSA2");
            parameters.put("isv_ticket", "");
            parameters.put("timestamp", "2020-03-25 16:27:08");
            //... ... 接收到的所有参数放入一个Map中,验签
            if (Factory.Payment.Common().verifyNotify(parameters)) {
                response.setCode(PayReturnCodeEnum.SUCCESS.getCode());
                response.setMsg(PayReturnCodeEnum.SUCCESS.getMsg());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return (T) response;
    }
}
