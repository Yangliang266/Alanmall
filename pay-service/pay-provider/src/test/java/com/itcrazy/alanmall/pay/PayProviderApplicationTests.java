package com.itcrazy.alanmall.pay;

import com.itcrazy.alanmall.pay.biz.payfactory.BasePayment;
import com.itcrazy.alanmall.pay.dto.PaymentRequest;
import com.itcrazy.alanmall.pay.starter.PayProviderApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = PayProviderApplication.class)
@RunWith(SpringRunner.class)

class PayProviderApplicationTests {

	@Test
	void contextLoads() throws Exception {
		// ali_pay wechat_pay
		PaymentRequest request = new PaymentRequest();
		request.setPayChannel("wechat_pay");
		request.setOrderFee(BigDecimal.valueOf(0.01));
		request.setTradeNo("15522006365220210");
		request.setUserId(62L);
		request.setTotalFee(BigDecimal.valueOf(0.01));
		request.setAddressId(12L);
		request.setSubject("order");
		request.setSpbillCreateIp("192.168.89.1");
		System.out.println(BasePayment.getInstance().get(request.getPayChannel()).process(request).getMsg());

//		Map<String, Object> map = new HashMap<>();
//
//		map.put("test", this);
//
//		System.out.println(map.get("test"));

	}

}
