package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CardFamilyDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardFamilyDto;
import com.itcrazy.alanmall.mscard.manager.CardFamilyManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardFamily;
import com.itcrazy.alanmall.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * 亲情卡管理接口实现
 * @author huangchunbo
 * 2018-11-13
 */
@Slf4j
@Service
public class CardFamilyManagerImpl implements CardFamilyManager{

	@Autowired
	private CardFamilyDao cardFamilyDao;

	@Override
	public CardFamily getCardFamily(CardFamilyDto cardFamilyDto) {
		return cardFamilyDao.getCardFamily(cardFamilyDto);
	}

	@Override
	public List<CardFamily> getCreditFamilyHistory(CardFamilyDto cardFamilyDto) {
		return cardFamilyDao.getCreditFamilyHistory(cardFamilyDto);
	}

	@Override
	public int getHistoryPageTotal(CardFamilyDto cardFamilyDto) {
		return cardFamilyDao.getHistoryPageTotal(cardFamilyDto);
	}

	@Override
	public Integer getCountCreditSet(CardFamilyDto cardFamilyDto) {
		return cardFamilyDao.getCountCreditSet(cardFamilyDto);
	}

	@Override
	public List<CardFamily> getCardBindFamilyList(CardFamilyDto cardFamilyDto) {
		return cardFamilyDao.getCardBindFamilyList(cardFamilyDto);
	}

	@Override
	public Result bindSubCrads(List<ActiveInformation> activeInfoList) {

		Result result = new Result();
		result.setSuccessInfo();
		if(activeInfoList == null || activeInfoList.size() == 0) {
			result.setResultInfo(-1, "绑定子卡失败，子卡卡号为空");
			return result;
		}

		// 1、更新card_actived_information表
		for(ActiveInformation subCard : activeInfoList) {
			// 查询充值余额总和，充值奖励总和，挂账总额
			CardFamily cardFamily = cardFamilyDao.selectCard(subCard);
			BigDecimal rechargeBalance = cardFamily.getRechargeBalance();
			BigDecimal reward = cardFamily.getReward();
			BigDecimal credit = cardFamily.getRechargeBalance();
			if (rechargeBalance.compareTo(BigDecimal.ZERO) != 0) {

				result.setResultInfo(-1, "绑定子卡失败，充值余额不为0");

				return result;
			}

			if (reward.compareTo(BigDecimal.ZERO) != 0) {

				result.setResultInfo(-1, "绑定子卡失败，充值奖励余额不为0");

				return result;
			}

			if (credit.compareTo(BigDecimal.ZERO) != 0) {

				result.setResultInfo(-1, "绑定子卡失败，挂账总额不为0");

				return result;
			}

			// 更新激活卡信息表子卡（MOTHER_TYPE为1）
			cardFamilyDao.updateActiveCardInformation(subCard);
		}
		// 更新激活卡信息表母卡（MOTHER_TYPE为2）
		cardFamilyDao.updateActiveMother(activeInfoList.get(0));

		// 2、记名卡信息更新
		// 删除子卡记名信息
		for(ActiveInformation subCard : activeInfoList) {
			// 删除记名卡信息表中的子卡信息
			CardFamily card = new CardFamily();
			card.setCardNo(subCard.getCardNo());
			card.setCompanyId(subCard.getCompanyId());
			cardFamilyDao.deleteRegisteredCard(card);
		}
		// 取母卡记名信息
		String motherCard = activeInfoList.get(0).getMotherCardNo();
		Long companyId = activeInfoList.get(0).getCompanyId();
		List<CardFamily> motherCardList = cardFamilyDao.select(motherCard,companyId);
		// 更新子卡的记名信息
		if(motherCardList.size() == 1) {
			CardFamily motherReg = motherCardList.get(0);
			for(ActiveInformation subCard : activeInfoList) {
				motherReg.setCardNo(subCard.getCardNo());
				motherReg.setCreateId(subCard.getUpdateId());
				motherReg.setCompanyId(subCard.getCompanyId());
				// 子卡绑定（母卡信息复制到子卡）
				cardFamilyDao.copyMotherRegisteredCard(motherReg);
			}
		}
		return result;
	}

	@Override
	public void OperaregisteredCard(CardFamily cardFamily) throws Exception{

		// 1、更新card_actived_information表（MOTHER_TYPE为空）
		cardFamilyDao.updateChildCard(cardFamily);

		// 查询解绑子卡的母卡的其余子卡记录条数
		Integer countChildCard = cardFamilyDao.countCardFamily(cardFamily);

		// 若子卡记录条数为0，则更新激活卡信息表母卡（MOTHER_TYPE为空）
		if (countChildCard == 0) {
			cardFamilyDao.updateMotherCardNo(cardFamily);
		}

	}

	@Override
	public void updateChildRegistered(CardFamily cardFamily) throws Exception{

		cardFamilyDao.deleteRegisteredCard(cardFamily);

		cardFamilyDao.updateChildRegistered(cardFamily);
	}

	@Override
	public CardFamily getDetil(String childCard, Long companyId) {

		return cardFamilyDao.getDetil(childCard,companyId);
	}
}
