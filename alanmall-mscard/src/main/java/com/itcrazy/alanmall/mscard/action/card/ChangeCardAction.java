package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeCardDto;
import com.itcrazy.alanmall.mscard.manager.ChangeCardManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.mscard.vo.card.ChangeCardVo;

/**
 * 换卡管理
 * @author yangliang
 * 2018-09-15
 */
public class ChangeCardAction extends InterfaceBaseAction{


	private static final long serialVersionUID = 7431677120439673622L;
	private ChangeCard detail;
	private ChangeCardVo detailVo;
	private ChangeCardDto changeCardDto;
	private ChangeHistory changeHistory;
	private CardInformation cardInformation;
	private CardDiscarded cardDiscarded;
	private ActiveInformation activeInformation;
	private SupplementCard supplementCard;
	private String selectFlag;

	@Reference
	ChangeCardManager changeCardManager;
	@Reference
	StoreManager storeManager;

	// 老卡初始化页面不显示
	public String getChangeCardList(){
		return null;
	}

	// 卡信息记录
	public String getChangeCardDetail(){
		if(changeCardDto == null){
			changeCardDto = new ChangeCardDto();
		}
		// 获取商家id
		changeCardDto.setCompanyId(user.getCompanyId());
		if ("0".equals(selectFlag)) {
			detail= changeCardManager.getActiveInfo(changeCardDto);

			if (detailVo == null) {
				detailVo = new ChangeCardVo();
			}
			if (detail == null) {
				detailVo = null;
			} else {
				detailVo.setCardNo(detail.getCardNo());
				detailVo.setUserName(detail.getUserName());
				detailVo.setCredit(String.valueOf(detail.getCredit()));
				detailVo.setIdNumber(detail.getIdNumber());
				detailVo.setRechargeBalance(String.valueOf(detail.getRechargeBalance()));
				detailVo.setTelephone(detail.getTelephone());
				detailVo.setName(detail.getName());
				detailVo.setReward(String.valueOf(detail.getReward()));
				detailVo.setCreditMaxQuota(detail.getCreditMaxQuota());
				if (detail.getUserName() == null || detail.getUserName() == "") {
					detailVo.setSex("");
				} else {
					detailVo.setSex(KeyValueConvert.getCardSexValue(detail.getSex()));
				}
				detailVo.setStore(detail.getStore());
				detailVo.setCategory(String.valueOf(detail.getCategory()));
				detailVo.setStatus(detail.getStatus());
				detailVo.setCurrentStore(String.valueOf(user.getStoreId()));
			}
		}else {
			detail= changeCardManager.getPageNewlist(changeCardDto);
			if (detailVo == null) {
				detailVo = new ChangeCardVo();
			}
			if (detail == null) {
				detailVo = null;
			} else {
				if (detail.getUserName() == null) {
					detailVo.setSex("");
				} else {
					detailVo.setSex(KeyValueConvert.getCardSexValue(detail.getSex()));
				}
				detailVo.setCardNo(detail.getCardNo());
				detailVo.setUserName(detail.getUserName());
				detailVo.setCredit(String.valueOf(detail.getCredit()));
				detailVo.setIdNumber(detail.getIdNumber());
				detailVo.setRechargeBalance(String.valueOf(detail.getRechargeBalance()));
				detailVo.setTelephone(detail.getTelephone());
				detailVo.setName(detail.getName());
				detailVo.setReward(String.valueOf(detail.getReward()));
				detailVo.setCreditMaxQuota(detail.getCreditMaxQuota());
				detailVo.setStore(detail.getStore());
				detailVo.setCategory(String.valueOf(detail.getCategory()));
				detailVo.setStatus(detail.getStatus());
				detailVo.setCurrentStore(String.valueOf(user.getStoreId()));
			}
		}
		result.setSuccessInfo();
		return SUCCESS;
	}


