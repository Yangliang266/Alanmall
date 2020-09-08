package com.itcrazy.alanmall.common.result;

import java.io.Serializable;
import lombok.Data;

/**
 * @Description
 * @ClassName AbstracRequest
 * @author mathyoung
 * @date 2020/7/8 16:41
 */
@Data
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 4790241461359517823L;

    public abstract void requestCheck();

    @Override
    public String toString() {
        return "AbstractRequest{}";
    }

}
