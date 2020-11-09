package com.itcrazy.alanmall.shopping.converter;

import com.itcrazy.alanmall.shopping.dal.entitys.Item;
import com.itcrazy.alanmall.shopping.dto.*;
import com.itcrazy.alanmall.shopping.dto.sqldto.PageInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductConverter {

    @Mappings({
        @Mapping(source = "id", target = "productId"),
        @Mapping(source = "title", target = "productName"),
        @Mapping(source = "sellPoint", target = "subTitle"),
        @Mapping(source = "price", target = "salePrice")
    })
    ProductDetailDto item2Dto(Item item);

    @Mappings({})
    PageInfoDto req2PageInfoDto(AllProductRequest request);

    @Mappings({
            @Mapping(source = "id",target = "productId"),
            @Mapping(source = "title",target = "productName"),
            @Mapping(source = "price",target = "salePrice"),
            @Mapping(source = "sellPoint",target = "subTitle"),
            @Mapping(source = "imageBig",target = "picUrl")
    })
    ProductDto itemProduct2Dto(Item item);

    List<ProductDto> itemsProduct2Dto(List<Item> items);

//    @Mappings({
//        @Mapping(source = "productId", target = "itemId"),
//        @Mapping(source = "productNum", target = "num")
//    })
//    AddCartRequest cartForm2AddRes(CartForm cartForm);
//
//    @Mappings({
//        @Mapping(source = "productId", target = "itemId"),
//        @Mapping(source = "productNum", target = "num")
//    })
//    UpdateCartNumRequest cartForm2UpdateRes(CartForm cartForm);

//    @Mappings({
//        @Mapping(source = "pid", target = "userId"),
//        @Mapping(source = "uid", target = "itemId")
//    })
//    DeleteCartItemRequest carts2DeleteRes(long uid, long pid);

}
