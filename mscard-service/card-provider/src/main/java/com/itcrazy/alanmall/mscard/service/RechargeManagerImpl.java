package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ActiveInformationDao;
import com.itcrazy.alanmall.mscard.dao.CardInformationDao;
import com.itcrazy.alanmall.mscard.dao.RechargeDao;
import com.itcrazy.alanmall.mscard.dao.RechargeHistoryDao;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeDto;
import com.itcrazy.alanmall.mscard.manager.RechargeManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.Recharge;
import com.itcrazy.alanmall.mscard.model.RechargeHistory;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * 卡充值接口实现
 * @author chenfei
 * 2018-09-16
 */
@Slf4j
@Service
public class RechargeManagerImpl implements RechargeManager{

	@Autowired
	private RechargeDao rechargeDao;

	@Autowired
	private RechargeHistoryDao rechargeHistoryDao;

	@Autowired
	private CardInformationDao cardInformationDao;

	@Autowired
	private ActiveInformationDao activeInformationDao;

	@Override
	public List<Recharge> getHeadPageList(RechargeDto rechargedto) {
		return rechargeDao.getHeadPageList(rechargedto);
	}

	@Override
	public Integer getHeadPageTotal(RechargeDto rechargedto) {
		return rechargeDao.getHeadPageTotal(rechargedto);
	}

	@Override
	public List<Recharge> getStorePageList(RechargeDto rechargedto) {
		return rechargeDao.getStorePageList(rechargedto);
	}

	@Override
	public Integer getStorePageTotal(RechargeDto rechargedto) {
		return rechargeDao.getStorePageTotal(rechargedto);
	}

	@Override
	public void updateHeadRecharge(List<RechargeHistory> rechargeHistoryList) throws Exception{
		for(RechargeHistory rechargeHistory : rechargeHistoryList) {
			rechargeHistoryDao.insertRechargeHistory(rechargeHistory);

			// 总部充值，更新card_information表里的金额
			CardInformation cardInformation = new CardInformation();
			cardInformation.setCardNo(rechargeHistory.getCardNo());
			cardInformation.setRechargeBalance(rechargeHistory.getRechargeAmount());
			cardInformation.setReward(rechargeHistory.getReward());
			cardInformation.setUpdateId(rechargeHistory.getCreateId());
			cardInformation.setCompanyId(rechargeHistory.getCompanyId());

			cardInformationDao.updateRechargeByCardNo(cardInformation);
		}

	}

	@Override
	public void updateStoreRecharge(List<RechargeHistory> rechargeHistoryList) throws Exception{
		for(RechargeHistory rechargeHistory : rechargeHistoryList) {
			rechargeHistoryDao.insertRechargeHistory(rechargeHistory);

			// 门店充值，更新card_actived_information表里的金额
			ActiveInformation card = new ActiveInformation();
			card.setCardNo(rechargeHistory.getCardNo());
			card.setRechargeBalance(rechargeHistory.getRechargeAmount());
			card.setReward(rechargeHistory.getReward());
			card.setUpdateId(rechargeHistory.getCreateId());
			card.setCompanyId(rechargeHistory.getCompanyId());

			activeInformationDao.updateRechargeByCardNo(card);
		}

	}
}
