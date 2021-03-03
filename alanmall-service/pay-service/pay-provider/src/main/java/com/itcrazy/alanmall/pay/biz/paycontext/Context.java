package com.itcrazy.alanmall.pay.biz.paycontext;

import lombok.Data;

import java.util.List;
import java.util.Map;
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

    private List<Object> list;
}
