package com.itcrazy.alanmall.pay.biz.payfactory;

import com.itcrazy.alanmall.common.exception.BizException;
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

        // 3 准备工作，将上下文放入treeMap
        beforePrepare(context);

        // 4 执行总核心
        response = generalProcess(context);

        // 5 执行善后
        afterProcess(request, response, context);

        return (T) response;
    }

    /**
     * 策略模式 -> 通过hashmap简化 -> 运行遍历所有模式
     * 初始化 支付宝支付 / 微信支付 放入容器 -> 运行通过客户端选择 -> Basement确定具体执行策略
     */
    @PostConstruct
    public void init() {
        BasePayment.getInstance().put(getPayChannel(), this);
    }

    private static class SingletonPay {
        private static final Map<String, BasePayment> instance = new HashMap<>();
    }

    /**
     * 单例实现支付接口
     * @return
     */
    public static Map<String, BasePayment> getInstance() {
        return SingletonPay.instance;
    }

    protected abstract String getPayChannel();

    protected abstract PayValidate paramValidate();

    protected abstract Context createContext(AbstractRequest request);

    protected abstract void afterProcess(AbstractRequest request, AbstractResponse response, Context context);

    protected abstract AbstractResponse generalProcess(Context context) throws Exception;

    protected void beforePrepare(Context context) {
        try {
            SortedMap<String, String> sortedMap = new TreeMap<>();
            context.setSParaTemp(sortedMap);
        }catch (Exception e) {
            throw new BizException(e);
        }
    }


}
