package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeManager;
import com.itcrazy.alanmall.mscard.manager.RechargeRevokeManager;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.RechargeHistoryVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡充值撤销
 * @author chenfei
 * 2018-11-08
 */
public class RechargeRevokeAction extends InterfaceBaseAction{

	private static final long serialVersionUID = 1806266482584582343L;

	@Reference
	RechargeManager rechargeManager;
	@Reference
	RechargeRevokeManager rechargeRevokeManager;
	@Reference
	UserManager userManager;
	@Reference
	StoreManager storeManager;

	public String cardNo;
	public String remarks;
	public Long id;

	private RechargeDto rechargeDto;

	public String getRechargeRevokeList(){
		if(rechargeDto == null){
			rechargeDto = new RechargeDto();
		}

		pageSet(rechargeDto);
		rechargeDto.setCompanyId(user.getCompanyId());
		rechargeDto.setCardNo(cardNo);
		List<RechargeHistory> rechargeHistoryList = rechargeRevokeManager.getPageList(rechargeDto);
		List<RechargeHistoryVo> rechargeHistoryVoList = new ArrayList<>();

		if(rechargeHistoryList != null && rechargeHistoryList.size()>0){

			for(RechargeHistory rh : rechargeHistoryList){
				RechargeHistoryVo rhv = new RechargeHistoryVo();
				rhv.setId(rh.getId());
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

				rechargeHistoryVoList.add(rhv);
			}
		}

		pageData.rows = rechargeHistoryVoList;
		Integer t = rechargeRevokeManager.getPageTotal(rechargeDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String updateRechargeRevoke(){
		if(id == null){
			result.setResultInfo(-1, "ID丢失，撤销失败。");
			return SUCCESS;
		}

		if(StringUtils.isBlank(cardNo)){
			result.setResultInfo(-1, "卡号丢失，撤销失败。");
			return SUCCESS;
		}

		if(StringUtils.isNotBlank(remarks) && remarks.length() > 60){
			result.setResultInfo(-1, "备注需少于60个字符，撤销失败。");
			return SUCCESS;
		}

		try {
			result = rechargeRevokeManager.revokeById(id, cardNo, remarks,user.getStoreId(), user.getCompanyId(),user.getId());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "系统异常，撤销失败。");
			return SUCCESS;
		}
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
