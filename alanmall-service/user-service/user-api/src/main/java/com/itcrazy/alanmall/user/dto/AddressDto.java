package com.itcrazy.alanmall.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDto implements Serializable {
    private static final long serialVersionUID = 3955992822577072327L;
    private Long addressId;

    private Long userId;

    private String userName;

    private String tel;

    private String streetName;

    private Integer isDefault;
}
