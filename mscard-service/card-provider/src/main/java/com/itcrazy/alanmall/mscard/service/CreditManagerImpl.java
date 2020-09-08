package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.CreditDao;
import com.itcrazy.alanmall.mscard.dao.CreditSettingDao;
import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.manager.CreditManager;
import com.itcrazy.alanmall.mscard.model.Credit;
import com.itcrazy.alanmall.mscard.model.CreditSetting;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 换卡接口实现
 * @author luxf
 * 2018-09-15
 */
@Slf4j
@Service
public class CreditManagerImpl implements CreditManager{
	@Autowired
	private CreditDao creditDao;
	@Autowired
	private CreditSettingDao creditSettingDao;

	@Override
	public Credit getPageList(CreditDto creditDto) {
		Credit credit = creditDao.getPageList(creditDto);
		if (credit == null) {
			return null;
		}

		String maxQuota = creditDao.getMaxCreditMaxQuota(creditDto);
		if(maxQuota != null) {
			credit.setCreditChildMaxQuota(maxQuota);
		}
		List<CreditSetting> creditSettings = creditSettingDao.select(creditDto.getCardNo(),creditDto.getCompanyId());
		credit.setCreditSettingList(creditSettings);
		return credit;
	}

	@Override
	public List<Credit> getCreditHistory(CreditDto creditDto) {
		return creditDao.getCreditHistory(creditDto);
	}

	@Override
	public int getHistoryPageTotal(CreditDto creditDto) {
		return creditDao.getHistoryPageTotal(creditDto);
	}

	/*@Override
	public Credit getCreditById(Long id, Long companyId, String cardNo) {
		Credit credit = creditDao.getCreditById(id,companyId,cardNo);
		return credit;
	}*/

	@Override
	public List<Credit> getCreditById(CreditDto creditDto) {
		List<Credit> credit = creditDao.getCreditById(creditDto);
		return credit;
	}
}
