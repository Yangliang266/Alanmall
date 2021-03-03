package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.model.Consume;
import com.itcrazy.alanmall.mscard.model.ExternalAPICardInfo;
import com.itcrazy.alanmall.mscard.model.ExternalAPIConsumeResult;

/**
 * 卡系统对外接口
 * @author chenfei
 * 2018-10-10
 */
public interface ExternalAPIManager {

	/**
	 * 消费接口（传入扣款总金额，本金金额，奖励金额，挂账金额）
	 * @param consume
	 * @return
	 * @throws Exception
	 */
	public int consume(Consume consume) throws Exception;

	/**
	 * 消费接口(比int consume(Consume consume)方法多个remarks)
	 * @param consume
	 * @param remarks
	 * @return
	 * @throws Exception
	 */
	public int consumeWithRemarks(Consume consume, String remarks) throws Exception;

	/**
	 * 卡查询接口
	 * @param cardNo
	 * @param brandId
	 * @param storeId
	 * @param companyId
	 * @return
	 */
	public ExternalAPICardInfo query(String cardNo, Long brandId, Long storeId, Long companyId);

	/**
	 * 撤销消费接口
	 * @param orderNo
	 * @param companyId
	 * @param userId
	 * @return
	 */
	public int revokeConsume(String orderNo, Long companyId, Long userId) throws Exception;

	/**
	 * 自动计算扣款金额的消费接口（只传入扣款总金额）
	 * @param consume
	 * @return
	 * @throws Exception
	 */
	public ExternalAPIConsumeResult autoReckonConsume(Consume consume) throws Exception;

}
