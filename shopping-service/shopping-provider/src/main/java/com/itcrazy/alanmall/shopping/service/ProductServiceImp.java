package com.itcrazy.alanmall.shopping.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.shopping.constant.GlobalShopConstants;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.converter.ProductConverter;
import com.itcrazy.alanmall.shopping.dal.entitys.Item;
import com.itcrazy.alanmall.shopping.dal.entitys.ItemDesc;
import com.itcrazy.alanmall.shopping.dal.persistence.ItemDescMapper;
import com.itcrazy.alanmall.shopping.dal.persistence.ItemMapper;
import com.itcrazy.alanmall.shopping.dto.ProductDetailDto;
import com.itcrazy.alanmall.shopping.dto.ProductDetailRequest;
import com.itcrazy.alanmall.shopping.dto.ProductDetailResponse;
import com.itcrazy.alanmall.shopping.manager.IProductService;
import com.itcrazy.alanmall.shopping.utils.ExceptionProcessorUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@Service
@Slf4j
public class ProductServiceImp implements IProductService {
    @Autowired
    RedissonConfig redissonConfig;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ItemDescMapper itemDescMapper;

    @Autowired
    ProductConverter productConverter;

    @Override
    public ProductDetailResponse getProductDetail(ProductDetailRequest request) {
        log.info("Begin: ProductServiceImp.getProductDetail");
        ProductDetailResponse response = new ProductDetailResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());

        try {
            // check redis 商品key 是否存在
            String json = redissonConfig.checkCache(generatorProduceCacheKey(request));
            if(StringUtils.isNotBlank(json)){
                ProductDetailDto productDetailDto=JSON.parseObject(json, ProductDetailDto.class);
                redissonConfig.expireDay(generatorProduceCacheKey(request),GlobalShopConstants.PRODUCT_ITEM_EXPIRE_TIME);
                response.setProductDetailDto(productDetailDto);
                return response;
            }

            // sql 查询 商品信息
            Item item = itemMapper.selectByPrimaryKey(request.getId());

            // 将商品item 转化为dto
            ProductDetailDto productDetailDto = productConverter.item2Dto(item);

            // sql 查询商品描述细节
            ItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(request.getId());
            productDetailDto.setDetail(itemDesc.getItemDesc());

            if (StringUtils.isNotBlank(item.getImage())) {
                // 将商品 所有图片地址放到一起
                String[] images = item.getImage().split(",");
                // 大图片作为用户购买展示 只需要一张
                productDetailDto.setProductImageBig(images[0]);
                // 小图片作为用户选择 放到容器供选择
                productDetailDto.setProductImageSmall(Arrays.asList(images));
            }

            response.setProductDetailDto(productDetailDto);

            // 存储到redis
            redissonConfig.setCache(generatorProduceCacheKey(request),
                    JSON.toJSON(productDetailDto).toString(),
                    GlobalShopConstants.PRODUCT_ITEM_EXPIRE_TIME);

        } catch (Exception e) {
            log.error("ProductServiceImpl.getProductDetail Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }


    private String generatorProduceCacheKey(ProductDetailRequest request){
        StringBuilder stringBuilder=new StringBuilder(GlobalShopConstants.PRODUCT_ITEM_CACHE_KEY);
        stringBuilder.append(":").append(request.getId());
        return stringBuilder.toString();
    }
}
