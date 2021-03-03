package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeCardDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.ChangeCard;
import com.itcrazy.alanmall.mscard.model.ChangeNewCard;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 换卡Dao层接口
 * @author yangliang
 * 2018-09-15
 */
@Component
public interface ChangeCardDao extends BaseDao<ChangeCard, Long> {


	// 获取老卡数据
	public ChangeCard getActiveInfo(ChangeCardDto changeCardDto);

	// 获取新卡数据
	public ChangeCard getPageNewlist(ChangeCardDto changeCardDto);

	// 新增到insertActiveInformation
	public int insertActiveInformation(ChangeCardDto changeCardDto);

	// 老卡删除insertActiveInformation
	public int deleteActiveInformation(ChangeCardDto changeCardDto);

	// 记名卡计数
	public Integer getTotal(ChangeCardDto changeCardDto);

	// 新卡记名信息变为老卡
	public int updateCardInformation(ChangeCardDto changeCardDto);

	// 老卡记名做删除状态
	public int updateRegisteredCard(ChangeCardDto changeCardDto);

	// 新卡挂账信息变为老卡
	public int insertCreditSetting(ChangeCardDto changeCardDto);

	// 老卡挂账做删除状态
	public int updateCreditSetting(ChangeCardDto changeCardDto);

	// 插入记名卡
	public int insertRegisteredCard(ChangeCardDto changeCardDto);

	// 获取新卡数据
	public List<ChangeNewCard> getNewPageList(ChangeCardDto changeCardDto);

	// 总历史记录数
	public Integer getPageTotal(ChangeCardDto changeCardDto);

	// 原卡cardinformation金额状态清零，状态为作废
	public int updateInformationBalance(CardInformation cardInformation);

	public int updataCreditsHistory(ChangeCardDto changeCardDto);

	public int updataStorageHistory(ChangeCardDto changeCardDto);

	public int updataStorageHistoryMother(ChangeCardDto changeCardDto);

	public int updataOtherHistory(ChangeCardDto changeCardDto);






}
