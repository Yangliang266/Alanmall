package com.itcrazy.alan.leadtest.designmode.chain.pipeline;

import com.itcrazy.alan.leadtest.designmode.chain.matter.Food;
import com.itcrazy.alan.leadtest.designmode.chain.loadbase.TransNodes;
import lombok.Data;

@Data
public class DefaultTransPipeline implements TransPipeline{
    private TransNodes tail;

    private TransNodes head = new TransNodes();

    public DefaultTransPipeline() {
        this.tail = head;
    }


    @Override
    public void addNodeFirst(Food... foods) {
        TransNodes pre = head.getNext();
        for (Food food: foods) {
            if (null == food) {
                continue;
            }
            TransNodes node = new TransNodes();
            node.setFood(food);
            node.setNext(pre);
            pre = node;
        }
        head = pre;
    }

    @Override
    public void addNodeLast(Food... foods) {
        TransNodes next = tail;
        for (Food food: foods) {
            if (null == food) {
                continue;
            }
            TransNodes now = new TransNodes();
            now.setFood(food);
            next.setNext(now);
            next = now;
        }
        tail = next;
    }

    @Override
    public void start() {
        head.getNext().exec();
    }

    @Override
    public void stop() {

    }
}
