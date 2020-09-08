package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeHistoryDto;
import com.itcrazy.alanmall.mscard.manager.LossSupplementManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.ChangeHistory;
import com.itcrazy.alanmall.mscard.model.SupplementCard;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.cache.SessionCache;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.mscard.vo.card.ChangeHistoryVo;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 换卡/挂失/补卡记录
 *
 * @author zhangli
 *
 */
public class LossSupplementAction extends InterfaceBaseAction {

	private static final long serialVersionUID = 4547853437066930536L;

	private ChangeHistoryDto changeHistoryDto;
	private CardInformation cardInformation;
	private SupplementCard supplementCard;
	private ActiveInformation detailVo;
	private String mobile;
	private String chkCode;
	private Boolean chkCodeFlag;

	@Reference
	LossSupplementManager lossSupplementManager;
	@Reference
	UserManager userManager;

	/**
	 * 获取挂失/补卡一览表
	 * @return
	 */
	public String getLossSupplementList(){

		if(changeHistoryDto == null){
			changeHistoryDto = new ChangeHistoryDto();
		}

		pageSet(changeHistoryDto);
		changeHistoryDto.setCompanyId(user.getCompanyId());
		changeHistoryDto.setStore(user.getStoreId());
		// 根据画面检索条件，查询挂失/补卡列表
		List<ChangeHistory> historyList = lossSupplementManager.getPageList(changeHistoryDto);
		List<ChangeHistoryVo> historyVoList = new ArrayList<ChangeHistoryVo>();

		// 将查询的数据设置到用于显示的ChangeHistoryVo对象中
		if(historyList != null && historyList.size()>0){

			for(ChangeHistory h : historyList){
				ChangeHistoryVo hv = new ChangeHistoryVo();

				hv.setId(h.getId());
				hv.setOldCardNo(h.getOldCardNo());
				hv.setCategoryName(h.getCategoryName());
				hv.setStatusName(KeyValueConvert.getCardStatusValue(h.getStatus()));
				hv.setNewCardNo(h.getNewCardNo());
				hv.setCreateTime(DateFormat.dateToString(h.getCreateTime()));
				hv.setUpdateTime(DateFormat.dateToString(h.getUpdateTime()));
				// 根据createId获取创建者名称
				User createUser = userManager.getUserById(h.getCreateId());
				if(createUser != null) {
					hv.setCreateName(createUser.getRealName());
                }
				// 根据updateId获取更新者名称
				User updateUser = userManager.getUserById(h.getUpdateId());
				if(updateUser != null) {
					hv.setUpdateName(updateUser.getRealName());
                }

				historyVoList.add(hv);
			}
		}

		pageData.rows = historyVoList;

		Integer t = lossSupplementManager.getPageTotal(changeHistoryDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 挂失确认
	 * @return
	 */
	public String updateLossSupplement(){
		// 卡信息必须check
		if(cardInformation==null){
			result.setParamErrorInfo("cardInformation");
			return SUCCESS;
		}
		// 卡号必须check
		if(StringUtils.isBlank(cardInformation.getCardNo())){
			result.setParamErrorInfo("cardNo");
			return SUCCESS;
		}
		// 检查验证码
		if(chkCodeFlag) {
			Object objCache = SessionCache.get(CardConstants.CACHE_KEY_LOST + mobile);
	        if(objCache != null) {
	            //检查验证码
	        	if(!StringUtils.isBlank(chkCode) && !chkCode.equals(objCache)) {
	        		result.setResultInfo(1, "短信验证码不正确，请重新输入。");
	    			return SUCCESS;
	        	}
	        }else {
	        	result.setResultInfo(1, "请先发送短信验证码。");
	  			return SUCCESS;
	        }
		}

		cardInformation.setCompanyId(user.getCompanyId());
		cardInformation.setCreateId(user.getId());
		// 挂失确认
		try {
			lossSupplementManager.updateLoss(cardInformation);
		} catch (Exception e) {
			result.setResultInfo(1, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 卡补办
	 * @return
	 */
	public String updLossSupplement(){
		// 卡补办信息必须check
		if(supplementCard==null){
			result.setParamErrorInfo("supplementCard");
			return SUCCESS;
		}
		// 旧卡号必须check
		if(StringUtils.isBlank(supplementCard.getOldCardNo())){
			result.setParamErrorInfo("oldCardNo");
			return SUCCESS;
		}
		// 新卡号必须check
		if(StringUtils.isBlank(supplementCard.getNewCardNo())){
			result.setParamErrorInfo("newCardNo");
			return SUCCESS;
		}
		//检查验证码
		if(chkCodeFlag) {
			Object objCache = SessionCache.get(CardConstants.CACHE_KEY_SUPPLEMENT + mobile);
	        if(objCache != null) {
	            //检查验证码
	        	if(!StringUtils.isBlank(chkCode) && !chkCode.equals(objCache)) {
	        		result.setResultInfo(1, "短信验证码不正确，请重新输入。");
	    			return SUCCESS;
	        	}
	        }else {
	        	result.setResultInfo(1, "请先发送短信验证码。");
    			return SUCCESS;
	        }
		}

		supplementCard.setCompanyId(user.getCompanyId());
		supplementCard.setUpdateId(user.getId());
		supplementCard.setCreateId(user.getId());
		// 卡补办
		try {
			lossSupplementManager.updateSupplement(supplementCard);
		} catch (Exception e) {
			result.setResultInfo(1, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取卡挂失信息
	 * @return
	 */
	/**
	 * 获取激活卡信息
	 * @return
	 */
	public String getLossSupplementDetail(){

		if(changeHistoryDto == null){
			changeHistoryDto = new ChangeHistoryDto();
		}

		changeHistoryDto.setCompanyId(user.getCompanyId());
		detailVo = lossSupplementManager.getLossInfo(changeHistoryDto);
		if(detailVo != null) {
			detailVo.setStatusName(KeyValueConvert.getCardStatusValue(detailVo.getStatus()));
			if(detailVo.getSex() != null) {
				detailVo.setSexName(KeyValueConvert.getCardSexValue(detailVo.getSex()));
			}

		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	public ChangeHistoryDto getChangeHistoryDto() {
		return changeHistoryDto;
	}

	public void setChangeHistoryDto(ChangeHistoryDto changeHistoryDto) {
		this.changeHistoryDto = changeHistoryDto;
	}

	public CardInformation getCardInformation() {
		return cardInformation;
	}

	public void setCardInformation(CardInformation cardInformation) {
		this.cardInformation = cardInformation;
	}

	public SupplementCard getSupplementCard() {
		return supplementCard;
	}

	public void setSupplementCard(SupplementCard supplementCard) {
		this.supplementCard = supplementCard;
	}

	public ActiveInformation getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(ActiveInformation detailVo) {
		this.detailVo = detailVo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getChkCode() {
		return chkCode;
	}

	public void setChkCode(String chkCode) {
		this.chkCode = chkCode;
	}

	public Boolean getChkCodeFlag() {
		return chkCodeFlag;
	}

	public void setChkCodeFlag(Boolean chkCodeFlag) {
		this.chkCodeFlag = chkCodeFlag;
	}

}
