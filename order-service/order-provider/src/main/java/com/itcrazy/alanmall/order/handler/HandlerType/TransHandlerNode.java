package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.TransHandlerContext;
import lombok.Data;

@Data
public class TransHandlerNode {
    private TransHandler handler;

    private TransHandlerNode next;

    public void exec(TransHandlerContext context) {
        AbstracTransHandler transHandler = (AbstracTransHandler) handler;
        if (null != transHandler) {
            boolean success = transHandler.doHandler(context);
            if (null != next) {
                if (success) {
                    if (handler.isAysc()) {
                        // todo
                    }
                    next.exec(context);
                }
            }
        }
    }
}
