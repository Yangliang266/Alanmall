package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import com.itcrazy.alanmall.common.vo.Result;

import java.util.List;

/**
 * 卡充值撤销接口
 * @author chenfei
 * 2018-11-08
 */
public interface RechargeRevokeManager {

	public List<RechargeHistory> getPageList(RechargeDto rechargeDto);

	public Integer getPageTotal(RechargeDto rechargeDto);

	public Result revokeById(Long id, String cardNo, String remarks, Long storeId, Long companyId, Long userId);
}
