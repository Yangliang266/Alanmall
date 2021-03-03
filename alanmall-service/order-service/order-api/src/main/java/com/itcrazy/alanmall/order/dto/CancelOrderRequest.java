package com.itcrazy.alanmall.order.dto;
import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;


@EqualsAndHashCode(callSuper = true)
@Data
public class CancelOrderRequest extends AbstractRequest {
    private String orderId;

    @Override
    public void requestCheck() {
        if(StringUtils.isBlank(orderId)){
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(),OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
