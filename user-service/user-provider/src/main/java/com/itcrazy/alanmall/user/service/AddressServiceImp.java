package com.itcrazy.alanmall.user.service;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.cache.CachePrefixFactory;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import com.itcrazy.alanmall.user.IAddressService;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.converter.AddressConverter;
import com.itcrazy.alanmall.user.dal.entity.Address;
import com.itcrazy.alanmall.user.dal.mapper.AddressMapper;
import com.itcrazy.alanmall.user.dto.*;
import com.itcrazy.alanmall.user.utils.ExceptionProcessorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@DubboService
@Slf4j
public class AddressServiceImp implements IAddressService {
    @Autowired
    RedissonConfig redissonClient;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AddressConverter addressConverter;

    @Override
    public GetAddressResponse getAddressDetails(GetAddressRequest request) {
        log.info("Begin: IaddressService.getAddressDetails.request: " + request);
        request.requestCheck();
        String key = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.USER_INFO);
        String field = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.ADDRESS_CACHE_KEY);
        GetAddressResponse response = new GetAddressResponse();
        response.setCode(SysRetCodeConstants.SUCCESS.getCode());
        response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        try {
            // redis 缓存
            String json = redissonClient.getMapField(key, field);
            if(StringUtils.isNotBlank(json)) {
                List<AddressDto> addressDtoList = JSON.parseArray(json, AddressDto.class);
                response.setAddressDtos(addressDtoList);
                log.info("End: IaddressService.getAddressDetails.response: " + response);
                return response;
            }

            // 高并发 防止雪崩，加锁
            // sql 查询set
            Example example = new Example(Address.class);
            example.createCriteria().andEqualTo("userId",request.getUserId());
            List<Address> addressDtos = addressMapper.selectByExample(example);

            // redis 存储
            List<AddressDto> addressDtoList = addressConverter.address2List(addressDtos);
            redissonClient.setMapCache(key, field, JSON.toJSON(addressDtoList).toString());
            response.setAddressDtos(addressDtoList);
        } catch (Exception e) {
            log.error("Error: IaddressService.getAddressDetails.Exception: " + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        log.info("End: IaddressService.getAddressDetails.response: " + response);
        return response;
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        log.info("Begin: IaddressService.deleteAddress.request: " + request);
        request.requestCheck();
        String key = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.USER_INFO);
        String field = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.ADDRESS_CACHE_KEY);
        DeleteAddressResponse response = new DeleteAddressResponse();
        try {
            redissonClient.removeMapCache(key, field);
            //采用延时双删
            Example example = new Example(Address.class);
            example.createCriteria().andEqualTo("addressId",request.getAddressId());
            addressMapper.deleteByExample(example);
            Thread.sleep(1000);
            redissonClient.removeMapCache(key, field);

            response.setCode(SysRetCodeConstants.SUCCESS.getCode());
            response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        } catch (Exception e) {
            log.error("Error: IaddressService.deleteAddress.Exception: " + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }

        log.info("End: IaddressService.deleteAddress.response: " + response);
        return response;
    }

    @Override
    public AddressAddResponse addAddress(AddressAddRequest request) {
        log.info("Begin: IaddressService.addAddress.request: " + request);
        request.requestCheck();
        AddressAddResponse response = new AddressAddResponse();
        String key = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.USER_INFO);
        String field = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.ADDRESS_CACHE_KEY);

        try {
            // 延时双删
            redissonClient.removeMapCache(key, field);
            Address address = addressConverter.addReq2Address(request);
            int row = addressMapper.insert(address);
            if (row > 0) {
                response.setCode(SysRetCodeConstants.SUCCESS.getCode());
                response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
            }
            // 延时双删
            Thread.sleep(1000);
            redissonClient.removeMapCache(key, field);

        } catch (Exception e) {
            log.error("Error: IaddressService.addAddress.Exception: " + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }

        log.info("End: IaddressService.addAddress.response: " + response);
        return response;
    }

    @Override
    public AddressUpdateResponse updateAddress(AddressUpdateRequest request) {
        log.info("Begin :IaddressService.updateAddress.request: " + request);
        request.requestCheck();
        AddressUpdateResponse response = new AddressUpdateResponse();
        String key = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.USER_INFO);
        String field = CachePrefixFactory.generatorKey(request.getUserId(), CachePrefixFactory.ADDRESS_CACHE_KEY);
        try {
            // 延时双删
            redissonClient.removeMapCache(key, field);

            Address address = addressConverter.upRes2Address(request);
            int row = addressMapper.updateByPrimaryKey(address);
            if (row > 0) {
                response.setCode(SysRetCodeConstants.SUCCESS.getCode());
                response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
            }
            // 延时双删
            Thread.sleep(1000);
            redissonClient.removeMapCache(key, field);

        } catch (Exception e) {
            log.error("Error: IaddressService.updateAddress.Exception: " + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }

        log.info("End: IaddressService.updateAddress.response: " + response);
        return response;
    }

}
