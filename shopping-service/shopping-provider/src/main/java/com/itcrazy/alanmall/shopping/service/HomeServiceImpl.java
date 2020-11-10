package com.itcrazy.alanmall.shopping.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.shopping.constant.GlobalShopConstants;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.converter.ContentConverter;
import com.itcrazy.alanmall.shopping.dal.entitys.Panel;
import com.itcrazy.alanmall.shopping.dal.entitys.PanelContentItem;
import com.itcrazy.alanmall.shopping.dal.persistence.PanelContentMapper;
import com.itcrazy.alanmall.shopping.dal.persistence.PanelMapper;
import com.itcrazy.alanmall.shopping.dto.HomePageResponse;
import com.itcrazy.alanmall.shopping.dto.PanelDto;
import com.itcrazy.alanmall.shopping.manager.IHomeService;
import com.itcrazy.alanmall.shopping.service.cache.CacheManager;
import com.itcrazy.alanmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    PanelContentMapper panelContentMapper;
    @Autowired
    ContentConverter contentConverter;
//    @Autowired
//    RedissonConfig redissonConfig;

    @Autowired
    CacheManager cacheManager;

    @Autowired
    PanelMapper panelMapper;

    @Override
    public HomePageResponse home() {
        log.info("Begin: HomeServiceImpl.homepage");
        HomePageResponse response=new HomePageResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());

        try {
            String json= cacheManager.checkCache(GlobalShopConstants.HOMEPAGE_CACHE_KEY);
            if(StringUtils.isNoneEmpty(json)){
                List<PanelDto> panelDtoList=JSON.parseArray(json,PanelDto.class);
                Set set=new HashSet(panelDtoList);
                response.setPanelContentItemDtos(set);
                log.info("End: HomeServiceImpl.homepage.response: " + response);
                return response;
            }
            Example panelExample = new Example(Panel.class);
            panelExample.createCriteria().
                andEqualTo("position", 0).
                andEqualTo("status", 1);
            panelExample.setOrderByClause("sort_order");

            List<Panel> panels = panelMapper.selectByExample(panelExample);
            Set<PanelDto> panelContentItemDtos = new HashSet<PanelDto>();
            panels.parallelStream().forEach(panel -> {
                List<PanelContentItem> panelContentItems = panelContentMapper.selectPanelContentAndProductWithPanelId(panel.getId());
                PanelDto panelDto = contentConverter.panen2Dto(panel);
                panelDto.setPanelContentItems(contentConverter.panelContentItem2Dto(panelContentItems));
                panelContentItemDtos.add(panelDto);
            });
            cacheManager.setCache(GlobalShopConstants.HOMEPAGE_CACHE_KEY,JSON.toJSONString(panelContentItemDtos),GlobalShopConstants.HOMEPAGE_EXPIRE_TIME);
            response.setPanelContentItemDtos(panelContentItemDtos);
        }catch (Exception e){
            log.error("Error: HomeServiceImpl.homepage.Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }

        log.info("End: HomeServiceImpl.homepage.response: " + response);
        return response;
    }
}
