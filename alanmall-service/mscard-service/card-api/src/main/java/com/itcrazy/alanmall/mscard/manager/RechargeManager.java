package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.model.Recharge;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;

import java.util.List;

/**
 * 卡充值接口
 * @author chenfei
 * 2018-09-13
 */
public interface RechargeManager {

	/**
	 * 总部充值页面列表数据
	 * @param rechargedto
	 * @return
	 */
	public List<Recharge> getHeadPageList(RechargeDto rechargedto);

	/**
	 * 总部充值页面列表数据总条数
	 * @param rechargedto
	 * @return
	 */
	public Integer getHeadPageTotal(RechargeDto rechargedto);

	/**
	 * 门店充值页面列表数据
	 * @param rechargedto
	 * @return
	 */
	public List<Recharge> getStorePageList(RechargeDto rechargedto);

	/**
	 * 门店充值页面列表数据总条数
	 * @param rechargedto
	 * @return
	 */
	public Integer getStorePageTotal(RechargeDto rechargedto);

	/**
	 * 总部充值
	 * @param rechargeHistoryList
	 * @throws Exception
	 */
	public void updateHeadRecharge(List<RechargeHistory> rechargeHistoryList) throws Exception;

	/**
	 * 门店充值
	 * @param rechargeHistoryList
	 * @throws Exception
	 */
	public void updateStoreRecharge(List<RechargeHistory> rechargeHistoryList) throws Exception;

}
