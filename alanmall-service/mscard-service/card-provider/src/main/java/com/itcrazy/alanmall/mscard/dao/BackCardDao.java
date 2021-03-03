package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.BackCardDto;
import com.itcrazy.alanmall.mscard.model.BackCard;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 换卡Dao层接口
 * @author yangliang
 * 2018-09-15
 */
@Component
public interface BackCardDao extends BaseDao<BackCard, Long> {
	// 获取支付方式
	public List<BackCard> getPayModeList(BackCardDto backCardDto);

	// 获取老卡数据
	public BackCard getPageList(BackCardDto backCardDto);

	// 获取已退卡老卡数据
	public BackCard getPageHistory(BackCardDto backCardDto);

	// 余额退款历史查询
	public BackCard getDialogHistory(BackCardDto backCardDto);

	// 余额退款更新cardinformation
	public int updateCardInformationBalance(BackCardDto backCardDto);

	public int updateActiveBalance(BackCardDto backCardDto);

	public int getCustomReturnHistoryCount(BackCardDto backCardDto);

	public int getActivedInformationCount(BackCardDto backCardDto);

	public int updateInformation(CardInformation cardInformation);

	public int updateMother(BackCardDto backCardDto);
}
