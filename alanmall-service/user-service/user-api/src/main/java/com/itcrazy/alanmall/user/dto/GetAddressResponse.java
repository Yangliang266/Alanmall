package com.itcrazy.alanmall.user.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAddressResponse extends AbstractResponse {
    private List<AddressDto> addressDtos;
}
