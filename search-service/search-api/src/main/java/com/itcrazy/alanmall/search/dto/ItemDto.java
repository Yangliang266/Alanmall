package com.itcrazy.alanmall.search.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ItemDto implements Serializable {
    private static final long serialVersionUID = -809047960626248847L;

    private Long productId;

    private BigDecimal salePrice;

    private String picUrl;

    private String subTitle;

    private Long limitNum;

    private String checked;

    private String productName;

    private String productImg;
}
