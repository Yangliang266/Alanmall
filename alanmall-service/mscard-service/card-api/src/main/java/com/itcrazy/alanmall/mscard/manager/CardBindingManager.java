package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.Credit;

import java.util.List;

/**
 * 子卡绑定接口
 * @author zhangzhongtian
 * 2018-09-29
 */
public interface CardBindingManager {
	// 未绑定子卡查询
	public List<Credit> getCardBindingList(CreditDto creditDto);

	// 子卡绑定（激活卡信息表，新增子卡挂账设定表）
	public int bindSubCrads(List<ActiveInformation> activeInfoList) throws Exception;
}
