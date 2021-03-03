package com.itcrazy.alanmall.search.converter;

import com.itcrazy.alanmall.search.dao.entitys.Item;
import com.itcrazy.alanmall.search.dto.ItemDto;
import com.itcrazy.alanmall.search.dto.ProductDto;
import com.itcrazy.alanmall.search.es.entitys.ItemDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SearchConverter {

    @Mappings({
            @Mapping(source = "id",target = "productId"),
            @Mapping(source = "title",target = "productName"),
            @Mapping(source = "price",target = "salePrice"),
            @Mapping(source = "sell_point",target = "subTitle"),
            @Mapping(source = "image",target = "picUrl")
    })
    ItemDto itemDocument2Dto(ItemDocument item);

    List<ItemDto> itemDocuments2Dtos(List<ItemDocument> items);

    @Mappings({
            @Mapping(source = "sellPoint",target = "sell_point"),
            @Mapping(source = "limitNum",target = "limit_num")
    })
    ItemDocument item2itemDocument(Item item);

    List<ItemDocument> items2itemDocumentsDtos(List<Item> items);

    @Mappings({
            @Mapping(source = "id",target = "productId"),
            @Mapping(source = "title",target = "productName"),
            @Mapping(source = "price",target = "salePrice"),
            @Mapping(source = "sellPoint",target = "subTitle"),
            @Mapping(source = "image",target = "picUrl")
    })
    ItemDto item2Dto(Item item);

    List<ItemDto> items2Dtos(List<Item> item);

    @Mappings({
            @Mapping(source = "id",target = "productId"),
            @Mapping(source = "title",target = "productName"),
            @Mapping(source = "price",target = "salePrice"),
            @Mapping(source = "sellPoint",target = "subTitle"),
            @Mapping(source = "imageBig",target = "picUrl")
    })
    ProductDto itemPro2Dto(Item item);

    List<ProductDto> itemspro2Dto(List<Item> items);

}
