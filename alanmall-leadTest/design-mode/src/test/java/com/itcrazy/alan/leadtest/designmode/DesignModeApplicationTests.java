package com.itcrazy.alan.leadtest.designmode;

import com.itcrazy.alan.leadtest.designmode.chain.ChianImp;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignModeApplicationTests {
	@Autowired
	ChianImp chianImp;

//	@Autowired
//	QuartzTest quartzTest;
//
//	@Test
//	void contextLoads() throws SchedulerException {
////		chianImp.doChain();
//		quartzTest.test();
//	}

}
