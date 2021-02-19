package com.itcrazy.alanmall.order.conveter;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.dal.entity.MqMessage;
import com.itcrazy.alanmall.order.dto.AddAndUpdateMqRequest;
import com.itcrazy.alanmall.order.dto.MqMessageDto;
import com.itcrazy.alanmall.order.dto.MqQueryRequest;
import com.itcrazy.alanmall.order.utils.MqTransCondition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "msgId", target = "msgId"),
            @Mapping(source = "mqstatus", target = "status"),
            @Mapping(source = "exchange", target = "exchange"),
            @Mapping(source = "queue", target = "queue")
    })
    AddAndUpdateMqRequest mqTransCondition2Request(MqTransCondition condition);

//    @Mappings({
//            @Mapping(source = "userId", target = "userId"),
//            @Mapping(source = "msgId", target = "msgId"),
//            @Mapping(source = "mqstatus", target = "status")
//    })
//    MqTransCondition context2Condition(CreateOrderContext createOrderContext);

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "msgId", target = "msgId"),
            @Mapping(source = "addressId", target = "addressId"),
            @Mapping(source = "tel", target = "tel"),
            @Mapping(source = "userName", target = "userName"),
            @Mapping(source = "streetName", target = "streetName"),
            @Mapping(source = "orderTotal", target = "orderTotal"),
            @Mapping(source = "cartProductDtoList", target = "cartProductDtoList"),
            @Mapping(source = "buyProductIds", target = "buyProductIds"),
            @Mapping(source = "buyerNickName", target = "buyerNickName"),
            @Mapping(source = "uniqueKey", target = "uniqueKey")
    })
    CreateOrderContext condition2Context(MqTransCondition condition);

}
