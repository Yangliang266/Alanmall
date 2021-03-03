package com.itcrazy.alanmall.order.manager;

import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.MqAddAndUpdateResponse;
import com.itcrazy.alanmall.order.dto.MqQueryRequest;
import com.itcrazy.alanmall.order.dto.MqResponse;

/**
 * @Auther: mathyoung
 * @description: mq消息落库api
 */
public interface IMqService {
    /**
     * @Author mathyoung
     * @Description: 添加mq
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.order.dto.MqAddAndUpdateResponse
     */
    MqAddAndUpdateResponse addMqMessage(AddAndUpdateMqRequest request);

    /**
     * @Author mathyoung
     * @Description: 更新mq 状态
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.order.dto.MqAddAndUpdateResponse
     */
    MqAddAndUpdateResponse updateMqMessage(AddAndUpdateMqRequest request);

    /**
     * @Author mathyoung
     * @Description: 查询mq 状态
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.order.dto.MqResponse
     */
    MqResponse queryMqStatus(Long msgId);
}
