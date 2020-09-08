package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardInformationDto;
import com.itcrazy.alanmall.mscard.model.CardInformation;
import com.itcrazy.alanmall.mscard.model.SupplementCard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 制卡管理Dao接口实现
 * @author huangchunbo
 * 2018-09-04
 */

public interface CardInformationDao extends BaseDao<CardInformation, Long> {

	public List<CardInformation> getPageList(CardInformationDto cardInformationDto);

	public int getPageTotal(CardInformationDto cardInformationDto);

	/**
	 * 获取最大批次号
	 * @param cardBaseDto
	 * @return
	 */
	public CardInformation getMaxSerilNo(CardBaseDto cardBaseDto);

	/**
	 * 通过前缀获取最大卡号cardBaseDto
	 * @param
	 * @return
	 */
	public String getMaxCardNoByPrefix(@Param("prefix") String prefix, @Param("companyId") Long companyId);


	public CardInformation getCardDetail(CardInformationDto cardInformationDto);

	/**
	 * 换卡/补卡
	 * @param supplementCard
	 * @return
	 */
	public int updateCardInformation(SupplementCard supplementCard);

	public void updateRechargeByCardNo(CardInformation cardInformationDto);

	/**
	 * 通过卡类别id和companyId，计算本类别卡的数量
	 * @param categoryId
	 * @param companyId
	 * @return
	 */
	public Long selectCardCountByCategoryId(
            @Param("categoryId") Long categoryId,
            @Param("companyId") Long companyId);

	/**
	 * 批量插入
	 * @param cardInfoList
	 * @return
	 */
	public int batchInsert(List<CardInformation> cardInfoList);

}
