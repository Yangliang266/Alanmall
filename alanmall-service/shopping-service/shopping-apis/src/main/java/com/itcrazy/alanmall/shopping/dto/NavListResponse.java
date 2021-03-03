package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.List;

@Data
public class NavListResponse extends AbstractResponse {
    private List<PanelContentDto> pannelContentDtos;
}
