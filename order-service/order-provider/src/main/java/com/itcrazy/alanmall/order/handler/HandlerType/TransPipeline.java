package com.itcrazy.alanmall.order.handler.HandlerType;

public interface TransPipeline extends TransBoundInvoke {
    /**
     * @author mathyoung
     * @description: 引擎头节点添加
     * @param: [handlers]
     * @return: void
     */
    void addFirstNode(TransHandler... handlers);

    /**
     * @author mathyoung
     * @description: 引擎尾节点添加
     * @param: [handlers]
     * @return: void
     */
    void addLastNode(TransHandler... handlers);
}
