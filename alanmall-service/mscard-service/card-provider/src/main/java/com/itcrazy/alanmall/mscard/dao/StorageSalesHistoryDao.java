package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.model.StorageSalesHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 储值消费一览DAO
 * @author chenfei
 * 2018-10-10
 */
@Component
public interface StorageSalesHistoryDao extends BaseDao<StorageSalesHistory, Long> {

	public int addStorageSalesHistory(StorageSalesHistory storageSalesHistory);

	/**
	 * 根据订单号获取储值消费记录
	 * @param orderNo
	 * @param companyId
	 * @return
	 */
	public StorageSalesHistory getStorageSalesHistoryByOrderNo(
            @Param("orderNo") String orderNo, @Param("companyId") Long companyId);

	/**
	 * 删除订单
	 * @param orderNo
	 * @param companyId
	 * @param userId
	 * @return
	 */
	public int delete(@Param("orderNo") String orderNo,
                      @Param("companyId") Long companyId, @Param("userId") Long userId);

	/**
	 * 根据卡号获取最后一次消费的记录
	 * @param cardNo
	 * @param companyId
	 * @return
	 */
	public StorageSalesHistory getLastStorageSalesHistoryByCardNo(
            @Param("cardNo") String cardNo, @Param("companyId") Long companyId);
}
