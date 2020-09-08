package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ActiveInformationDao;
import com.itcrazy.alanmall.mscard.dao.CardBindingDao;
import com.itcrazy.alanmall.mscard.dao.CreditSettingDao;
import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.manager.CardBindingManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.Credit;
import com.itcrazy.alanmall.mscard.model.CreditSetting;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 子卡绑定接口实现
 * @author zhangzhongtian
 * 2018-09-29
 */
@Slf4j
@Service
public class CardBindingManagerImpl implements CardBindingManager{
	@Autowired
	private CardBindingDao cardBindingDao;
	@Autowired
	private ActiveInformationDao activeInformationDao;
	@Autowired
	private CreditSettingDao creditSettingDao;

	@Override
	public List<Credit> getCardBindingList(CreditDto creditDto) {
		return cardBindingDao.getCardBindingList(creditDto);
	}

	@Override
	public int bindSubCrads(List<ActiveInformation> activeInfoList) throws Exception{

		if(activeInfoList == null || activeInfoList.size() == 0) {
			return 0;
		}

		String motherCard = activeInfoList.get(0).getMotherCardNo();
		Long companyId = activeInfoList.get(0).getCompanyId();

		List<CreditSetting> motherCardList = creditSettingDao.select(motherCard,companyId);

		if(motherCardList == null || motherCardList.size() == 0) {
			return 1;
		}

		for(ActiveInformation subCard : activeInfoList) {
			for(CreditSetting moCard : motherCardList) {
				// 子卡绑定（母卡信息复制到子卡）
				moCard.setCardNo(subCard.getCardNo());
				moCard.setCreateId(subCard.getUpdateId());
				moCard.setCompanyId(subCard.getCompanyId());
				creditSettingDao.copyCreditSetting(moCard);
			}
			// 子卡绑定（更新激活卡信息表）
			subCard.setMotherCardNo(activeInfoList.get(0).getMotherCardNo());
			subCard.setCreditStatus(0);
			subCard.setCreditMaxQuota(activeInfoList.get(0).getCreditMaxQuota());
			activeInformationDao.updateActiveCardInformation(subCard);
		}
		return 0;
	}
}