	// 换卡
	public String updateChangeCard() {
		try {
			if(changeHistory == null){
				changeHistory = new ChangeHistory();
			}
			// 判断新老卡号是否为空
			if ((changeHistory.getOldCardNo() != null || changeHistory.getOldCardNo() != "" ) &&
				(changeHistory.getNewCardNo() != null || changeHistory.getNewCardNo() != "")) {

				// 1 cardinformation老卡状态更新为作废
				if(cardInformation == null){
					cardInformation = new CardInformation();
				}
				cardInformation.setStatus(5);
				cardInformation.setUpdateId(user.getId());
				cardInformation.setCardNo(changeHistory.getOldCardNo());
				cardInformation.setCompanyId(user.getCompanyId());
				cardInformation.setIsDeleted(0);

				// 2 cardinformation 新卡更新为老卡状态
				changeCardDto = new ChangeCardDto();
				changeCardDto.setOldCardNo(changeHistory.getOldCardNo());
				changeCardDto.setNewCardNo(changeHistory.getNewCardNo());
				changeCardDto.setCompanyId(user.getCompanyId());
				changeCardDto.setStatus(9);

				// 3新卡新增到card_active_information
				if(supplementCard == null) {
					supplementCard = new SupplementCard();
				}
				supplementCard.setNewCardNo(changeHistory.getNewCardNo());
				supplementCard.setOldCardNo(changeHistory.getOldCardNo());
				supplementCard.setCompanyId(user.getCompanyId());
				supplementCard.setCreateId(user.getId());

				// 4 老卡作废处理
				if (cardDiscarded == null) {
					cardDiscarded = new CardDiscarded();
				}
				cardDiscarded.setCardNo(changeHistory.getOldCardNo());
				cardDiscarded.setCompanyId(user.getCompanyId());
				cardDiscarded.setCreateId(user.getId());
				cardDiscarded.setIsDeleted(0);
				cardDiscarded.setReason("换卡作废");

				// 5 换卡记录表新增操作
				changeHistory.setCompanyId(user.getCompanyId());
				changeHistory.setIsDeleted(0);
				changeHistory.setCreateId(user.getId());
				changeHistory.setType(0);

				// 6新卡记名卡新增,老卡删除(需要判断原卡是否记名)
				// 6.1 新增
				// 6.2删除(做更新)
				changeCardDto.setCreateId(user.getId());
				changeCardDto.setUpdateId(user.getId());
				//changeCardDto.setIsDeleted(1);

				// 7新卡挂账新增，老卡删除(需要判断原卡是否挂账)
				// 7.1 新增
				// 7.2删除(做更新)

				// 执行换卡操作
				changeCardManager.changeCard(changeHistory,cardInformation,changeCardDto,cardDiscarded);
			}
			result.setSuccessInfo();
			return SUCCESS;
		} catch (Exception e) {
			result.setResultInfo(1, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}

	}

	public ChangeCardManager getChangeCardManager() {
		return changeCardManager;
	}

	public void setChangeCardManager(ChangeCardManager changeCardManager) {
		this.changeCardManager = changeCardManager;
	}

	public ChangeCardDto getChangeCardDto() {
		return changeCardDto;
	}
	public void setChangeCardDto(ChangeCardDto changeCardDto) {
		this.changeCardDto = changeCardDto;
	}

	public ChangeCard getDetail() {
		return detail;
	}

	public void setDetail(ChangeCard detail) {
		this.detail = detail;
	}

	public ChangeCardVo getDetailVo() {
		return detailVo;
	}


	public ChangeHistory getChangeHistory() {
		return changeHistory;
	}

	public void setChangeHistory(ChangeHistory changeHistory) {
		this.changeHistory = changeHistory;
	}

	public CardInformation getCardInformation() {
		return cardInformation;
	}

	public void setCardInformation(CardInformation cardInformation) {
		this.cardInformation = cardInformation;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}

	public ActiveInformation getActiveInformation() {
		return activeInformation;
	}

	public void setActiveInformation(ActiveInformation activeInformation) {
		this.activeInformation = activeInformation;
	}

	public SupplementCard getSupplementCard() {
		return supplementCard;
	}

	public void setSupplementCard(SupplementCard supplementCard) {
		this.supplementCard = supplementCard;
	}

}
