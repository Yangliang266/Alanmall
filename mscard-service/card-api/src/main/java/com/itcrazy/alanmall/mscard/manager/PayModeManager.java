package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.dto.Base.PayModeDto;
import com.itcrazy.alanmall.mscard.model.PayMode;

import java.util.List;

/**
 * 充值支付方式设置接口
 * @author zhangli
 * 2018-09-04
 */
public interface PayModeManager {

	public List<PayMode> getPageList(PayModeDto payModeDto);

	public int updatePayMode(PayMode payMode);

	public PayMode addPayMode(PayMode payMode);

}
