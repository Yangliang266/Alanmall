package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeHistoryManager;
import com.itcrazy.alanmall.mscard.manager.RechargeManager;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.RechargeHistoryVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import java.util.ArrayList;
import java.util.List;

/**
 * 卡充值记录
 * @author chenfei
 * 2018-09-13
 */
public class RechargeHistoryAction extends InterfaceBaseAction{

	private static final long serialVersionUID = -2504724997904054974L;

	@Reference
	RechargeManager rechargeManager;
	@Reference
	RechargeHistoryManager rechargeHistoryManager;
	@Reference
	UserManager userManager;
	@Reference
	StoreManager storeManager;

	public String cardNo;

	private RechargeDto rechargeDto;

	public String getRechargeHistoryList(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}

		pageSet(rechargeDto);
		rechargeDto.setCompanyId(user.getCompanyId());
		rechargeDto.setCardNo(cardNo);
		List<RechargeHistory> rechargeHistoryList = rechargeHistoryManager.getPageList(rechargeDto);
		List<RechargeHistoryVo> rechargeHistoryVoList = new ArrayList<>();

		if(rechargeHistoryList != null && rechargeHistoryList.size()>0){

			for(RechargeHistory rh : rechargeHistoryList){
				RechargeHistoryVo rhv = new RechargeHistoryVo();

				rhv.setCardNo(rh.getCardNo()+"");
				rhv.setCategoryName(rh.getCategoryName());
				rhv.setPayModeStr(rh.getPayModeStr());
				rhv.setRechargeAmount(rh.getRechargeAmount().toString());
				rhv.setRechargeTime(DateFormat.dateToString(rh.getRechargeTime()));
				rhv.setReward(rh.getReward().toString());
				rhv.setStatus(KeyValueConvert.getCardStatusValue(rh.getStatus()));

				Store rechargeStore = storeManager.getStoreById(rh.getRechargeStore());
				rhv.setRechargeStore(rechargeStore != null ? rechargeStore.getName() : "卡中心");

				User rechargePerson = userManager.getUserById(rh.getRechargePerson());
				rhv.setRechargePerson(rechargePerson != null ? rechargePerson.getRealName() : "");

				rhv.setActionType(rh.getActionType() == null ?  "充值" : "撤销");
				rhv.setRemarks(rh.getRemarks());
				rechargeHistoryVoList.add(rhv);
			}
		}

		pageData.rows = rechargeHistoryVoList;
		Integer t = rechargeHistoryManager.getPageTotal(rechargeDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
