package com.itcrazy.alan.leadtest.designmode;

import com.itcrazy.alan.leadtest.designmode.chain.ChianImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignModeApplicationTests {
	@Autowired
	ChianImp chianImp;

	@Test
	void contextLoads() {
		chianImp.doChain();
	}

}
