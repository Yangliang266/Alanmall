package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.TransHandlerContext;
import lombok.Data;

@Data
public class DefaultTransPipeline implements TransPipeline {
    private TransHandlerContext context;

    private TransHandler transHandler;

    private TransHandlerNode head = new TransHandlerNode();

    private TransHandlerNode tail;

    public DefaultTransPipeline(TransHandlerContext context) {
        this.context = context;
        this.tail = head;
    }

    @Override
    public void addFirstNode(TransHandler... handlers) {
        TransHandlerNode pre = head.getNext();
        for (TransHandler handler: handlers) {
            if (null == handler) {
                continue;
            }
            TransHandlerNode node = new TransHandlerNode();
            node.setHandler(handler);
            node.setNext(pre);
            pre = node;
        }
        head = pre;
    }

    @Override
    public void addLastNode(TransHandler... handlers) {
        TransHandlerNode next = tail;
        for (TransHandler handler: handlers) {
            if (null == handler) {
                continue;
            }
            TransHandlerNode node = new TransHandlerNode();
            node.setHandler(handler);
            node.setNext(next);
            next = node;
        }
        tail = next;
    }

    @Override
    public void start() {
        this.head.getNext().exec(this.context);
    }

    @Override
    public void shutdown() {

    }
}
