package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDetailResponse extends AbstractResponse {
    private ProductDetailDto productDetailDto;
}
