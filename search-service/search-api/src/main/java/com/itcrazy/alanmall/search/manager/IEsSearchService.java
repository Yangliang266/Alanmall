package com.itcrazy.alanmall.search.manager;

import com.itcrazy.alanmall.search.dto.SearchInitResponse;
import com.itcrazy.alanmall.search.dto.SearchRequest;
import com.itcrazy.alanmall.search.dto.SearchResponse;

public interface IEsSearchService {
    /**
     * Es 初始化从mysql加载数据
     */
    void searchInit();

    SearchResponse searchHinting(SearchRequest searchRequest);

    SearchResponse accurateSearch(SearchRequest searchRequest);

    SearchResponse fuzzySearch(SearchRequest searchRequest);

    SearchResponse initHotKeySearch();

    SearchResponse HotKeySearch(SearchRequest searchRequest);
}
