package com.itcrazy.alanmall.shopping.manager;

import com.itcrazy.alanmall.shopping.dto.ProductDetailRequest;
import com.itcrazy.alanmall.shopping.dto.ProductDetailResponse;

public interface IProductService {
    ProductDetailResponse getProductDetail(ProductDetailRequest request);
}
