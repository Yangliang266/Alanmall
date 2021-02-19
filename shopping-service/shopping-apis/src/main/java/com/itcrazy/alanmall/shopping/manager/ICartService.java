package com.itcrazy.alanmall.shopping.manager;

import com.itcrazy.alanmall.shopping.dto.*;

public interface ICartService {
    AddCartResponse addToCart(AddCartRequest request);

    CartListByIdResponse getCartListById(CartListByIdRequest request);

    DeleteCartItemResponse deleteCartItem(DeleteCartItemRequest request);

    DeleteCheckedItemResposne deleteCheckedItems(DeleteCheckedItemRequest request);

    UpdateCartNumResponse updateCartNum(UpdateCartNumRequest request);

    SelectAllItemResponse selectAllItem(SelectAllItemRequest request);

    ClearCartItemResponse clearCartItemByUserID(ClearCartItemRequest request);
}
