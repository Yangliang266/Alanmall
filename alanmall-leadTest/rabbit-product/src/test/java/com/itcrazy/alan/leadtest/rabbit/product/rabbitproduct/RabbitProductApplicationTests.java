package com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct;

import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.model.Company;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.model.Product;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.producer.Producer;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.starter.RabbitProductApplication;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.test.CacheFactory;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.test.CacheTest;
import com.itcrazy.alan.leadtest.rabbit.product.rabbitproduct.test.ThreadTest;
import com.itcrazy.alanmall.common.redis.config.RedissonConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RCountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitProductApplication.class)
class RabbitProductApplicationTests {
//	@Autowired
//	RabbitProduct rabbitProduct;

//	@Autowired
//	Producer produce;

	@Autowired
	RedissonConfig redissonConfig;

	@Test
	void contextLoads() {
//		rabbitProduct.send();
//		Date date = new Date();//获取当前的日期
//		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//		String str = df.format(date);//获取String类型的时间
//		System.out.println(str);

//
//		List<Long> itemIds = new ArrayList<>();
//		itemIds.add((long) 555);
//		itemIds.add((long) 111);
//		itemIds.add((long) 666);
//		itemIds.add((long) 444);
//		//排序
////		itemIds.sort(Long::compareTo);
//
//		System.out.println(itemIds);

//		Product iphone7 = new Product("Iphone 7");
//		Product iPadPro = new Product("IPadPro");
//
//		List<Product> appleProducts = new ArrayList<Product>(Arrays.asList(iphone7, iPadPro));
//
//		Company apple = new Company("Apple", appleProducts);
//
//		iphone7.setCompany(apple);
//		iPadPro.setCompany(apple);

		/*
		 * send message to RabbitMQ
		 */
//		produce.produce(apple);



		CacheTest cacheTest2 = CacheFactory.getCache("01");
		cacheTest2.setAddress("11111111");
		cacheTest2.setAddress("000000000");


//		ThreadTest threadTest = new ThreadTest();
//		threadTest.start();

		new Thread(() -> {
			RCountDownLatch rCountDownLatch = redissonConfig.getMqLock("thread",1);
			try {
				CacheTest cacheTest = CacheFactory.cacheTest1;
				cacheTest.setAddress("2222222");
				cacheTest.setName("3333333");
				System.out.println("thread is runing");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rCountDownLatch.countDown();
			}
		}).start();

		RCountDownLatch rCountDownLatch = redissonConfig.getMqLock("thread",1);
		try {
			rCountDownLatch.await();
			CacheTest cacheTest = CacheFactory.cacheTest1;
			System.out.println(cacheTest);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
