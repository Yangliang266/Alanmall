package com.itcrazy.alanmall.shopping.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.shopping.constants.GlobalShopConstants;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.converter.ProduCateConverter;
import com.itcrazy.alanmall.shopping.dal.entitys.ItemCat;
import com.itcrazy.alanmall.shopping.dal.persistence.ItemCatMapper;
import com.itcrazy.alanmall.shopping.dto.AllProductCateRequest;
import com.itcrazy.alanmall.shopping.dto.AllProductCateResponse;
import com.itcrazy.alanmall.shopping.dto.ProductCateDto;
import com.itcrazy.alanmall.shopping.manager.IProductCateService;
import com.itcrazy.alanmall.shopping.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.concurrent.TimeUnit;

@DubboService
@Slf4j
public class ProductCateServiceImp implements IProductCateService {
    @Autowired
    RedissonConfig redissonConfig;

    @Autowired
    ItemCatMapper itemCatMapper;

    @Autowired
    ProduCateConverter produCateConverter;

    @Override
//    @Cacheable(cacheNames = GlobalShopConstants.PRODUCT_CATE_CACHE_KEY)
    public AllProductCateResponse getProductCate(AllProductCateRequest request) {
        log.info("Begin: ProductCateServiceImp.getPriductCate.request: " + request);
        AllProductCateResponse response = new AllProductCateResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());

        try {
            // redis
            String json = redissonConfig.checkCache(GlobalShopConstants.PRODUCT_CATE_CACHE_KEY);
            if (StringUtils.isNotBlank(json)) {
                List<ProductCateDto> productCateDtos = JSON.parseArray(json, ProductCateDto.class);
                response.setProductCateDtoList(productCateDtos);
                log.info("End: ProductCateServiceImp.getPriductCate.response: " + response);
                return  response;
            }

            // sql
            Example example = new Example(ItemCat.class);
            String orderCol = "sort_order";
            String orderDir = "asc";
            if(request.getSort().equals("-1")) {
                orderDir = "desc";
            }
            // 需要默认值
            example.setOrderByClause(orderCol + " " + orderDir);
            List<ItemCat> itemCatList = itemCatMapper.selectByExample(example);
            List<ProductCateDto> productCateDtos = produCateConverter.itemCats2Dto(itemCatList);

            //-----------------------  统一使用 spring cache 注解 --------------------
            redissonConfig.setCache(
                    GlobalShopConstants.PRODUCT_CATE_CACHE_KEY,
                    JSON.toJSON(productCateDtos).toString()
                    ).expire(GlobalShopConstants.PRODUCT_CATE_EXPIRE_TIME,TimeUnit.DAYS);
            //-----------------------  统一使用 spring cache 注解 --------------------

            response.setProductCateDtoList(productCateDtos);
        }catch (Exception e) {
            log.error("Error: ProductCateServiceImp.getPriductCate.Exception: " + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        log.info("End: ProductCateServiceImp.getPriductCate.response: " + response);
        return response;
    }
}
