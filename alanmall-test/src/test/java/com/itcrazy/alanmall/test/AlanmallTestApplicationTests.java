package com.itcrazy.alanmall.test;

import com.itcrazy.alanmall.test.controller.rabbit.RabbitProduct;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlanmallTestApplication.class)
class AlanmallTestApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//    @Autowired
//    Product product;


    @Autowired
    RabbitProduct rabbitProduct;

//    @Test
//    public void syncSendTest(){
//        product.sync();
//    }

    @Test
    void contextLoads() {
        rabbitProduct.send();
    }

//    @Test
//    public void syncConsume() {
//        consume.onMessage();
//    }

}
