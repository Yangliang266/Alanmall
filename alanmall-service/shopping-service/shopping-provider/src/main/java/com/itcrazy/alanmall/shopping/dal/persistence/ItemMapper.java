package com.itcrazy.alanmall.shopping.dal.persistence;

import com.itcrazy.alanmall.common.mybatis.TKMapper;
import com.itcrazy.alanmall.shopping.dal.entitys.Item;
import com.itcrazy.alanmall.shopping.dto.AllProductRequest;
import com.itcrazy.alanmall.shopping.dto.sqldto.PageInfoDto;

import java.util.List;

public interface ItemMapper extends TKMapper<Item> {
    List<Item> selectItemFront(PageInfoDto pageInfoDto);
}