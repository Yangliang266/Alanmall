package com.itcrazy.alanmall.search.service;

import com.itcrazy.alanmall.search.consts.SearchRetCode;
import com.itcrazy.alanmall.search.converter.SearchConverter;
import com.itcrazy.alanmall.search.dao.entitys.Item;
import com.itcrazy.alanmall.search.dao.persistence.ItemMapper;
import com.itcrazy.alanmall.search.dto.ItemDto;
import com.itcrazy.alanmall.search.dto.SearchRequest;
import com.itcrazy.alanmall.search.dto.SearchResponse;
import com.itcrazy.alanmall.search.es.entitys.ItemDocument;
import com.itcrazy.alanmall.search.es.reponsitory.ItemElasticsearchReponsitory;
import com.itcrazy.alanmall.search.manager.IEsSearchService;
import com.itcrazy.alanmall.search.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService
@Slf4j
public class EsSearchServiceImp implements IEsSearchService {
    @Autowired
    private ItemElasticsearchReponsitory itemElasticsearchReponsitory;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private SearchConverter searchConverter;

    @Override
    public void searchInit() {
        List<Item> items = itemMapper.selectAll();
//        items.forEach(item-> {
//            itemElasticsearchReponsitory.save(searchConverter.item2itemDocument(item));
//        });
        itemElasticsearchReponsitory.saveAll(searchConverter.items2itemDocumentsDtos(items));

    }

    @Override
    public SearchResponse searchHinting(SearchRequest searchRequest) {
        return null;
    }

    @Override
    public SearchResponse accurateSearch(SearchRequest searchRequest) {
        return null;
    }

    @Override
    public SearchResponse fuzzySearch(SearchRequest searchRequest) {
        SearchResponse response = new SearchResponse();
        try {
            searchRequest.requestCheck();
            List<ItemDocument> documents = itemElasticsearchReponsitory.findItemDocumentByTitleContains(searchRequest.getKeyword());
            List<ItemDto> itemDtos = searchConverter.itemDocuments2Dtos(documents);
            response.setItemDtos(itemDtos);
            response.setCode(SearchRetCode.SUCCESS.getCode());
            response.setMsg(SearchRetCode.SUCCESS.getMsg());
        } catch (Exception e) {
            log.error("Error: Exception.EsSearchServiceImp.fuzzySearch" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public SearchResponse initHotKeySearch() {
        return null;
    }

    @Override
    public SearchResponse HotKeySearch(SearchRequest searchRequest) {
        return null;
    }

}
