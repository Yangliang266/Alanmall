package com.itcrazy.alanmall.shopping.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.common.cache.CachePrefixFactory;
import com.itcrazy.alanmall.shopping.constant.GlobalShopConstants;
import com.itcrazy.alanmall.shopping.constants.ShoppingRetCode;
import com.itcrazy.alanmall.shopping.converter.CartItemConverter;
import com.itcrazy.alanmall.shopping.dal.entitys.Item;
import com.itcrazy.alanmall.shopping.dal.persistence.ItemMapper;
import com.itcrazy.alanmall.shopping.dto.*;
import com.itcrazy.alanmall.shopping.manager.ICartService;
import com.itcrazy.alanmall.shopping.utils.ExceptionProcessorUtils;
import com.itcrazy.alanmall.shopping.utils.ShopGeneratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RMap;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CartServiceImp implements ICartService {
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CartItemConverter cartItemConverter;

    @Autowired
    RedissonConfig redissonConfig;

    @Override
    public CartListByIdResponse getCartListById(CartListByIdRequest cartListByIdRequest) {
        log.info("Begin: CartServiceImp.getCartListById");
        cartListByIdRequest.requestCheck();
        String cartCacheKey =  CachePrefixFactory.generatorCartKey(cartListByIdRequest.getUserId());
        CartListByIdResponse cartListByIdResponse = new CartListByIdResponse();
        cartListByIdResponse.setCode(ShoppingRetCode.SUCCESS.getCode());
        cartListByIdResponse.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        List<CartProductDto> list = new ArrayList();
        try {
            // 查询redis
            Map<Object, Object> items = redissonConfig.getMap(cartCacheKey);
            // 可能会有多个产品被添加到购物车
            items.values().forEach(obj -> {
                // obj转换
                CartProductDto cartProductDto = JSON.parseObject(obj.toString(), CartProductDto.class);
                list.add(cartProductDto);
            });
            cartListByIdResponse.setCartProductDto(list);
            return cartListByIdResponse;
        } catch (Exception e) {
            log.error("CartServiceImpl.getCartListById Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(cartListByIdResponse, e);
        }
        return cartListByIdResponse;
    }

    @Override
    public DeleteCartItemResponse deleteCartItem(DeleteCartItemRequest request) {
        log.info("Begin: CartServiceImp.deleteCartItem");
        request.requestCheck();
        String cartCacheKey =  CachePrefixFactory.generatorCartKey(request.getUserId());
        DeleteCartItemResponse response = new DeleteCartItemResponse();
        try {
            // 检查redis key field是否存在
            if (redissonConfig.checkMapCache(
                    cartCacheKey,
                    request.getItemId().toString())) {
                // 通过redis 操作删除商品缓存
                redissonConfig.removeMapCache(
                        cartCacheKey,
                        request.getItemId().toString());

                response.setCode(ShoppingRetCode.SUCCESS.getCode());
                response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
            }
        } catch (Exception e) {
            log.error("Error: CartServiceImp.deleteCartItem Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public DeleteCheckedItemResposne deleteCheckedItems(DeleteCheckedItemRequest request) {
        log.info("Begin: CartServiceImp deleteCheckedItems");
        request.requestCheck();
        String cartCacheKey =  CachePrefixFactory.generatorCartKey(request.getUserId());
        DeleteCheckedItemResposne resposne = new DeleteCheckedItemResposne();
        try {
            RMap items = redissonConfig.getMap(cartCacheKey);
            items.values().forEach(obj  -> {
                CartProductDto cartProductDto = JSON.parseObject(obj.toString(), CartProductDto.class);
                if ("true".equals(cartProductDto.getChecked())) {
                    items.remove(cartProductDto.getProductId().toString());
                }
            });
            resposne.setCode(ShoppingRetCode.SUCCESS.getCode());
            resposne.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("Error: CartServiceImp.deleteCheckedItems Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(resposne, e);
        }
        return resposne;
    }

    @Override
    public UpdateCartNumResponse updateCartNum(UpdateCartNumRequest request) {
        log.info("Begin: CartServiceImp updateCartNum");
        request.requestCheck();
        String cartCacheKey =  CachePrefixFactory.generatorCartKey(request.getUserId());
        UpdateCartNumResponse response = new UpdateCartNumResponse();
        response.setCode(ShoppingRetCode.SUCCESS.getCode());
        response.setMsg(ShoppingRetCode.SUCCESS.getMessage());

        try {
            if (redissonConfig.checkMapCache(
                    cartCacheKey,
                    request.getItemId().toString())) {
                // 解析json
                String json = redissonConfig.getMapField(
                        cartCacheKey,
                        request.getItemId().toString());

                if(StringUtils.isNotBlank(json)) {
                    CartProductDto cartProductDto = JSON.parseObject(json, CartProductDto.class);
                    // 更新redis 产品数量
                    cartProductDto.setProductNum(request.getNum().longValue());
                    // 设置可选
                    cartProductDto.setChecked(request.getChecked());
                    // 设置新的数据到redis
                    redissonConfig.setMapCache(
                            cartCacheKey,
                            request.getItemId().toString(),
                            JSON.toJSON(cartProductDto).toString());
                }
            }
        } catch (Exception e) {
            log.error("CartServiceImp.updateCartNum Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response,e);
        }
        return response;
    }

    @Override
    public SelectAllItemResponse selectAllItem(SelectAllItemRequest request) {
        log.info("Begin: CartServiceImp selectAllItem");
        request.requestCheck();
        String cartCacheKey =  CachePrefixFactory.generatorCartKey(request.getUserId());
        SelectAllItemResponse response = new SelectAllItemResponse();
        try {
            Map<Object, Object> items = redissonConfig.getMap(cartCacheKey);
            items.values().forEach(obj ->{
                // 解析成对象
                CartProductDto cartProductDto= JSON.parseObject(obj.toString(), CartProductDto.class);
                // redis设置成全选
                cartProductDto.setChecked(request.getCheck());//true / false
                // 转换成string
                String json = JSON.toJSON(cartProductDto).toString();
                items.put(cartProductDto.getProductId().toString(),json);
            });
            response.setCode(ShoppingRetCode.SUCCESS.getCode());
            response.setMsg(ShoppingRetCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.error("CartServiceImp.selectAllItem Occur Exception :" + e);
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public AddCartResponse addToCart(AddCartRequest addCartRequest) {
        log.info("Begin: CartServiceImp addToCart");
        addCartRequest.requestCheck();
        String cartCacheKey =  CachePrefixFactory.generatorCartKey(addCartRequest.getUserId());
        AddCartResponse addCartResponse = new AddCartResponse();
        addCartResponse.setCode(ShoppingRetCode.SUCCESS.getCode());
        addCartResponse.setMsg(ShoppingRetCode.SUCCESS.getMessage());

        try {
            // check redis 是否存在此类商品信息
            if (redissonConfig.checkMapCache(
                    cartCacheKey,
                    addCartRequest.getItemId().toString())) {
                // 解析json
                String json = redissonConfig.getMapField(
                        cartCacheKey,
                        addCartRequest.getItemId().toString());

                CartProductDto cartProductDto = JSON.parseObject(json, CartProductDto.class);
                // 更新redis 产品数量
                cartProductDto.setProductNum(cartProductDto.getProductNum() + addCartRequest.getNum());
                // 设置新的数据到redis
                redissonConfig.setMapCache(
                        cartCacheKey,
                        addCartRequest.getItemId().toString(),
                        JSON.toJSON(cartProductDto).toString());

                return addCartResponse;
            }
            // sql 查询商品的具体信息
            Item item = itemMapper.selectByPrimaryKey(addCartRequest.getItemId().longValue());

            // 转换为dto 放入redis
            CartProductDto cartProductDto = CartItemConverter.item2Dto(item);
            cartProductDto.setChecked("true");
            cartProductDto.setProductNum(addCartRequest.getNum().longValue());

            // 存入缓存redis
            if (null != item) {
                redissonConfig.setMapCache(
                        cartCacheKey,
                        addCartRequest.getItemId().toString(),
                        JSON.toJSON(cartProductDto).toString()
                );
                return addCartResponse;
            }
            addCartResponse.setCode(ShoppingRetCode.SYSTEM_ERROR.getCode());
            addCartResponse.setMsg(ShoppingRetCode.SYSTEM_ERROR.getMessage());
            return addCartResponse;
        } catch (Exception e) {
            log.error("CartServiceImpl.addToCart Occur Exception :"+e);
            ExceptionProcessorUtils.wrapperHandlerException(addCartResponse, e);
        }
        return addCartResponse;
    }

}
