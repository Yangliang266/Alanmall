package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.manager;


import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.AddAndUpdateMqRequest;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.MqAddAndUpdateResponse;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.MqResponse;

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
     * @Description: 查询mq 状态
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.order.dto.MqResponse
     */
    MqResponse query(Long userId);
}
