package com.itcrazy.alanmall.user.converter;

import com.itcrazy.alanmall.user.dal.entity.Member;
import com.itcrazy.alanmall.user.dto.QueryMemberRequest;
import com.itcrazy.alanmall.user.dto.QueryMemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface MemberConverter {
    @Mappings({})
    QueryMemberResponse member2Res(Member request);
}
