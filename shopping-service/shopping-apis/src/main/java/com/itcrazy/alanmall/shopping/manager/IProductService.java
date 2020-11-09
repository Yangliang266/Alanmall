package com.itcrazy.alanmall.shopping.manager;

import com.itcrazy.alanmall.shopping.dto.*;

public interface IProductService {
    ProductDetailResponse getProductDetail(ProductDetailRequest request);

    AllProductResponse getAllProduct(AllProductRequest request);

    RecommendResponse recommend();
}
