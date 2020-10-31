package com.itcrazy.alanmall.shopping.manager;

import com.itcrazy.alanmall.shopping.dto.*;

public interface ICartService {
    AddCartResponse addToCart(AddCartRequest addCartRequest);

    CartListByIdResponse getCartListById(CartListByIdRequest cartListByIdRequest);

    DeleteCartItemResponse deleteCartItem(DeleteCartItemRequest deleteCartItemRequest);

    UpdateCartNumResponse updateCartNum(UpdateCartNumRequest request);
}
