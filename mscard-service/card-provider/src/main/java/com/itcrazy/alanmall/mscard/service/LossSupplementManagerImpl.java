package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.*;
import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardDiscardedDto;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeCardDto;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeHistoryDto;
import com.itcrazy.alanmall.mscard.manager.LossSupplementManager;
import com.itcrazy.alanmall.mscard.model.*;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 换卡/挂失/补卡记录实现
 *
 * @author zhangli 2018-09-17
 */
@Slf4j
@Service
public class LossSupplementManagerImpl implements LossSupplementManager {

	@Autowired
	private ChangeHistoryDao changeHistoryDao;
	@Autowired
	private CardInformationDao cardInformationDao;
	@Autowired
	private ActiveInformationDao activeInformationDao;
	@Autowired
	private CardDiscardedDao cardDiscardedDao;
	@Autowired
	private RegisteredCardDao registeredCardDao;
	@Autowired
	private CreditSettingDao creditSettingDao;
	@Autowired
	private ChangeCardDao changeCardDao;

	@Override
	public List<ChangeHistory> getPageList(ChangeHistoryDto changeHistoryDto) {
		return changeHistoryDao.getPageList(changeHistoryDto);
	}

	@Override
	public Integer getPageTotal(ChangeHistoryDto changeHistoryDto) {
		return changeHistoryDao.getPageTotal(changeHistoryDto);
	}

	@Override
	public ActiveInformation getLossInfo(ChangeHistoryDto changeHistoryDto) {
		return changeHistoryDao.getLossInfo(changeHistoryDto);
	}

	/**
	 * 挂失确认
	 */
	@Override
	public void updateLoss(CardInformation cardInformation) throws Exception{

		// 获取当前卡号的激活信息
		ActiveInformationDto activeInformationDto = new ActiveInformationDto();
		activeInformationDto.setCardNo(cardInformation.getCardNo());
		activeInformationDto.setCompanyId(cardInformation.getCompanyId());
		ActiveInformation activeInfo = activeInformationDao.getActiveDetail(activeInformationDto);

		// 更新card_information表
		CardInformation oldCard = new CardInformation();
		oldCard.setCardNo(cardInformation.getCardNo());
		oldCard.setMotherType(activeInfo.getMotherType());
		oldCard.setCompanyId(cardInformation.getCompanyId());
		oldCard.setStatus(CardConstants.KEY_CARD_STATE_LOST);
		oldCard.setCreditStatus(activeInfo.getCreditStatus());
		oldCard.setCreditMaxQuota(new BigDecimal(activeInfo.getCreditMaxQuota()));
		oldCard.setRechargeBalance(activeInfo.getRechargeBalance());
		oldCard.setReward(activeInfo.getReward());
		oldCard.setCredit(activeInfo.getCredit());
		oldCard.setMotherCardNo(activeInfo.getMotherCardNo());
		oldCard.setUpdateId(cardInformation.getCreateId());
		cardInformationDao.update(oldCard);

		// 删除card_actived_information表(旧卡)
		ActiveInformation active = new ActiveInformation();
		active.setCardNo(cardInformation.getCardNo());
		active.setCompanyId(cardInformation.getCompanyId());
		activeInformationDao.delete(active);

		// 新增card_change_history表
		ChangeHistory changeHistory = new ChangeHistory();
		changeHistory.setOldCardNo(cardInformation.getCardNo());
		changeHistory.setType(CardConstants.KEY_SUPPLEMENT_CARD);
		changeHistory.setRechargeBalance(cardInformation.getRechargeBalance());
		changeHistory.setReward(cardInformation.getReward());
		changeHistory.setCredit(cardInformation.getCredit());
		changeHistory.setFileName(cardInformation.getFileName());
		changeHistory.setCreateId(cardInformation.getCreateId());
		changeHistory.setCompanyId(cardInformation.getCompanyId());
		changeHistoryDao.save(changeHistory);
	}

