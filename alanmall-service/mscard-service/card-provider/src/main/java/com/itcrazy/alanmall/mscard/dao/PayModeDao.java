package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.dto.Base.PayModeDto;
import com.itcrazy.alanmall.mscard.model.PayMode;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 充值支付方式设置DAO层接口
 * @author zhangli
 * 2018-09-05
 */
@Component
public interface PayModeDao extends BaseDao<PayMode, Long> {

	public List<PayMode> getPageList(PayModeDto payModeDto);

}
