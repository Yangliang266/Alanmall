package com.itcrazy.alanmall.user.dal.mapper;

import com.itcrazy.alanmall.user.dal.entity.Address;

public interface AddressMapper {
    int insert(Address record);

    int insertSelective(Address record);
}