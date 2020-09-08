package com.itcrazy.alanmall.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mathyoung
 * @Description
 * @ClassName AbstractResponse
 * @date 2020/7/8 17:15
 */
@Data
public abstract class AbstractResponse implements Serializable {

    private static final long serialVersionUID = 4213238373892877330L;

    private String code;
    private String msg;

}
