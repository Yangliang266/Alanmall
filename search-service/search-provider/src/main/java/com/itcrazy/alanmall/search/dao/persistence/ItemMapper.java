package com.itcrazy.alanmall.search.dao.persistence;

import com.itcrazy.alanmall.common.mybatis.TKMapper;
import com.itcrazy.alanmall.search.dao.entitys.Item;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ItemMapper extends TKMapper<Item> {
    List<Item> selectItemFuzzy(String fuzzyKey);
}