package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 充值撤销DAO层接口
 * @author chenfei
 * 2018-11-08
 */
@Component
public interface RechargeRevokeDao extends BaseDao<RechargeHistory, Long> {

	public List<RechargeHistory> getPageList(RechargeDto rechargeDto);

	public Integer getPageTotal(RechargeDto rechargeDto);

	public int revokeById(@Param("id") Long id, @Param("remarks") String remarks, @Param("userId") Long userId);
}
