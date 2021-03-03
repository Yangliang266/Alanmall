package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardFamilyDto;
import com.itcrazy.alanmall.mscard.manager.CardFamilyManager;
import com.itcrazy.alanmall.mscard.model.CardFamily;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.vo.card.CardFamilyVo;
import com.itcrazy.alanmall.user.manager.UserManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 亲情卡管理
 * @author huangchunbo
 * 2018-11-13
 */
public class CardFamilyAction extends InterfaceBaseAction{
	private static final long serialVersionUID = -2637549889945818883L;

	private CardFamily detail;
	private CardFamilyVo detailVo;
	private CardFamilyDto cardFamilyDto;
	private CardFamily cardFamily;

	private String childCard;

	@Reference
	CardFamilyManager cardFamilyManager;
	@Reference
	UserManager userManager;

	// 卡信息记录
	public String getCardFamilyDetail(){

		if(cardFamilyDto == null){
			cardFamilyDto = new CardFamilyDto();
		}
		// 获取商家id
		cardFamilyDto.setCompanyId(user.getCompanyId());
		detail = cardFamilyManager.getCardFamily(cardFamilyDto);

		Integer count = cardFamilyManager.getCountCreditSet(cardFamilyDto);

		if (detail != null) {
			detailVo = new CardFamilyVo();
			detailVo.setCardNo(detail.getCardNo());
			detailVo.setName(detail.getName());
			detailVo.setCategoryId(detail.getCategoryId());
			detailVo.setMotherCardNo(detail.getMotherCardNo());
			detailVo.setCardType(detail.getCardType());
			detailVo.setUserName(detail.getUserName());
			detailVo.setSex(KeyValueConvert.getCardSexValue(detail.getSex()));
			detailVo.setTelephone(detail.getTelephone());
			detailVo.setIdNumber(detail.getIdNumber());
			detailVo.setRechargeBalance(String.valueOf(detail.getRechargeBalance()));
			detailVo.setReward(String.valueOf(detail.getReward()));
			detailVo.setCategoryId(detail.getCategoryId());
			if(detail.getAllBill() != null) {
				detailVo.setAllBill(detail.getAllBill());
			}else {
				detailVo.setAllBill(BigDecimal.ZERO);
			}

			if(count == null || count.intValue() == 0) {
				detailVo.setCreditNumber(0);
			}else {
				detailVo.setCreditNumber(1);
			}
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	// 子卡页面显示
	public String getCardFamilyHistory() {
		if(cardFamilyDto == null){
			cardFamilyDto = new CardFamilyDto();
		}

		pageSet(cardFamilyDto);
		cardFamilyDto.setCompanyId(user.getCompanyId());

		List<CardFamily> creditFamilyList = cardFamilyManager.getCreditFamilyHistory(cardFamilyDto);
		List<CardFamilyVo> creditFamilyVoList = new ArrayList<CardFamilyVo>();

		if (creditFamilyList != null && creditFamilyList.size() > 0) {

			for (CardFamily c : creditFamilyList) {
				CardFamilyVo cv = new CardFamilyVo();

				cv.setCardNo(c.getCardNo());
				cv.setName(c.getName());
				cv.setUserName(c.getUserName());
				cv.setSex(KeyValueConvert.getCardSexValue(c.getSex()));
				cv.setTelephone(c.getTelephone());
				cv.setIdNumber(c.getIdNumber());
				if (c.getAllBill() != null) {
					cv.setAllBill(c.getAllBill());
				}else {
					cv.setAllBill(BigDecimal.ZERO);
				}

				creditFamilyVoList.add(cv);
			}
		}

		pageData.rows = creditFamilyVoList;
		int iRows = cardFamilyManager.getHistoryPageTotal(cardFamilyDto);
		pageData.setTotal(iRows);
		result.setSuccessInfo();
		return SUCCESS;
	}

	// 解绑子卡
	public String updateCardFamily(){
		if(cardFamily == null){
			result.setParamErrorInfo("cardFamily");
			return SUCCESS;
		}
		cardFamily.setCompanyId(user.getCompanyId());
		cardFamily.setCreateId(user.getId());
		cardFamily.setUpdateId(user.getId());
		try {
		cardFamilyManager.OperaregisteredCard(cardFamily);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(1, "解绑子卡失败");
			return SUCCESS;
		}
		result.setSuccessInfo();
		return SUCCESS;

	}

	// 编辑页面显示
	public String getCardFamilyList(){
		if(childCard == null){
			result.setSuccessInfo();
			return SUCCESS;
		}

		CardFamily cf = cardFamilyManager.getDetil(childCard,user.getCompanyId());
		CardFamilyVo cv = null;
		if(cf != null) {
			cv = new CardFamilyVo();
			cv.setCardNo(cf.getCardNo());
			cv.setName(cf.getName());
			cv.setUserName(cf.getUserName());
			if(cf.getSex()!=null) {
				cv.setSex(KeyValueConvert.getCardSexValue(cf.getSex()));
			}else {
				cv.setSex("");
			}

			cv.setTelephone(cf.getTelephone());
			cv.setIdNumber(cf.getIdNumber());
		}
		setDetailVo(cv);

		result.setSuccessInfo();
		return SUCCESS;
	}

	// 编辑子卡
	public String updCardFamily(){
		if(cardFamily == null){
			result.setParamErrorInfo("cardFamily");
			return SUCCESS;
		}
		cardFamily.setCompanyId(user.getCompanyId());
		cardFamily.setCreateId(user.getId());
		cardFamily.setUpdateId(user.getId());
		try {
		cardFamilyManager.updateChildRegistered(cardFamily);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(1, "编辑子卡失败");
			return SUCCESS;
		}
		result.setSuccessInfo();
		return SUCCESS;

	}

	public CardFamily getDetail() {
		return detail;
	}

	public void setDetail(CardFamily detail) {
		this.detail = detail;
	}

	public CardFamilyVo getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(CardFamilyVo detailVo) {
		this.detailVo = detailVo;
	}

	public CardFamilyDto getCardFamilyDto() {
		return cardFamilyDto;
	}

	public void setCardFamilyDto(CardFamilyDto cardFamilyDto) {
		this.cardFamilyDto = cardFamilyDto;
	}

	public CardFamily getCardFamily() {
		return cardFamily;
	}

	public void setCardFamily(CardFamily cardFamily) {
		this.cardFamily = cardFamily;
	}

	public String getChildCard() {
		return childCard;
	}

	public void setChildCard(String childCard) {
		this.childCard = childCard;
	}

}
