package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.manager.TypeManager;
import com.itcrazy.alanmall.mscard.model.CardType;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;

import java.util.List;

/**
 * 卡系统参数配置
 *
 * @author zhangli
 *
 */
public class TypeAction extends InterfaceBaseAction {
	private static final long serialVersionUID = -2326518255547601696L;

	@Reference
	TypeManager typeManager;

	/**
	 * 获取读卡器型号列表
	 * @return
	 */
	public String getTypeList() {
		CardBaseDto baseDto = new CardBaseDto();
		baseDto.setIsDeleted(0);
		baseDto.setCompanyId(user.getCompanyId());
		List<CardType> typeList = typeManager.getPageList(baseDto);

		pageData.rows = typeList;
		result.setSuccessInfo();
		return SUCCESS;
	}

}
