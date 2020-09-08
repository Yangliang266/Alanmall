package com.itcrazy.alanmall.user.converter;

import com.itcrazy.alanmall.user.dal.entity.Member;
import com.itcrazy.alanmall.user.dto.UserLoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({})
    UserLoginResponse login(Member member);
}
