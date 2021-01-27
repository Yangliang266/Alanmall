package com.itcrazy.alan.leadtest.designmode.chain.loadbase;

import com.itcrazy.alan.leadtest.designmode.chain.matter.Food;
import lombok.Data;

@Data
public class TransNodes {
    private TransNodes next;

    private Food food;

    public void exec() {
        food.eat();
        if (null != next) {
//            if (food.isBuy()) {
//
//            }
            next.exec();
        }
    }

}
