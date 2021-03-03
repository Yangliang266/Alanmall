package com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dal.mapper;

import com.itcrazy.alan.leadtest.rabbit.consume.rabbitconsume.dal.entity.MqMessage;
import com.itcrazy.alanmall.common.mybatis.TKMapper;
import org.springframework.stereotype.Component;

@Component
public interface MqMessageMapper extends TKMapper<MqMessage> {
}