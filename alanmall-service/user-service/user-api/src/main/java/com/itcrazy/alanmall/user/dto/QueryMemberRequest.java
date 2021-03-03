package com.itcrazy.alanmall.user.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class QueryMemberRequest extends AbstractRequest {
    private static final long serialVersionUID = 3722427112800721315L;

    private Long userId;

    @Override
    public void requestCheck() {
        if (null == userId) {
            throw new ValidateException(SysRetCodeConstants.REQUEST_CHECK_FAILURE.getCode(), SysRetCodeConstants.REQUEST_CHECK_FAILURE.getMessage());
        }
    }
}
