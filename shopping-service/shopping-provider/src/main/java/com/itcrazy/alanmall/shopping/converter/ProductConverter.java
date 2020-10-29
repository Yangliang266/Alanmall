package com.itcrazy.alanmall.shopping.converter;

import com.itcrazy.alanmall.shopping.dal.entitys.Item;
import com.itcrazy.alanmall.shopping.dto.ProductDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductConverter {

    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "title", target = "productName"),
            @Mapping(source = "sellPoint", target = "subTitle"),
            @Mapping(source = "price", target = "salePrice")
    })
    ProductDetailDto item2Dto(Item item);

}
