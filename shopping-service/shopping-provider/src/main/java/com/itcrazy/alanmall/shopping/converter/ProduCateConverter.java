package com.itcrazy.alanmall.shopping.converter;

import com.itcrazy.alanmall.shopping.dal.entitys.ItemCat;
import com.itcrazy.alanmall.shopping.dto.ProductCateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduCateConverter {
    @Mappings({
        @Mapping(source = "icon", target = "iconUrl")
    })
    ProductCateDto itemCat2Dto(ItemCat itemCat);

    List<ProductCateDto> itemCats2Dto(List<ItemCat> itemCats);

}
