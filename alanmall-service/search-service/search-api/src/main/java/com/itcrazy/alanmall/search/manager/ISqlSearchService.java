package com.itcrazy.alanmall.search.manager;

import com.itcrazy.alanmall.search.dto.SearchRequest;
import com.itcrazy.alanmall.search.dto.SearchResponse;

public interface ISqlSearchService {
    SearchResponse fuzzySearch(SearchRequest searchRequest);

    SearchResponse initCacheSearch();
}
