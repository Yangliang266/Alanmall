package com.itcrazy.alanmall.shopping.dto.sqldto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageInfoDto implements Serializable {
    private static final long serialVersionUID = 3995101103581222820L;

    private Integer page;

    private Integer size;

    private String sort;

    private Integer priceGt;

    private Integer priceLte;

    private Long cid;

    private String orderCol;

    private String orderDir;
}

