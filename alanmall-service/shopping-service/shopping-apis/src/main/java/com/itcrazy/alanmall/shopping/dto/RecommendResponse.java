package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;

import java.util.Set;

@Data
public class RecommendResponse extends AbstractResponse {
    private Set<PanelDto> panelDtos;
}
