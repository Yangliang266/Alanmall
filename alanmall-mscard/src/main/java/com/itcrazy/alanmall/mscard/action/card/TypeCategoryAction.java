package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.TypeCategoryManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;

import java.util.List;

/**
 * 新建卡号(获取卡状态)
 * @author huangchunbo
 * 2018-09-12
 */
public class TypeCategoryAction extends InterfaceBaseAction {
	private static final long serialVersionUID = -2326518255547601696L;

	@Reference
	TypeCategoryManager typeCategoryManager;

	public String getTypeCategoryList() {
		CardInformationDto cardInformationDto = new CardInformationDto();
		cardInformationDto.setCompanyId(user.getCompanyId());
		List<CardInformation> typeCategoryList = typeCategoryManager.getPageList(cardInformationDto);

		pageData.rows = typeCategoryList;
		result.setSuccessInfo();
		return SUCCESS;
	}

}
