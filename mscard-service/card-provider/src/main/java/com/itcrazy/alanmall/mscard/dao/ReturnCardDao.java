package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReturnCardDto;
import com.itcrazy.alanmall.mscard.model.ReturnCard;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 总部退货Dao层接口
 * @author yangliang
 * 2018-09-04
 */
@Component
public interface ReturnCardDao extends BaseDao<ReturnCard, Long> {
	// 获取页面初始化数据
	public List<ReturnCard> getPageList(ReturnCardDto returnCardDto);

	// 总历史记录数
	public Integer getPageTotal(ReturnCardDto returncardDto);

	// 获取待退货的卡号总条数
	public Integer getReturnCardTotal(ReturnCardDto returncardDto);

	// 新增returnCard
	public int insertReturnCard(ReturnCard returnCard);

	// 更新cardInformation
	public int updateCardInformation(ReturnCard returnCard);

	// 获取最大货单号
	public String getMaxReciptNo(ReturnCardDto returnCard);

	// 提取待退货的卡号
	public List<ReturnCard> getReturnCardNo(ReturnCardDto returnCardDto);


}
