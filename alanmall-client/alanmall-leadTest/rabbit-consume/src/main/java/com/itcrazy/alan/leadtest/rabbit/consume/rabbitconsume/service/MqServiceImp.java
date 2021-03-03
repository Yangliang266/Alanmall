package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.service;

import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.conveter.MqConverter;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dal.entity.MqMessage;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dal.mapper.MqMessageMapper;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.AddAndUpdateMqRequest;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.MqAddAndUpdateResponse;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dto.MqResponse;
import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.manager.IMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: mathyoung
 * @description: mq 消息实现
 */
@Service
@Slf4j
public class MqServiceImp {
    @Autowired
    MqMessageMapper mqMessageMapper;

    @Autowired
    MqConverter converter;

    public MqAddAndUpdateResponse addMqMessage(AddAndUpdateMqRequest request) {
        MqAddAndUpdateResponse response = new MqAddAndUpdateResponse();
        request.requestCheck();
        try {
            MqMessage mqMessage = converter.req2Mq(request);
            int flag = mqMessageMapper.insert(mqMessage);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


    public MqResponse query(Long userId) {
        MqResponse response = new MqResponse();

        try {
            Example example = new Example(MqMessage.class);
            example.createCriteria().andAllEqualTo(userId);

            List<MqMessage> mqMessage = mqMessageMapper.selectByExample(example);
            if (null != mqMessage) {
                response.setMessageDto(converter.req2MqDto(mqMessage.get(0)));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
