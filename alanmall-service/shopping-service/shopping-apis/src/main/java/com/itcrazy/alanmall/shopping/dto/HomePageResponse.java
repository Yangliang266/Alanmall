package com.itcrazy.alanmall.shopping.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class HomePageResponse extends AbstractResponse {

    private Set<PanelDto> panelContentItemDtos;
}
