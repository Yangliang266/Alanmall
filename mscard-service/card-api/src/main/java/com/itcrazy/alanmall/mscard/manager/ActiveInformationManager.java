package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CreditSetting;

import java.util.List;

/**
 * 激活卡信息接口
 * @author zhangli
 * 2018-09-18
 */
public interface ActiveInformationManager {

	public ActiveInformation getActiveDetail(ActiveInformationDto activeInformationDto);

	public int updateActiveInfo(ActiveInformation activeInformation);

	public String updateActive(ActiveInformation activeInformation,
                               String updStatusFlag, List<CreditSetting> creditSettings) throws Exception;

	/**
	 * 获取可授信子卡信息（初期导入有授信额度的卡）
	 * @param activeInformationDto
	 * @return
	 */
	public List<ActiveInformation> getCreditChildList(ActiveInformationDto activeInformationDto);

	/**
	 * 获取可授信母卡信息（初期导入有授信额度的卡）
	 * @param activeInformationDto
	 * @return
	 */
	public List<ActiveInformation> getCreditParentList(ActiveInformationDto activeInformationDto);

}
