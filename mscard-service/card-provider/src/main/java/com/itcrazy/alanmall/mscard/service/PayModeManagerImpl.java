package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.PayModeDao;
import com.itcrazy.alanmall.mscard.dto.Base.PayModeDto;
import com.itcrazy.alanmall.mscard.manager.PayModeManager;
import com.itcrazy.alanmall.mscard.model.PayMode;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 充值支付方式设置接口实现
 * @author zhangli
 * 2018-09-04
 */
@Slf4j
@Service
public class PayModeManagerImpl implements PayModeManager{

	@Autowired
	private PayModeDao payModeDao;

	@Override
	public List<PayMode> getPageList(PayModeDto payModeDto) {
		return payModeDao.getPageList(payModeDto);
	}

	@Override
	public int updatePayMode(PayMode payMode) {
		return payModeDao.update(payMode);
	}

	@Override
	public PayMode addPayMode(PayMode payMode) {
		payModeDao.save(payMode);
		return payMode;
	}

}
