package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.ChangeHistoryDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.ChangeHistory;
import com.itcrazy.alanmall.mscard.model.SupplementCard;

import java.util.List;

/**
 * 换卡/挂失/补卡记录接口
 * @author zhangli
 * 2018-09-17
 */
public interface LossSupplementManager {

	public List<ChangeHistory> getPageList(ChangeHistoryDto changeHistoryDto);

	public Integer getPageTotal(ChangeHistoryDto changeHistoryDto);

	public void updateLoss(CardInformation cardInformation) throws Exception;

	public void updateSupplement(SupplementCard supplementCard) throws Exception;

	public ActiveInformation getLossInfo(ChangeHistoryDto changeHistoryDto);

}
