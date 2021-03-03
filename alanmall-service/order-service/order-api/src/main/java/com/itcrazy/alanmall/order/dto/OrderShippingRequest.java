package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.exception.ValidateException;
import com.itcrazy.alanmall.common.result.AbstractRequest;
import com.itcrazy.alanmall.order.constant.OrderRetCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class OrderShippingRequest extends AbstractRequest {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 收货人全名
     */
    private String receiverName;

    /**
     * 固定电话
     */
    private String receiverPhone;

    /**
     * 移动电话
     */
    private String receiverMobile;

    /**
     * 省份
     */
    private String receiverState;

    /**
     * 城市
     */
    private String receiverCity;

    /**
     * 区/县
     */
    private String receiverDistrict;

    /**
     * 收货地址，如：xx路xx号
     */
    private String receiverAddress;

    /**
     * 邮政编码,如：310001
     */
    private String receiverZip;

    private Integer receiverStatus;

    private Date created;

    private Date updated;

    @Override
    public void requestCheck() {
        if (StringUtils.isBlank(orderId)) {
            throw new ValidateException(OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getCode(), OrderRetCode.REQUISITE_PARAMETER_NOT_EXIST.getMessage());
        }
    }
}
