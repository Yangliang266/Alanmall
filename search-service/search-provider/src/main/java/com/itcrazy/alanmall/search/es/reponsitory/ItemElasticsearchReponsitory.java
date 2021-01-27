package com.itcrazy.alanmall.search.es.reponsitory;

import com.itcrazy.alanmall.search.es.entitys.ItemDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.util.List;

public interface ItemElasticsearchReponsitory extends ElasticsearchRepository<ItemDocument,Integer> {
    List<ItemDocument> findItemDocumentByTitleContains(String key);
}
