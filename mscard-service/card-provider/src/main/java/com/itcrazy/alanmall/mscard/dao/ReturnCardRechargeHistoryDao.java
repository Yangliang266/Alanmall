package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.ReturnCardRechargeHistory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 退卡充值记录接口
 */

@Component
public interface ReturnCardRechargeHistoryDao extends BaseDao<ReturnCardRechargeHistory, Long> {

	public List<ReturnCardRechargeHistory> getPageList(RechargeDto rechargeDto);

	public Integer getPageTotal(RechargeDto rechargeDto);



}
