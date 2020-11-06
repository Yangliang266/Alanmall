package com.itcrazy.alanmall.user.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import lombok.Data;

@Data
public class DeleteAddressRequest extends AbstractRequest {
    private Long addressId;
    private Long userId;

    @Override
    public void requestCheck() {
        if (null == addressId || null == userId) {
            throw new ValidateException(
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(),
                    SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
