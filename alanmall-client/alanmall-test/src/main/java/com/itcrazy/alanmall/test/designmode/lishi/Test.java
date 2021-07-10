package com.itcrazy.alanmall.test.designmode.lishi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: mathyoung
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap map = new HashMap();
        child.test(map);
    }
}
