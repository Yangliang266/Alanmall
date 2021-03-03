package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CartListByIdResponse extends AbstractResponse {

    private List<CartProductDto> cartProductDto;
}
