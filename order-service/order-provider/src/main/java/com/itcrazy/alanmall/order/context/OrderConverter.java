package com.itcrazy.alanmall.order.context;

import com.itcrazy.alanmall.user.dto.QueryMemberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface OrderConverter {
    @Mappings({})
    QueryMemberRequest createContext2req(TransHandlerContext context);
}
