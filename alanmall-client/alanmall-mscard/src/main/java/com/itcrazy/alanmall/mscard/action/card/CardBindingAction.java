package com.itcrazy.alanmall.mscard.action.card;

import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.manager.CardBindingManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.Credit;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.vo.card.CreditVo;
import org.apache.dubbo.config.annotation.Reference;

import java.util.ArrayList;
import java.util.List;


/**
 * 子卡绑定
 * @author zhangzt
 * 2018-09-29
 */
public class CardBindingAction extends InterfaceBaseAction{
	private static final long serialVersionUID = 5662380027932802248L;

	private CreditDto creditDto;
	private String[] cardNumbers;
	private String motherCardNo;
	private Integer creditMaxQuota;

	@Reference
	CardBindingManager cardBindingManager;

	/*
	 * 未绑定子卡一览
	 */
	public String getCardBindingList() {
		if(creditDto == null) {
			creditDto = new CreditDto();
		}
		creditDto.setCompanyId(user.getCompanyId());
		List<Credit> creditList = cardBindingManager.getCardBindingList(creditDto);
		List<CreditVo> creditVoList = new ArrayList<CreditVo>();

		if (creditList != null && creditList.size() > 0) {

			for (Credit c : creditList) {
				CreditVo cv = new CreditVo();

				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setUserName(c.getUserName());
				cv.setSex(KeyValueConvert.getCardSexValue(c.getSex()));
				cv.setTelephone(c.getTelephone());
				cv.setIdNumber(c.getIdNumber());
				cv.setCreditMaxQuota(c.getCreditMaxQuota());
				cv.setStatus(KeyValueConvert.getCardStatusValue(c.getStatus()));
				cv.setCreditStatus(KeyValueConvert.getCreditStatusValue(c.getCreditStatus()));

				creditVoList.add(cv);
			}
		}

		pageData.rows = creditVoList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	/*
	 * 绑定子卡
	 */
	public String updateCardBinding() {
		if (cardNumbers == null) {
			result.setParamErrorInfo("cardNumbers");
			return SUCCESS;
		}
		if (motherCardNo == null) {
			result.setParamErrorInfo("motherCardNo");
			return SUCCESS;
		}
		if (creditMaxQuota == null) {
			result.setParamErrorInfo("creditMaxQuota");
			return SUCCESS;
		}
		List<ActiveInformation> activeInfoList = new ArrayList<>();
		for(String subCardNo : cardNumbers) {
			ActiveInformation active = new ActiveInformation();
			active.setCardNo(subCardNo);
			active.setMotherCardNo(motherCardNo);
			active.setCreditMaxQuota(creditMaxQuota);
			active.setCreditStatus(0);
			active.setUpdateId(user.getId());
			active.setCompanyId(user.getCompanyId());
			activeInfoList.add(active);

		}
		// 子卡绑定（更新激活卡信息表、母卡信息复制到子卡）
		try {
			int retValue = cardBindingManager.bindSubCrads(activeInfoList);
			if(retValue == 1) {
				result.setResultInfo(1, "母卡未设置挂账额度规则，子卡无法绑定。");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	public CreditDto getCreditDto() {
		return creditDto;
	}

	public void setCreditDto(CreditDto creditDto) {
		this.creditDto = creditDto;
	}

	public String[] getCardNumbers() {
		return cardNumbers;
	}

	public void setCardNumbers(String[] cardNumbers) {
		this.cardNumbers = cardNumbers;
	}

	public String getMotherCardNo() {
		return motherCardNo;
	}

	public void setMotherCardNo(String motherCardNo) {
		this.motherCardNo = motherCardNo;
	}

	public Integer getCreditMaxQuota() {
		return creditMaxQuota;
	}

	public void setCreditMaxQuota(Integer creditMaxQuota) {
		this.creditMaxQuota = creditMaxQuota;
	}

}
