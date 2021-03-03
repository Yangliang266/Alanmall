package com.itcrazy.alanmall.shopping.converter;


import com.itcrazy.alanmall.shopping.dal.entitys.Item;
import com.itcrazy.alanmall.shopping.dto.CartProductDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {

    public static CartProductDto item2Dto(Item item){
        CartProductDto cartProduct =new CartProductDto();
        cartProduct.setProductId(item.getId());
        cartProduct.setProductName(item.getTitle());
        cartProduct.setSalePrice(item.getPrice());
        cartProduct.setProductImg(item.getImages()[0]);
        if(item.getLimitNum()==null){
            cartProduct.setLimitNum(Long.valueOf(item.getNum()));
        }else if(item.getLimitNum()<0&&item.getNum()<0) {
            cartProduct.setLimitNum((long) 10);
        }else{
            cartProduct.setLimitNum(Long.valueOf(item.getLimitNum()));
        }
        return cartProduct;
    }
}
