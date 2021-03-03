package com.itcrazy.alanmall.user.converter;

import com.itcrazy.alanmall.user.dal.entity.Address;
import com.itcrazy.alanmall.user.dto.AddressAddRequest;
import com.itcrazy.alanmall.user.dto.AddressDto;
import com.itcrazy.alanmall.user.dto.AddressUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressConverter {

    @Mappings({})
    List<AddressDto> address2List(List<Address> addressList);

    @Mappings({})
    Address addReq2Address(AddressAddRequest request);

    @Mappings({})
    Address upRes2Address(AddressUpdateRequest request);

}
