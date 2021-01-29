package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dal.mapper;

import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dal.entity.MqMessage;
import com.itcrazy.alanmall.common.mybatis.TKMapper;
import org.springframework.stereotype.Component;

@Component
public interface MqMessageMapper extends TKMapper<MqMessage> {
    MqMessage selectByUserId(Long userId);
}