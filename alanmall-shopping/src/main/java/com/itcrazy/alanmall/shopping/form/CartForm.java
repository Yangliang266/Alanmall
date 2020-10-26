package com.itcrazy.alanmall.shopping.form;/**
 * Created by mic on 2019/7/26.
 */

import lombok.Data;

@Data
//@ApiModel
public class CartForm {
//    @ApiModelProperty(name = "userId", value = "用户ID", example = "10000")
    private Long userId;

//    @ApiModelProperty(name = "productId", value = "产品ID", example = "10000")
    private Long productId;

//    @ApiModelProperty(name = "checked", value = "是否选中")
    private String checked;

//    @ApiModelProperty(name = "productNum", value = "商品数量", example = "1")
    private Integer productNum;
}
