package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.RegisteredCardDao;
import com.itcrazy.alanmall.mscard.manager.RegisteredCardManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.RegisteredCard;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 门店卡激活(单张发卡,编辑)接口实现
 * @author huangchunbo
 * 2018-09-29
 */
@Slf4j
@Service
public class RegisteredCardManagerImpl implements RegisteredCardManager{

	@Autowired
	private  RegisteredCardDao registeredCardDao;

	@Override
	public void OperaregisteredCard(RegisteredCard registeredCard,String flag) throws Exception{

			registeredCardDao.save(registeredCard);
			if(!"1".equals(flag)) {
				registeredCardDao.updateCardInformation(registeredCard);

				// 当前数据插入到card_actived_information表中
				ActiveInformation activeInformation = new ActiveInformation();
				activeInformation.setCardNo(registeredCard.getCardNo());
				activeInformation.setCompanyId(registeredCard.getCompanyId());
				activeInformation.setCreateId(registeredCard.getCreateId());
				registeredCardDao.saveActiveInfo(activeInformation);
				//修改卡信息表中的充值余额总和,充值奖励总和
				registeredCardDao.updateCardInformationBill(registeredCard);
			}

	}

	@Override
	public RegisteredCard getCardNo(String regCardNo,Long companyId) {
		return registeredCardDao.getCardNo(regCardNo,companyId);
	}
	@Override
	public int updateRegisteredCard(RegisteredCard registeredCard) throws Exception{
		return registeredCardDao.updateRegisteredCard(registeredCard);
	}
}
