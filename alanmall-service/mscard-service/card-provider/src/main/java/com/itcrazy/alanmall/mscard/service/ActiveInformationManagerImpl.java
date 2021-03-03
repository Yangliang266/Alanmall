package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.dao.ActiveInformationDao;
import com.itcrazy.alanmall.mscard.dao.CreditSettingDao;
import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.manager.ActiveInformationManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CreditSetting;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 激活卡信息接口实现
 * @author zhangli
 * 2018-09-18
 */
@Slf4j
@Service
public class ActiveInformationManagerImpl implements ActiveInformationManager{

	@Autowired
	private ActiveInformationDao activeInformationDao;
	@Autowired
	private CreditSettingDao creditSettingDao;


	@Override
	public ActiveInformation getActiveDetail(ActiveInformationDto activeInformationDto) {
		return activeInformationDao.getActiveDetail(activeInformationDto);
	}

	@Override
	public int updateActiveInfo(ActiveInformation activeInformation) {
		return activeInformationDao.save(activeInformation);
	}

	/**
	 * 设置挂帐额度规则
	 */
	@Override
	public String updateActive(ActiveInformation activeInformation,
			String updStatusFlag,List<CreditSetting> creditSettings) throws Exception{

			// 更新card_actived_information表
			if("1".equals(updStatusFlag)) {
				activeInformation.setCreditStatus(0);
				activeInformationDao.save(activeInformation);
			}else {
				activeInformationDao.save(activeInformation);
			}

			// 更新挂帐额度表
			if(creditSettings != null && !creditSettings.isEmpty()) {
				// 删除折扣表中，原有此卡类别的折扣信息
				creditSettingDao.deleteCreditSettingByCardNo(activeInformation.getCardNo(),
						activeInformation.getCompanyId());
				for(CreditSetting creditSetting : creditSettings) {
					creditSetting.setCardNo(activeInformation.getCardNo());
					creditSettingDao.addCreditSetting(creditSetting);
				}
			}

		return "1";
	}


	/**
	 * 获取可授信子卡信息（初期导入有授信额度的卡）
	 * @param activeInformationDto
	 * @return
	 */
	@Override
	public List<ActiveInformation> getCreditChildList(ActiveInformationDto activeInformationDto){
		return activeInformationDao.getCreditChildList(activeInformationDto);
	}

	/**
	 * 获取可授信母卡信息（初期导入有授信额度的卡）
	 * @param activeInformationDto
	 * @return
	 */
	@Override
	public List<ActiveInformation> getCreditParentList(ActiveInformationDto activeInformationDto){
		return activeInformationDao.getCreditParentList(activeInformationDto);
	}

}
