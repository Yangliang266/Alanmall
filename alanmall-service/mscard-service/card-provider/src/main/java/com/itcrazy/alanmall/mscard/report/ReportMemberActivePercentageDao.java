package com.itcrazy.alanmall.mscard.report;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ReportMemberActivePercentageDto;
import com.itcrazy.alanmall.mscard.model.CardBaseModel;
import com.itcrazy.alanmall.mscard.model.ReportMemberActivePercentage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReportMemberActivePercentageDao extends BaseDao<CardBaseModel, Long> {
	// 查询卡类别
	public List<ReportMemberActivePercentage> getTotalCategory(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

	//
	public List<ReportMemberActivePercentage> getMemberActivePercentageHistory(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

	public Integer getMemberActivePercentageTotal(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

	public List<ReportMemberActivePercentage> getMemberActivePercentageRechageHistory(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

	public List<ReportMemberActivePercentage> getMemberActivePercentageStorageHistory(ReportMemberActivePercentageDto reportMemberActivePercentageDto);

}
