package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.model.CreditSetting;
import com.itcrazy.alanmall.mscard.model.SupplementCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * 挂账设定Dao层接口
 * @author zhangli
 * 2018-09-21
 */
@Component
public interface CreditSettingDao extends BaseDao<CreditSetting, Long> {

	// 新增CreditSetting
	public int insertCreditSetting(SupplementCard supplementCard);

	// 根据卡号获取挂帐设定
	public List<CreditSetting> select(
            @Param("motherCardNo") String motherCardNo,
            @Param("companyId") Long companyId);

	// 母卡信息复制到子卡
	public int copyCreditSetting(CreditSetting creditSetting);

	public Long deleteCreditSettingByCardNo(
            @Param("cardNo") String cardNo,
            @Param("companyId") Long companyId);

	public Long addCreditSetting(CreditSetting creditSetting);

	/**
	 * 获取本卡在本门店的挂账额度
	 * @param cardNo
	 * @param storeId
	 * @param companyId
	 * @return
	 */
	public BigDecimal getCreditSettingByCardNoAndStoreId(
            @Param("cardNo") String cardNo,
            @Param("storeId") Long storeId,
            @Param("companyId") Long companyId);
}
