package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CreditDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.Credit;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 挂账设定Dao层接口
 * @author luxf
 * 2018-09-21
 */
@Component
public interface CreditDao extends BaseDao<Credit, Long> {

	// 获取新卡数据
	public Credit getPageList(CreditDto creditDto);

	// 子卡记录查询
	public List<Credit> getCreditHistory(CreditDto creditDto);

	// 分页
	public int getHistoryPageTotal(CreditDto creditDto);

	public int saveStatus(ActiveInformation activeInformation);

	// 最大子卡额度查询
	public String getMaxCreditMaxQuota(CreditDto creditDto);

	public List<Credit> getCreditById(CreditDto creditDto);

}
