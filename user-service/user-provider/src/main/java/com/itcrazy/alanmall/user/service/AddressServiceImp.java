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
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Slf4j
public class AddressServiceImp implements IAddressService {
    @Autowired
    RedissonConfig redissonConfig;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    AddressConverter addressConverter;

    @Override
    public GetAddressResponse getAddressDetails(GetAddressRequest request) {
        log.info("Begin:IaddressService.getAddressDetails");
        String key = CachePrefixFactory.generatorCartKey(request.getUserId());
        String field = CachePrefixFactory.generatorAddressKey(request.getUserId());
        GetAddressResponse response = new GetAddressResponse();
        response.setCode(SysRetCodeConstants.SUCCESS.getCode());
        response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());
        try {
            // redis 缓存
            String json = redissonConfig.getMapField(key, field);
            if(StringUtils.isNotBlank(json)) {
                List<AddressDto> addressDtoList = JSON.parseArray(json, AddressDto.class);
                response.setAddressDtos(addressDtoList);
            }

            // sql 查询
            Example example = new Example(Address.class);
            example.createCriteria().andEqualTo("userId",request.getUserId());
            List<Address> addressDtos = addressMapper.selectByExample(example);

            // redis 存储
            List<AddressDto> addressDtoList = addressConverter.address2List(addressDtos);
            redissonConfig.setMapCache(key, field, JSON.toJSON(addressDtoList).toString());
            response.setAddressDtos(addressDtoList);
        } catch (Exception e) {
            log.error("Error:IaddressService.getAddressDetails:" + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest request) {
        log.info("Begin:IaddressService.deleteAddress");
        String key = CachePrefixFactory.generatorCartKey(request.getUserId());
        String field = CachePrefixFactory.generatorAddressKey(request.getUserId());
        DeleteAddressResponse response = new DeleteAddressResponse();
        response.setCode(SysRetCodeConstants.SUCCESS.getCode());
        response.setMsg(SysRetCodeConstants.SUCCESS.getMessage());

        try {
            redissonConfig.removeMapCache(key, field);
            //采用延时双删
            Example example = new Example(Address.class);
            example.createCriteria().andEqualTo("addressId",request.getAddressId());
            addressMapper.deleteByExample(example);
            Thread.sleep(500);
            redissonConfig.removeMapCache(key, field);

        } catch (Exception e) {
            log.error("Error:IaddressService.deleteAddress:" + e );
            ExceptionProcessorUtils.wrapperHandlerException(response, e);
        }
        return response;
    }

}
