package com.itcrazy.alanmall.search.service;

import com.itcrazy.alanmall.common.cache.CachePrefixFactory;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.search.consts.SearchRetCode;
import com.itcrazy.alanmall.search.converter.SearchConverter;
import com.itcrazy.alanmall.search.dao.entitys.Item;
import com.itcrazy.alanmall.search.dao.persistence.ItemMapper;
import com.itcrazy.alanmall.search.dto.ItemDto;
import com.itcrazy.alanmall.search.dto.SearchRequest;
import com.itcrazy.alanmall.search.dto.SearchResponse;
import com.itcrazy.alanmall.search.manager.ISqlSearchService;
import com.itcrazy.alanmall.search.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.redisson.api.RScoredSortedSet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@DubboService
public class SqlSearchServiceImp implements ISqlSearchService {
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    SearchConverter searchConverter;

    @Autowired
    RedissonConfig redissonClient;


    @Override
    public SearchResponse fuzzySearch(SearchRequest searchRequest) {
        SearchResponse response = new SearchResponse();
        response.setCode(SearchRetCode.SUCCESS.getCode());
        response.setMsg(SearchRetCode.SUCCESS.getMsg());

        try {
            searchRequest.requestCheck();

            // 缓存check
            // todo
            // 数据库查询
            List<Item> items = itemMapper.selectItemFuzzy(searchRequest.getKeyword());

            // 模糊查询的所有商品加入热点搜索缓存中
            items.parallelStream().forEach(obj -> {
                addScoreSearchHotWord(obj.getTitle());
            });

            List<ItemDto> itemDtos = searchConverter.items2Dtos(items);

            response.setItemDtos(itemDtos);
        } catch (Exception e) {
            log.error("Error: SqlSearchServiceImp.fuzzySearch.Exception: " + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }


    @Override
    public SearchResponse initCacheSearch() {
        SearchResponse response = new SearchResponse();
        response.setCode(SearchRetCode.SUCCESS.getCode());
        response.setMsg(SearchRetCode.SUCCESS.getMsg());

        try {
            RScoredSortedSet<ItemDto> scoredSortedSet = redissonClient.getScoredSortedSet(CachePrefixFactory.CART_ITEM_CACHE_HOT_KEY);

            if (null != scoredSortedSet) {
                List<ItemDto> list = new ArrayList<>();
                scoredSortedSet.valueRangeReversed(0,5).forEach(obj -> {
                    list.add(obj);
                });
                response.setItemDtos(list);
            }
        } catch (Exception e) {
            log.error("Error: SqlSearchServiceImp.initHotKeySearch.Exception: " + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    private void addScoreSearchHotWord(String keyword) {
        if(StringUtils.isNotEmpty(keyword)){
            RScoredSortedSet<Object> scoredSortedSet = redissonClient.getScoredSortedSet(CachePrefixFactory.CART_ITEM_CACHE_HOT_KEY);
            if (null == scoredSortedSet.getScore(keyword)) {
                scoredSortedSet.addAndGetRevRank(1.0,keyword);
            } else {
                scoredSortedSet.addScore(keyword, 1.0);
            }
        }
    }


}
