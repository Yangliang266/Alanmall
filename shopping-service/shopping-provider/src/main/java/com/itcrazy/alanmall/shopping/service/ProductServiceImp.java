package com.itcrazy.alanmall.shopping.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.shopping.constant.GlobalShopConstants;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.converter.ContentConverter;
import com.itcrazy.alanmall.shopping.converter.ProductConverter;
import com.itcrazy.alanmall.shopping.dal.entitys.*;
import com.itcrazy.alanmall.shopping.dal.persistence.ItemDescMapper;
import com.itcrazy.alanmall.shopping.dal.persistence.ItemMapper;
import com.itcrazy.alanmall.shopping.dal.persistence.PanelContentMapper;
import com.itcrazy.alanmall.shopping.dal.persistence.PanelMapper;
import com.itcrazy.alanmall.shopping.dto.*;
import com.itcrazy.alanmall.shopping.dto.sqldto.PageInfoDto;
import com.itcrazy.alanmall.shopping.manager.IProductService;
import com.itcrazy.alanmall.shopping.utils.ExceptionProcessorUtils;
import com.itcrazy.alanmall.shopping.utils.ShopGeneratorUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
    PanelMapper panelMapper;

    @Autowired
    PanelContentMapper panelContentMapper;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    ContentConverter contentConverter;

    @Override
    public ProductDetailResponse getProductDetail(ProductDetailRequest request) {
        log.info("Begin: ProductServiceImp.getProductDetail");
        request.requestCheck();
        ProductDetailResponse response = new ProductDetailResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());

        try {
            // check redis 商品key 是否存在
            String json = redissonConfig.checkCache(ShopGeneratorUtils.getInstance().generatorCartItemKey(request.getId()));
            if(StringUtils.isNotBlank(json)){
                ProductDetailDto productDetailDto=JSON.parseObject(json, ProductDetailDto.class);
                redissonConfig.expireDay(
                        ShopGeneratorUtils.getInstance().generatorCartItemKey(request.getId()),
                        GlobalShopConstants.PRODUCT_ITEM_EXPIRE_TIME);
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
            redissonConfig.setCache(
                    ShopGeneratorUtils.getInstance().generatorCartItemKey(request.getId()), JSON.toJSON(productDetailDto).toString()).
                    expire(GlobalShopConstants.PRODUCT_ITEM_EXPIRE_TIME,TimeUnit.DAYS);

        } catch (Exception e) {
            log.error("ProductServiceImpl.getProductDetail Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AllProductResponse getAllProduct(AllProductRequest request) {
        log.info("Begin: ProductServiceImp.getAllProduct");
        AllProductResponse response = new AllProductResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            PageHelper.startPage(request.getPage(), request.getSize());
            PageInfoDto pageInfoDto = productConverter.req2PageInfoDto(request);
            pageInfoDto.setOrderCol("created");
            pageInfoDto.setOrderDir("desc");
            if (request.getSort().equals("1")) {
                pageInfoDto.setOrderCol("price");
                pageInfoDto.setOrderDir("asc");
            } else if(request.getSort().equals("-1")) {
                pageInfoDto.setOrderCol("price");
                pageInfoDto.setOrderDir("desc");
            }

            // sql
            List<Item> itemList = itemMapper.selectItemFront(pageInfoDto);
            List<ProductDto> productDtos = productConverter.itemsProduct2Dto(itemList);
            PageInfo<Item> pageInfo = new PageInfo<>(itemList);

            response.setProductDtoList(productDtos);
            response.setTotal(pageInfo.getTotal());

        } catch (Exception e) {
            log.error("ProductServiceImpl.getAllProduct Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return  response;
    }

    @Override
    public RecommendResponse recommend() {
        log.info("Begin: ProductServiceImp.recommend");
        RecommendResponse response = new RecommendResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        try {
            // redis
            String json = redissonConfig.checkCache(GlobalShopConstants.RECOMMEND_PANEL_CACHE_KEY);
            if (StringUtils.isNotBlank(json)) {
                List<PanelDto> panelDtoList = JSON.parseArray(json, PanelDto.class);
                Set set = new HashSet(panelDtoList);
                response.setPanelDtos(set);
                return  response;
            }
            // sql
            Set panelsets = new HashSet();
            List<Panel> panels = panelMapper.selectPanelContentById(GlobalShopConstants.RECOMMEND_PANEL_ID);
            List<PanelContentItem> panelContentItems = panelContentMapper.selectPanelContentAndProductWithPanelId(GlobalShopConstants.RECOMMEND_PANEL_ID);
            List<PanelContentItemDto> panelContentItemDtos = contentConverter.panelContentItem2Dto(panelContentItems);

            for (Panel panel : panels) {
                PanelDto panelDto = contentConverter.panen2Dto(panel);
                panelDto.setPanelContentItems(panelContentItemDtos);
                panelsets.add(panelDto);
                break;
            }
            redissonConfig.setCache(GlobalShopConstants.RECOMMEND_PANEL_CACHE_KEY, JSON.toJSON(panelsets).toString()).
                    expire(GlobalShopConstants.RECOMMEND_CACHE_EXPIRE, TimeUnit.DAYS);
            response.setPanelDtos(panelsets);

        } catch (Exception e) {
            log.error("ProductServiceImpl.recommend Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

}
