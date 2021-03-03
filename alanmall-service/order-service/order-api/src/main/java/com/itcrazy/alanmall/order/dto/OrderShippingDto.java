package com.itcrazy.alanmall.order.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: mathyoung
 * @description:
 */
@Data
public class OrderShippingDto implements Serializable {
    private String orderId;
    private String receiverName;
    private String receiverPhone;
    private String receiverMobile;
    private String receiverState;
    private String receiverCity;
    private String receiverDistrict;
    private String receiverAddress;
    private String receiverZip;
    private int receiverStatus;
}
