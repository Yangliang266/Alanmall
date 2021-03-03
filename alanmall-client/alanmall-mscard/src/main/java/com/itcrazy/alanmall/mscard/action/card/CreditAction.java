package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.manager.CreditManager;
import com.itcrazy.alanmall.mscard.model.Credit;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.mscard.vo.card.CreditVo;
import com.itcrazy.alanmall.user.manager.UserManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 挂账管理
 * @author luxf
 * 2018-09-26
 */
public class CreditAction extends InterfaceBaseAction{

	private static final long serialVersionUID = -2637549889945818883L;

	private Credit detail;
	private CreditVo detailVo;
	private CreditVo detailVoList;
	private CreditDto creditDto;
	private String cardNo;
	private Long categoryId;

	@Reference
	CreditManager creditManager;
	@Reference
	UserManager userManager;

	// 老卡初始化页面不显示
	public String getCreditList(){
		return null;
	}

	// 卡信息记录
	public String getCreditDetail(){

		if(creditDto == null){
			creditDto = new CreditDto();
		}
		// 获取商家id
		creditDto.setCompanyId(user.getCompanyId());
		detail = creditManager.getPageList(creditDto);

		if (detail != null) {
			detailVo = new CreditVo();
			detailVo.setCardNo(detail.getCardNo());
			detailVo.setName(detail.getName());
			detailVo.setMotherCardNo(detail.getMotherCardNo());
			detailVo.setCardType(detail.getCardType());
			detailVo.setUserName(detail.getUserName());
			detailVo.setSex(KeyValueConvert.getCardSexValue(detail.getSex()));
			detailVo.setTelephone(detail.getTelephone());
			detailVo.setIdNumber(detail.getIdNumber());
			detailVo.setRechargeBalance(String.valueOf(detail.getRechargeBalance()));
			detailVo.setReward(String.valueOf(detail.getReward()));
			detailVo.setCreditStatus(KeyValueConvert.getCreditStatusValue(detail.getCreditStatus()));
			detailVo.setCreditMaxQuota(detail.getCreditMaxQuota());
			detailVo.setCredit(String.valueOf(detail.getCredit()));
			detailVo.setCreditChildMaxQuota(detail.getCreditChildMaxQuota());
			detailVo.setAllJoinBrands(detail.getAllJoinBrands());
			detailVo.setCategoryId(detail.getCategoryId());
			detailVo.setIsCredit(String.valueOf(detail.getIsCredit()));
			if(detail.getMotherType() == null) {
				detailVo.setMotherType(0);
			}else {
				detailVo.setMotherType(1);
			}
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	// 子卡页面显示
	public String getCreditHistory() {

		if (creditDto == null) {
			creditDto = new CreditDto();
		}

		pageSet(creditDto);
		creditDto.setCompanyId(user.getCompanyId());

		List<Credit> creditList = creditManager.getCreditHistory(creditDto);
		List<CreditVo> creditVoList = new ArrayList<CreditVo>();

		if (creditList != null && creditList.size() > 0) {

			for (Credit c : creditList) {
				CreditVo cv = new CreditVo();

				cv.setCardNo(c.getCardNo());
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
		int iRows = creditManager.getHistoryPageTotal(creditDto);
		pageData.setTotal(iRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取单个卡类别详细
	 * @return
	 */
	public String getCreditPrepare(){

		if (creditDto == null) {
			creditDto = new CreditDto();
		}
		creditDto.setCompanyId(user.getCompanyId());

		List<Credit> creditList = creditManager.getCreditById(creditDto);
		List<CreditVo> creditVoList = new ArrayList<CreditVo>();

		if(creditList != null && creditList.size()>0){

			for(Credit c : creditList){
				CreditVo cv = new CreditVo();

				cv.setCreditQuota(c.getCreditQuota());
				cv.setCreditSettingList(c.getCreditSettingList());

				if (c.getType() == CardConstants.CARD_DISCOUNT_TYPE_BRAND) {
					c.setCode("b" + c.getCode());
				}

				cv.setCode(c.getCode());
				creditVoList.add(cv);
			}
		}
		pageData.rows = creditVoList;


		result.setSuccessInfo();
		return SUCCESS;
	}

	public CreditDto getCreditDto() {
		return creditDto;
	}

	public void setCreditDto(CreditDto creditDto) {
		this.creditDto = creditDto;
	}

	public Credit getDetail() {
		return detail;
	}

	public void setDetail(Credit detail) {
		this.detail = detail;
	}

	public CreditVo getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(CreditVo detailVo) {
		this.detailVo = detailVo;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public CreditVo getDetailVoList() {
		return detailVoList;
	}

	public void setDetailVoList(List<CreditVo> creditVoList) {
		this.detailVoList = (CreditVo) creditVoList;
	}

}
