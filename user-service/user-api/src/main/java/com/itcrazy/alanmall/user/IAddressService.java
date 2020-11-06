package com.itcrazy.alanmall.user;

import com.itcrazy.alanmall.user.dto.*;

public interface IAddressService {
    GetAddressResponse getAddressDetails(GetAddressRequest request);

    DeleteAddressResponse deleteAddress(DeleteAddressRequest request);

    AddressAddResponse addAddress(AddressAddRequest request);

    AddressUpdateResponse updateAddress(AddressUpdateRequest request);
}
