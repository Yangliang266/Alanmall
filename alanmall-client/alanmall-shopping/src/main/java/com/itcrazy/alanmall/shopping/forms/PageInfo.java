package com.itcrazy.alanmall.shopping.forms;

import lombok.Data;

@Data
public class PageInfo {
    private Integer page;

    private Integer size;

    private String sort;

    private Integer priceGt;

    private Integer priceLte;

    private Long cid;

    private Integer status;
}
