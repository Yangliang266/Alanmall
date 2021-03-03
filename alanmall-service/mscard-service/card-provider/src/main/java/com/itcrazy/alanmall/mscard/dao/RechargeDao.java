package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.Recharge;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 充值DAO层接口
 * @author chenfei
 * 2018-09-14
 */
@Component
public interface RechargeDao extends BaseDao<Recharge, Long> {

	public List<Recharge> getHeadPageList(RechargeDto rechargedto);

	public Integer getHeadPageTotal(RechargeDto rechargedto);

	public List<Recharge> getStorePageList(RechargeDto rechargedto);

	public Integer getStorePageTotal(RechargeDto rechargedto);
}
