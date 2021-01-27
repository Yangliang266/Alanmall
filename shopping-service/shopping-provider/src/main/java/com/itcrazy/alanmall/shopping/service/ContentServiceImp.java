package com.itcrazy.alanmall.shopping.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.shopping.constant.GlobalShopConstants;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.converter.ContentConverter;
import com.itcrazy.alanmall.shopping.dal.entitys.PanelContent;
import com.itcrazy.alanmall.shopping.dal.persistence.PanelContentMapper;
import com.itcrazy.alanmall.shopping.dto.NavListResponse;
import com.itcrazy.alanmall.shopping.dto.PanelContentDto;
import com.itcrazy.alanmall.shopping.manager.IContentService;
import com.itcrazy.alanmall.shopping.utils.ExceptionProcessorUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@DubboService
@Slf4j
public class ContentServiceImp implements IContentService {
    @Autowired
    RedissonConfig redissonConfig;

    @Autowired
    PanelContentMapper panelContentMapper;

    @Autowired
    ContentConverter contentConverter;

    @Override
    public NavListResponse queryNavList() {
        log.info("Begin: ContentServiceImp.queryNavList");
        NavListResponse response = new NavListResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            // redis 查询
            String json = redissonConfig.checkCache(GlobalShopConstants.HEADER_PANEL_CACHE_KEY);
            if (StringUtils.isNotBlank(json)) {
                List<PanelContentDto> panelContentDtoList = JSON.parseArray(json, PanelContentDto.class);
                response.setPannelContentDtos(panelContentDtoList);
                log.info("End: ContentServiceImp.queryNavList.response " + response);
                return response;
            }
            // sql 查询
            Example example = new Example(PanelContent.class);
            example.setOrderByClause("sort_order");
            example.createCriteria().andEqualTo("panelId", GlobalShopConstants.HEADER_PANEL_ID);
            List<PanelContent> panelContentList = panelContentMapper.selectByExample(example);
            List<PanelContentDto> panelContentDtoList = contentConverter.panelContents2Dto(panelContentList);
            redissonConfig.setCache(GlobalShopConstants.HEADER_PANEL_CACHE_KEY, JSON.toJSON(panelContentDtoList).toString());
            response.setPannelContentDtos(panelContentDtoList);

        } catch (Exception e) {
            log.info("error: ContentServiceImp.queryNavList.Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        log.info("End: ContentServiceImp.queryNavList.response " + response);
        return response;
    }
}
