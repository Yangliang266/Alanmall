package com.itcrazy.alanmall.user.manager;

import com.itcrazy.alanmall.user.dto.*;

public interface IAddressService {
    /**
     * @Author mathyoung
     * @Description: 获取地址详情
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.user.dto.GetAddressResponse
     */
    GetAddressResponse getAddressDetails(GetAddressRequest request);

    /**
     * @Author mathyoung
     * @Description: 删除地址
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.user.dto.DeleteAddressResponse
     */
    DeleteAddressResponse deleteAddress(DeleteAddressRequest request);

    /**
     * @Author mathyoung
     * @Description: 添加地址
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.user.dto.AddressAddResponse
     */
    AddressAddResponse addAddress(AddressAddRequest request);

    /**
     * @Author mathyoung
     * @Description: 更新地址
     * @Param: [request]
     * @Return: com.itcrazy.alanmall.user.dto.AddressUpdateResponse
     */
    AddressUpdateResponse updateAddress(AddressUpdateRequest request);
}
