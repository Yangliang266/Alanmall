package com.itcrazy.alan.leadtest.designmode.chain;

import com.itcrazy.alan.leadtest.designmode.chain.matter.Bread;
import com.itcrazy.alan.leadtest.designmode.chain.matter.Chips;
import com.itcrazy.alan.leadtest.designmode.chain.matter.InstantNoodles;
import com.itcrazy.alan.leadtest.designmode.chain.pipeline.DefaultTransPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChianImp {
    @Autowired
    Bread bread;

    @Autowired
    Chips chips;

    @Autowired
    InstantNoodles instantNoodles;

    public void doChain() {
        DefaultTransPipeline pipeline = new DefaultTransPipeline();
        pipeline.addNodeLast(bread);
        pipeline.addNodeLast(chips);
        pipeline.addNodeLast(instantNoodles);
        pipeline.start();
    }
}
