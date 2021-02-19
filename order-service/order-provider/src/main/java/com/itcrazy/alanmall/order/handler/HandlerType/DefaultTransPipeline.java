package com.itcrazy.alanmall.order.handler.HandlerType;

import com.itcrazy.alanmall.order.context.TransHandlerContext;
import lombok.Data;

@Data
public class DefaultTransPipeline implements TransPipeline {
    private TransHandlerContext context = null;

    private TransHandler transHandler;

    private TransHandlerNode head = new TransHandlerNode();

    private TransHandlerNode tail;

    public DefaultTransPipeline(TransHandlerContext context) {
        setContext(context);
        tail = head;
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
            if (null != handler) {
                TransHandlerNode node = new TransHandlerNode();
                node.setHandler(handler);
                node.setNext(next);
                next = node;
            }
        }
        tail = next;
    }

    @Override
    public void start() {
        try {
            tail.exec(getContext());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void shutdown() {

    }

    @Override
    public <T extends TransHandlerContext> T getContext() {
        return (T)context;
    }

    public void setContext(TransHandlerContext context) {
        this.context = context;
    }


}
