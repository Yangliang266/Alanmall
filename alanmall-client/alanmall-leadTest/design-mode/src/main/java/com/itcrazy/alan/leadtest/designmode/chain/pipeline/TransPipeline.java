package com.itcrazy.alan.leadtest.designmode.chain.pipeline;

import com.itcrazy.alan.leadtest.designmode.chain.matter.Food;

public interface TransPipeline extends TransOutBoundInvoker{
    void addNodeFirst(Food... foods);

    void addNodeLast(Food... foods);
}
