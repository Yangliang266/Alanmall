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
}
