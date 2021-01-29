package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.conveter;

import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dal.entity.MqMessage;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dto.AddAndUpdateMqRequest;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dto.MqMessageDto;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.dto.MqQueryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

/**
 * @Auther: mathyoung
 * @description: mq 类型转换
 */
@Mapper(componentModel = "spring")
public interface MqConverter {
    @Mappings({})
    MqMessage req2Mq(AddAndUpdateMqRequest request);

    @Mappings({})
    MqMessage queryReq2Mq(MqQueryRequest request);

    @Mappings({})
    MqMessageDto req2MqDto(MqMessage mqMessage);
}
