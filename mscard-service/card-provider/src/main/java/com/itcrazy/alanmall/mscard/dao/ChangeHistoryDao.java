package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ChangeHistoryDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.ChangeHistory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 换卡/挂失/补卡记录DAO层接口
 * @author zhangli
 * 2018-09-17
 */
@Component
public interface ChangeHistoryDao extends BaseDao<ChangeHistory, Long> {

	public List<ChangeHistory> getPageList(ChangeHistoryDto changeHistoryDto);

	public Integer getPageTotal(ChangeHistoryDto changeHistoryDto);

	public ActiveInformation getLossInfo(ChangeHistoryDto changeHistoryDto);
}
