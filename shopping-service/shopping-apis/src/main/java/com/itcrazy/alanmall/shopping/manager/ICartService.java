package com.itcrazy.alanmall.shopping.manager;

import com.itcrazy.alanmall.shopping.dto.AddCartRequest;
import com.itcrazy.alanmall.shopping.dto.AddCartResponse;
import com.itcrazy.alanmall.shopping.dto.CartListByIdRequest;
import com.itcrazy.alanmall.shopping.dto.CartListByIdResponse;

public interface ICartService {
    AddCartResponse addToCart(AddCartRequest addCartRequest);

    CartListByIdResponse getCartListById(CartListByIdRequest cartListByIdRequest);
}
