package com.itcrazy.alanmall.pay.biz.payfactory;

import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.common.result.AbstractResponse;
import com.itcrazy.alanmall.pay.biz.paycontext.Context;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Auther: mathyoung
 * @description:
 */
public abstract class BasePayment implements Payment {
    @Override
    public <T extends AbstractResponse> T process(AbstractRequest request) throws Exception {
        AbstractResponse response = null;
        // 1 创建上下文
        Context context = createContext(request);

        // 2 参数验证
        paramValidate().check(request);

        // 3 准备工作，将上下文放入treemap
        beforePrepare(context);

        // 4 执行
        response = generalProcess(context);

        // 5 执行善后
        afterProcess(request, response, context);

        return (T) response;
    }

//    public static Map<String, BasePayment> paymentMap = new ConcurrentHashMap<String, BasePayment>();

    @PostConstruct
    public void init() {
        BasePayment.getInstance().put(getPayChannel(), this);
    }

    private static class SingletonPay {
        private static final Map<String, BasePayment> instance = new HashMap<>();
    }

    public static Map<String, BasePayment> getInstance() {
        return SingletonPay.instance;
    }

    protected abstract String getPayChannel();

    protected abstract PayValidate paramValidate();

    protected abstract Context createContext(AbstractRequest request);

    protected abstract void afterProcess(AbstractRequest request, AbstractResponse response, Context context);

    protected abstract AbstractResponse generalProcess(Context context) throws Exception;

    protected void beforePrepare(Context context) throws Exception {
        SortedMap<String, String> sortedMap = new TreeMap<>();
        context.setSParaTemp(sortedMap);
    };


}
