package com.itcrazy.alanmall.shopping.manager;

import com.itcrazy.alanmall.shopping.dto.AllProductCateRequest;
import com.itcrazy.alanmall.shopping.dto.AllProductCateResponse;

public interface IProductCateService {
    AllProductCateResponse getProductCate(AllProductCateRequest request);
}
