package com.itcrazy.alanmall.order.service;

import com.itcrazy.alanmall.order.constant.OrderRetCode;
import com.itcrazy.alanmall.order.conveter.MqConverter;
import com.itcrazy.alanmall.order.dal.entity.MqMessage;
import com.itcrazy.alanmall.order.dal.mapper.MqMessageMapper;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.MqAddAndUpdateResponse;
import com.itcrazy.alanmall.order.dto.MqResponse;
import com.itcrazy.alanmall.order.manager.IMqService;
import com.itcrazy.alanmall.order.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @Auther: mathyoung
 * @description: mq 消息实现
 */
@Service
@Slf4j
public class MqServiceImp implements IMqService {
    @Autowired
    MqMessageMapper mqMessageMapper;

    @Autowired
    MqConverter converter;

    @Override
    public MqAddAndUpdateResponse addMqMessage(AddAndUpdateMqRequest request) {
        MqAddAndUpdateResponse response = new MqAddAndUpdateResponse();
        request.requestCheck();
        try {
            MqMessage mqMessage = converter.req2Mq(request);
            int flag = mqMessageMapper.insert(mqMessage);
            if (flag > 0) {
                response.setMsg(OrderRetCode.SUCCESS.getMessage());
                response.setMsg(OrderRetCode.SUCCESS.getCode());
            }
        }catch (Exception e) {
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public MqAddAndUpdateResponse updateMqMessage(AddAndUpdateMqRequest request) {
        MqAddAndUpdateResponse response = new MqAddAndUpdateResponse();
        request.requestCheck();
        try {
            MqMessage record = converter.req2Mq(request);
            record.setStatus(request.getStatus());

            Example example = new Example(MqMessage.class);
            example.createCriteria().andAllEqualTo(request.getTag());

            int flag = mqMessageMapper.updateByExampleSelective(record,example);
            if (flag > 0) {
                response.setMsg(OrderRetCode.SUCCESS.getMessage());
                response.setMsg(OrderRetCode.SUCCESS.getCode());
            }
        }catch (Exception e) {
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public MqResponse queryMqStatus(Long msgId) {
        MqResponse response = new MqResponse();
        try {
            MqMessage mqMessage = mqMessageMapper.selectMqStatusByUserId(msgId);
            if (null != mqMessage) {
                response.setMsg(OrderRetCode.SUCCESS.getMessage());
                response.setMsg(OrderRetCode.SUCCESS.getCode());
                response.setMessageDto(converter.req2MqDto(mqMessage));
            }
        }catch (Exception e) {
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }
}
