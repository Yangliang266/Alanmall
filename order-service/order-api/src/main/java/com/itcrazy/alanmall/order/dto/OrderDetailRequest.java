package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

/**
 * @Auther: mathyoung
 * @description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDetailRequest extends AbstractRequest {
    private String orderId;
    private Integer status;

    @Override
    public void requestCheck() {
        if (StringUtils.isBlank(this.orderId)) {
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(), OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }

}
