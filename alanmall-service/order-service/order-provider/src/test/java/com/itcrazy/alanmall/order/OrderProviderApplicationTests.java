package com.itcrazy.alanmall.order;

import com.itcrazy.alanmall.order.context.CreateOrderContext;
import com.itcrazy.alanmall.order.context.TransHandlerContext;
import com.itcrazy.alanmall.order.handler.HandlerType.ValidateHandler;
import com.itcrazy.alanmall.order.starter.OrderProviderApplication;
import com.itcrazy.alanmall.order.utils.GlobalIdGeneratorUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderProviderApplication.class)
class OrderProviderApplicationTests {

	private final String ORDER_GLOBAL_ID_CACHE_KEY="ORDER_ID";
	private final String ORDER_ITEM_GLOBAL_ID_CACHE_KEY="ORDER_ITEM_ID";

	@Autowired
	ValidateHandler validateHandler;


	@Autowired
	GlobalIdGeneratorUtil globalIdGeneratorUtil;

	@Test
	void contextLoads() {
//		CreateOrderContext context = new CreateOrderContext();
//		context.setUserId((long) 62);
//		validateHandler.doHandler(context);

		System.out.println(globalIdGeneratorUtil.getNextSeq(ORDER_GLOBAL_ID_CACHE_KEY,1));
	}

}