	/**
	 * 卡补办
	 */
	@Override
	public void updateSupplement(SupplementCard supplementCard) throws Exception{
		// 更新card_information表(旧卡更新为新卡)
		cardInformationDao.updateCardInformation(supplementCard);

		// 新增card_actived_information表(激活的新卡)
//		ActiveInformation active = new ActiveInformation();
//		active.setCardNo(supplementCard.getNewCardNo());
//		active.setCreateId(supplementCard.getUpdateId());
//		active.setCompanyId(supplementCard.getCompanyId());
		activeInformationDao.saveActiveInfo(supplementCard);

		// 更新card_actived_information表（母卡更新为新卡号）
		activeInformationDao.updMotherCard(supplementCard);

		// 更新card_information表(旧卡作废，金额置0)
		CardInformation oldCard = new CardInformation();
		oldCard.setCardNo(supplementCard.getOldCardNo());
		oldCard.setCompanyId(supplementCard.getCompanyId());
		oldCard.setStatus(CardConstants.KEY_CARD_STATE_SCRAP);
		oldCard.setUpdateId(supplementCard.getUpdateId());
		oldCard.setCreditStatus(1);
		oldCard.setCreditMaxQuota(BigDecimal.ZERO);
		oldCard.setRechargeBalance(BigDecimal.ZERO);
		oldCard.setReward(BigDecimal.ZERO);
		oldCard.setCredit(BigDecimal.ZERO);
		oldCard.setMotherCardNo("null");
		cardInformationDao.update(oldCard);

		// 新增card_discarded表(旧卡作废)
		CardDiscarded cardDiscarded = new CardDiscarded();
		cardDiscarded.setCardNo(supplementCard.getOldCardNo());
		// 最大作废单号查询
		CardDiscardedDto discardedDto = new CardDiscardedDto();
		discardedDto.setCompanyId(supplementCard.getCompanyId());
		String receiptNo = DateFormat.dateToString(new Date(), "yyyyMMdd");
		String lastReceiptNo = cardDiscardedDao.getMaxReciptNo(discardedDto);
		if(lastReceiptNo == null || lastReceiptNo.equals("")) {
			receiptNo = CardConstants.RECEIPT_NO_PREFIX + receiptNo + String.format("%08d",1);
		}else{
			int iLen = lastReceiptNo.length();
			String strDate = lastReceiptNo.substring(iLen - 16, iLen - 8);
			if(receiptNo.equals(strDate)) {
				String strNum = lastReceiptNo.substring(iLen - 8);
				int iNum = Integer.parseInt(strNum);
				receiptNo = CardConstants.RECEIPT_NO_PREFIX + receiptNo + String.format("%08d", iNum + 1);
			}else {
				receiptNo = CardConstants.RECEIPT_NO_PREFIX + receiptNo + String.format("%08d",1);
			}
		}
		cardDiscarded.setReceiptNo(receiptNo);
		cardDiscarded.setReason("挂失作废");
		cardDiscarded.setCreateId(supplementCard.getUpdateId());
		cardDiscarded.setCompanyId(supplementCard.getCompanyId());
		cardDiscardedDao.save(cardDiscarded);

		// 新增card_change_history表(新卡)
		ChangeHistory changeHistory = new ChangeHistory();
		changeHistory.setNewCardNo(supplementCard.getNewCardNo());
		changeHistory.setOldCardNo(supplementCard.getOldCardNo());
		changeHistory.setFileName(supplementCard.getFileName());
		changeHistory.setUpdateId(supplementCard.getUpdateId());
		changeHistory.setCompanyId(supplementCard.getCompanyId());
		changeHistoryDao.update(changeHistory);

		RegisteredCard registered = registeredCardDao.getCardNo(supplementCard.getOldCardNo(),supplementCard.getCompanyId());
		// 新增registered_card表(老卡复制到新卡)
		if(registered != null) {
			supplementCard.setCreateId(supplementCard.getUpdateId());
			registeredCardDao.insertRegisteredCard(supplementCard);

			// 逻辑删除registered_card表(旧卡)
			RegisteredCard registeredCard = new RegisteredCard();
			registeredCard.setUpdateId(supplementCard.getUpdateId());
			registeredCard.setCardNo(supplementCard.getOldCardNo());
			registeredCard.setCompanyId(supplementCard.getCompanyId());
			registeredCardDao.remove(registeredCard);
		}

		// 新增credit_setting表(老卡复制到新卡)
		creditSettingDao.insertCreditSetting(supplementCard);

		// 逻辑删除credit_setting表(老卡)
		CreditSetting creditSetting = new CreditSetting();
		creditSetting.setUpdateId(supplementCard.getUpdateId());
		creditSetting.setCardNo(supplementCard.getOldCardNo());
		creditSetting.setCompanyId(supplementCard.getCompanyId());
		creditSettingDao.remove(creditSetting);

		// 挂账一览更换为新卡
		ChangeCardDto changeCardDto = new ChangeCardDto();
		changeCardDto.setOldCardNo(supplementCard.getOldCardNo());
		changeCardDto.setNewCardNo(supplementCard.getNewCardNo());
		changeCardDto.setUpdateId(supplementCard.getUpdateId());
		changeCardDao.updataCreditsHistory(changeCardDto);
		changeCardDao.updataStorageHistory(changeCardDto);
		changeCardDao.updataStorageHistoryMother(changeCardDto);
		changeCardDao.updataOtherHistory(changeCardDto);

	}

}
