package com.itcrazy.alanmall.pay.biz.paycontext;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @Auther: mathyoung
 * @description:
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class PayContext  extends Context{
    /** 商户订单号（必填）*/
    private String outTradeNo;
    /** 总金额(单位为元)（必填）*/
    private BigDecimal totalFee;
    /** 用户id **/
    private Long userId;
    /** 返回参数 构建html表单 */
    private String htmlStr;
    /** 商品描述 */
    private String subject;
}
