package com.itcrazy.alanmall.user;

import com.itcrazy.alanmall.user.dto.DeleteAddressRequest;
import com.itcrazy.alanmall.user.dto.DeleteAddressResponse;
import com.itcrazy.alanmall.user.dto.GetAddressRequest;
import com.itcrazy.alanmall.user.dto.GetAddressResponse;

public interface IAddressService {
    GetAddressResponse getAddressDetails(GetAddressRequest request);

    DeleteAddressResponse deleteAddress(DeleteAddressRequest request);
}
