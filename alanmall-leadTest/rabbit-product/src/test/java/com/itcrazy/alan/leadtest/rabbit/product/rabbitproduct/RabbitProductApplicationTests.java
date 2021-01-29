package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct;

import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.starter.RabbitProductApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitProductApplication.class)
class RabbitProductApplicationTests {
	@Autowired
	RabbitProduct rabbitProduct;

	@Test
	void contextLoads() {
//		rabbitProduct.send();
		Date date = new Date();//获取当前的日期
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String str = df.format(date);//获取String类型的时间
		System.out.println(str);
	}

}
