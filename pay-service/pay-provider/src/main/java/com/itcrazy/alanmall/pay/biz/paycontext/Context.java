package com.itcrazy.alanmall.pay.biz.paycontext;

import lombok.Data;

import java.util.SortedMap;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class Context {
    public Context() {
        super();
    }

    private SortedMap<String, String> sParaTemp;
}
