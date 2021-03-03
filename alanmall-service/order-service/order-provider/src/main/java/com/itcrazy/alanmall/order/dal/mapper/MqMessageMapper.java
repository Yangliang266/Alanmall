package com.itcrazy.alanmall.order.dal.mapper;

import com.itcrazy.alanmall.common.mybatis.TKMapper;
import com.itcrazy.alanmall.order.dal.entity.MqMessage;
import org.springframework.stereotype.Component;

@Component
public interface MqMessageMapper extends TKMapper<MqMessage> {
    MqMessage selectMqStatusByMsgId(Long msgId);

    Integer mqInsert(MqMessage mqMessage);
}