package com.itcrazy.alanmall.pay.biz.paycontext;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Auther: mathyoung
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AliPayContext extends PayContext {
    private String test;

    /** 商品描述（必填）*/
    private String body;
    /** 终端IP */
    private String spbillCreateIp;

    /**
     * JSAPI--公众号支付
     * NATIVE--原生扫码支付
     * APP--app支付，统一下单接口trade_type的传参可参考这里
     * MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
     *
     * 交易类型（必填）
     */
    private String tradeType;

    /**
     * 商品id
     */
    private String productId;
    /** 拼接的xml格式数据，用于传递给微信服务端的参数 */
    private String xml;

    private Integer num;

}
