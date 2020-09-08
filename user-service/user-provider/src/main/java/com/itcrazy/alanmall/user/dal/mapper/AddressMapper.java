package com.itcrazy.alanmall.user.dal.mapper;

import com.itcrazy.alanmall.user.dal.entity.Address;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface AddressMapper {
    int insert(Address record);

    int insertSelective(Address record);
}