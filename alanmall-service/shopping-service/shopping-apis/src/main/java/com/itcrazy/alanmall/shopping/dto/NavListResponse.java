package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class NavListResponse extends AbstractResponse {
    private List<PanelContentDto> pannelContentDtos;
}
