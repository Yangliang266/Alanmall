package com.itcrazy.alanmall.shopping.dal.persistence;

import com.itcrazy.alanmall.common.mybatis.TKMapper;
import com.itcrazy.alanmall.shopping.dal.entitys.PanelContent;
import com.itcrazy.alanmall.shopping.dal.entitys.PanelContentItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PanelContentMapper extends TKMapper<PanelContent> {

    List<PanelContentItem> selectPanelContentAndProductWithPanelId(@Param("panelId")Integer panelId);
}