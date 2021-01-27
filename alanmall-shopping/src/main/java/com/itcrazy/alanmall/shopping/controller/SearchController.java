package com.itcrazy.alanmall.shopping.controller;

import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.search.consts.SearchRetCode;
import com.itcrazy.alanmall.search.dto.SearchRequest;
import com.itcrazy.alanmall.search.dto.SearchResponse;
import com.itcrazy.alanmall.search.manager.IEsSearchService;
import com.itcrazy.alanmall.search.manager.ISqlSearchService;
import com.itcrazy.alanmall.user.annotation.Anoymous;
import lombok.Data;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class SearchController {
    @DubboReference(timeout = 3000)
    ISqlSearchService iSqlSearchService;

    @DubboReference(timeout = 3000)
    IEsSearchService iEsSearchService;

    @Anoymous
    @GetMapping("/search/{key}")
    public ResponseData search(@PathVariable("key")String key){
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setKeyword(key);
        SearchResponse searchResponse = iEsSearchService.fuzzySearch(searchRequest);

        if (SearchRetCode.SUCCESS.getCode().equals(searchResponse.getCode())) {
            return new ResponseUtil().setData(searchResponse.getItemDtos());
        }
        return new ResponseUtil().setErrorMsg(searchResponse.getMsg());
    }


    @Anoymous
    @GetMapping("/search/init")
    public void searchInit(){
        // 加载数据到Es
//        iSqlSearchService.initCacheSearch();
        iEsSearchService.searchInit();
    }

}
