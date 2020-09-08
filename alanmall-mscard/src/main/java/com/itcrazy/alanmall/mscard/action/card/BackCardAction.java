package com.itcrazy.alanmall.mscard.action.card;

import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.dto.Base.BackCardDto;
import com.itcrazy.alanmall.mscard.manager.ActiveInformationManager;
import com.itcrazy.alanmall.mscard.manager.BackCardManager;
import com.itcrazy.alanmall.mscard.model.BackCard;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.vo.card.BackCardVo;
import org.apache.dubbo.config.annotation.Reference;

import java.util.List;

/**
 * 退卡管理
 * @author yangliang
 * 2018-09-15
 */
public class BackCardAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 7431677120439673622L;
	private BackCard detail;
	private BackCardVo detailVo;
	private BackCardDto backCardDto;
	private String selectFlag;

	@Reference
	BackCardManager backCardManager;
	@Reference
	ActiveInformationManager activeInformationManager;

	// 卡初始化页面获取支付方式
	public String getBackCardList(){
		if ("0".equals(selectFlag)) {
			if (backCardDto == null) {
				backCardDto = new BackCardDto();
			}
			backCardDto.setCompanyId(user.getCompanyId());
			List<BackCard> payModeList = backCardManager.getPayModeList(backCardDto);
			pageData.rows = payModeList;
			result.setSuccessInfo();
			return SUCCESS;
		} else {
			return null;
		}
	}

	// 卡信息记录
	public String getBackCardDetail(){
		if (backCardDto == null) {
			backCardDto = new BackCardDto();
		}
		backCardDto.setCompanyId(user.getCompanyId());
		// 已退卡信息查询
		if ("1".equals(selectFlag)) {
			detail = backCardManager.getPageHistory(backCardDto);

			if (detailVo == null) {
				detailVo = new BackCardVo();
			}
			if (detail == null) {
				detailVo = null;
			} else {
				detailVo.setCardNo(detail.getCardNo());
				detailVo.setStatus(KeyValueConvert.getCardStatusValue(detail.getStatus()));
				detailVo.setUserName(detail.getUserName());
				detailVo.setCredit(String.valueOf(detail.getCredit()));
				detailVo.setIdNumber(detail.getIdNumber());
				detailVo.setRechargeBalance(String.valueOf(detail.getRechargeBalance()));
				// 获取文件名
				detailVo.setFileName(detail.getFileName());
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
			}
		} else if("2".equals(selectFlag)){
			// 已退款余额查询
			detail = backCardManager.getDialogHistory(backCardDto);

			if (detailVo == null) {
				detailVo = new BackCardVo();
			}
			if (detail == null) {
				detailVo = null;
			}else {
				detailVo.setPayMode(String.valueOf(detail.getPayMode()));
				detailVo.setReason(detail.getReason());
				detailVo.setReturnPrice(String.valueOf(detail.getReturnPrice()));
			}
		} else if("3".equals(selectFlag)) {
			if (detailVo == null) {
				detailVo = new BackCardVo();
			}
			int i = backCardManager.getActivedInformationCount(backCardDto);
			int j = backCardManager.getCustomReturnHistoryCount(backCardDto);
			detailVo.setActivedInformationCount(String.valueOf(i));
			detailVo.setCustomReturnHistoryCount(String.valueOf(j));

		} else {
			// 待退卡卡信息查询
			detail = backCardManager.getPageList(backCardDto);

			int i = backCardManager.getCustomReturnHistoryCount(backCardDto);

			if (detailVo == null) {
				detailVo = new BackCardVo();
			}
			if (detail == null) {
				detailVo = null;
			}
			detailVo.setCustomReturnHistoryCount(String.valueOf(i));
			detailVo.setCardNo(detail.getCardNo());
			detailVo.setStatus(KeyValueConvert.getCardStatusValue(detail.getStatus()));
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
		}
		result.setSuccessInfo();
		return SUCCESS;
	}


	// 门店退卡,余额退款
	public String updateBackCard() {
		try {
			if (backCardDto == null) {
				backCardDto = new BackCardDto();
			}
			backCardDto.setCompanyId(user.getCompanyId());
			backCardDto.setUpdateId(user.getId());
			backCardDto.setCreateId(user.getId());
			if ("0".equals(selectFlag)) {
				backCardManager.returnCard(backCardDto);
			} else {
				backCardManager.returnbalance(backCardDto);
			}
			result.setSuccessInfo();
			return SUCCESS;
		} catch (Exception e) {
			result.setResultInfo(1, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}
	}


	// 退卡
	public String updatBackCard() {
		return null;
	}

	public BackCard getDetail() {
		return detail;
	}

	public void setDetail(BackCard detail) {
		this.detail = detail;
	}

	public BackCardVo getDetailVo() {
		return detailVo;
	}

	public BackCardManager getBackCardManager() {
		return backCardManager;
	}

	public void setBackCardManager(BackCardManager backCardManager) {
		this.backCardManager = backCardManager;
	}

	public ActiveInformationManager getActiveInformationManager() {
		return activeInformationManager;
	}

	public void setActiveInformationManager(ActiveInformationManager activeInformationManager) {
		this.activeInformationManager = activeInformationManager;
	}

	public BackCardDto getBackCardDto() {
		return backCardDto;
	}

	public void setBackCardDto(BackCardDto backCardDto) {
		this.backCardDto = backCardDto;
	}

	public String getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(String selectFlag) {
		this.selectFlag = selectFlag;
	}



}
