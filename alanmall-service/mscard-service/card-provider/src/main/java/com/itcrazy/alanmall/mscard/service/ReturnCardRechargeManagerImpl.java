package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ReturnCardRechargeHistoryDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.ReturnCardRechargeManager;
import com.itcrazy.alanmall.mscard.model.ReturnCardRechargeHistory;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 退卡充值记录接口实现
 * @author softwise
 *
 */

@Slf4j
@Service
public class ReturnCardRechargeManagerImpl implements ReturnCardRechargeManager {

	@Autowired
	private ReturnCardRechargeHistoryDao returnCardRechargeHistoryDao;

	@Override
	public List<ReturnCardRechargeHistory> getPageList(RechargeDto rechargeDto) {
		return returnCardRechargeHistoryDao.getPageList(rechargeDto);
	}

	@Override
	public Integer getPageTotal(RechargeDto rechargeDto) {
		return returnCardRechargeHistoryDao.getPageTotal(rechargeDto);
	}
}






