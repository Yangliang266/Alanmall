package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.RechargeHistoryDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeHistoryManager;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 卡充值记录接口实现
 * @author chenfei
 * 2018-09-16
 */
@Slf4j
@Service
public class RechargeHistoryManagerImpl implements RechargeHistoryManager{

	@Autowired
	private RechargeHistoryDao rechargeHistoryDao;

	@Override
	public List<RechargeHistory> getPageList(RechargeDto rechargeDto) {
		return rechargeHistoryDao.getPageList(rechargeDto);
	}

	@Override
	public Integer getPageTotal(RechargeDto rechargeDto) {
		return rechargeHistoryDao.getPageTotal(rechargeDto);
	}

}
