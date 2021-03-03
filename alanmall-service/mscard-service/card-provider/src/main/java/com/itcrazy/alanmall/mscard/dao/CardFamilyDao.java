package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.CardFamilyDto;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CardFamily;
import com.itcrazy.alanmall.mscard.model.Credit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;

/**
 *  亲情卡管理Dao层接口
 * @author huangchunbo
 * 2018-11-13
 */
@Component
public interface CardFamilyDao extends BaseDao<Credit, Long> {

	CardFamily getCardFamily(CardFamilyDto cardFamilyDto);

	List<CardFamily> getCreditFamilyHistory(CardFamilyDto cardFamilyDto);

	int getHistoryPageTotal(CardFamilyDto cardFamilyDto);

	Integer getCountCreditSet(CardFamilyDto cardFamilyDto);

	List<CardFamily> getCardBindFamilyList(CardFamilyDto cardFamilyDto);

	List<CardFamily> select(@Param("motherCardNo") String motherCardNo,
                            @Param("companyId") Long companyId);

	public int deleteRegisteredCard(CardFamily card);

	public int copyMotherRegisteredCard(CardFamily motherReg);

	public int updateActiveCardInformation(ActiveInformation subCard);

	public int updateActiveMother(ActiveInformation subCard);

	public int updateChildCard(CardFamily cardFamily);

	public int countCardFamily(CardFamily cardFamily);

	public int updateMotherCardNo(CardFamily cardFamily);

	public int updateChildRegistered(CardFamily cardFamily);

	CardFamily getDetil(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

	CardFamily selectCard(ActiveInformation subCard);

	Data selectUpdateTime();

}
