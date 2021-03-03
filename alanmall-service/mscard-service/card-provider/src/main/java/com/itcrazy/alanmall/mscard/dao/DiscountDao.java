package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.model.CardBaseModel;
import com.itcrazy.alanmall.mscard.model.Discount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 折扣率DAO层接口
 * @author chenfei
 * 2018-10-08
 */
@Component
public interface DiscountDao extends BaseDao<CardBaseModel, Long> {

	public Long addDiscount(Discount discount);

	public Long deleteDiscountByCategoryId(
            @Param("categoryId") Long categoryId,
            @Param("companyId") Long companyId);

	/**
	 * 卡折扣列表
	 * @param discount
	 * @return
	 */
	public List<Discount> getDiscountList(
            Discount discount);
}
