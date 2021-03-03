package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.SupplementCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 激活卡信息DAO层接口
 * @author zhangli
 * 2018-09-18
 */
@Component
public interface ActiveInformationDao extends BaseDao<ActiveInformation, Long> {

	public ActiveInformation getActiveDetail(ActiveInformationDto activeInformationDto);

	public int saveActiveInfo(SupplementCard supplementCard);

	public int updMotherCard(SupplementCard supplementCard);

	public int delete(ActiveInformation activeInformation);

	// 子卡绑定（更新激活卡信息表）
	public int updateActiveCardInformation(ActiveInformation card);

	/**
	 * 根据母卡卡号获取子卡
	 * @param CardNo
	 * @param companyId
	 * @return
	 */
	public List<ActiveInformation> getSubCardByMatherCardNo(
            @Param("cardNo") String CardNo, @Param("companyId") Long companyId);

	/**
	 * 门店充值
	 * @param activeInformation
	 */
	public void updateRechargeByCardNo(ActiveInformation activeInformation);

	/**
	 * 获取可授信子卡信息（初期导入有授信额度的卡）
	 * @param activeInformationDto
	 * @return
	 */
	public List<ActiveInformation> getCreditChildList(ActiveInformationDto activeInformationDto);

	/**
	 * 获取可授信母卡信息（初期导入有授信额度的卡）
	 * @param activeInformationDto
	 * @return
	 */
	public List<ActiveInformation> getCreditParentList(ActiveInformationDto activeInformationDto);
}
