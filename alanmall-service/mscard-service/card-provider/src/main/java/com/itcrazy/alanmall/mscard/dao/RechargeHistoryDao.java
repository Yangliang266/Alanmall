package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 充值记录DAO层接口
 * @author chenfei
 * 2018-09-14
 */
@Component
public interface RechargeHistoryDao extends BaseDao<RechargeHistory, Long> {

	public List<RechargeHistory> getPageList(RechargeDto rechargeDto);

	public Integer getPageTotal(RechargeDto rechargeDto);

	public void insertRechargeHistory(RechargeHistory rechargeHistory);

	public RechargeHistory getRechargeHistoryById(@Param("id") Long id, @Param("companyId") Long companyId);
}
