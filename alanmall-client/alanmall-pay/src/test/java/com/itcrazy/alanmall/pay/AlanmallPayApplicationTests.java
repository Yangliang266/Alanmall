package com.itcrazy.alanmall.pay;

import com.itcrazy.alanmall.pay.starter.AlanmallPayApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = AlanmallPayApplication.class)
@RunWith(SpringRunner.class)
class AlanmallPayApplicationTests {
//    @Resource
//    PayController payController;

    @Test
    void contextLoads() {
//        PayForm request = new PayForm();
//        request.setPayType("wechat_pay");
//        request.setMoney(BigDecimal.valueOf(0.01));
//        request.setOrderId("15522006365220218");
//        request.setInfo("order1");
//        request.setNickName("test");
//        payController.cashier(request);

        System.out.println(new Date());
    }

}
