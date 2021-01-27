package com.itcrazy.alanmall.search.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class SearchResponse extends AbstractResponse {
//    private ItemDto itemDto;

    private List<ItemDto> itemDtos;
}
