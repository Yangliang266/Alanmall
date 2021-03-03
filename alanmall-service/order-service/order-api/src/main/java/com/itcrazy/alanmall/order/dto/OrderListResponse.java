package com.itcrazy.alanmall.order.dto;

import com.itcrazy.alanmall.common.result.AbstractResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class OrderListResponse extends AbstractResponse {

    private List<OrderDetailInfo> detailInfoList;

    /**
     * 总记录数
     */
    private Long total;

}