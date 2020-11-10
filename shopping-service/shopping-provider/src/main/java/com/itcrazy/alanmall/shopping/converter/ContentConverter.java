package com.itcrazy.alanmall.shopping.converter;

import com.itcrazy.alanmall.shopping.dal.entitys.Panel;
import com.itcrazy.alanmall.shopping.dal.entitys.PanelContent;
import com.itcrazy.alanmall.shopping.dal.entitys.PanelContentItem;
import com.itcrazy.alanmall.shopping.dto.PanelContentDto;
import com.itcrazy.alanmall.shopping.dto.PanelContentItemDto;
import com.itcrazy.alanmall.shopping.dto.PanelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContentConverter {

    @Mappings({})
    PanelContentDto panelContent2Dto(PanelContent panelContent);

    @Mappings({})
    PanelContentDto panelContentItem2Dto(PanelContentItem panelContentItem);

    @Mappings({})
    PanelDto panen2Dto(Panel panel);

    List<PanelContentDto> panelContents2Dto(List<PanelContent> panelContents);

    List<PanelContentItemDto> panelContentItem2Dto(List<PanelContentItem> panelContentItems);

}
