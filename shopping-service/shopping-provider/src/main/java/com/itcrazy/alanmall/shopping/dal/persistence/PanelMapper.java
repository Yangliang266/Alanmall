package com.itcrazy.alanmall.shopping.dal.persistence;

import com.itcrazy.alanmall.common.mybatis.TKMapper;
import com.itcrazy.alanmall.shopping.dal.entitys.Panel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PanelMapper extends TKMapper<Panel> {

    List<Panel> selectPanelContentById(@Param("panelId")Integer panelId);
}