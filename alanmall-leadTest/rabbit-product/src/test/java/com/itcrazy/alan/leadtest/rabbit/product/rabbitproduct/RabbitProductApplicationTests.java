package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitProductApplicationTests {
	@Autowired
	RabbitProduct rabbitProduct;

	@Test
	void contextLoads() {
		rabbitProduct.send();
	}

}
