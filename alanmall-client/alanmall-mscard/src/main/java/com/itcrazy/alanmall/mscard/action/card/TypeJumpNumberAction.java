package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.manager.TypeCategoryManager;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;

import java.util.List;

/**
 * 新建卡号(获取跳号数字)
 * @author huangchunbo
 * 2018-09-12
 */
public class TypeJumpNumberAction extends InterfaceBaseAction {
	private static final long serialVersionUID = -6040107482165431375L;

	@Reference
	TypeCategoryManager typeCategoryManager;

	public String getTypeJumpNumberList() {
		CardInformationDto cardInformationDto = new CardInformationDto();
		cardInformationDto.setCompanyId(user.getCompanyId());
		List<CardInformation> jumpNumberList = typeCategoryManager.getJumpNumberList(cardInformationDto);

		pageData.rows = jumpNumberList;
		result.setSuccessInfo();
		return SUCCESS;

	}
}
