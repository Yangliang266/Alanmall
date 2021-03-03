package com.itcrazy.alanmall.mscard.manager;

import com.itcrazy.alanmall.mscard.model.RegisteredCard;

/**
 * 卡激活接口
 * @author huangchunbo
 * 2018-09-17
 */
public interface RegisteredCardManager {

	 public void OperaregisteredCard(RegisteredCard registeredCard, String flag)throws Exception;

	RegisteredCard getCardNo(String regCardNo, Long companyId);

	public int updateRegisteredCard(RegisteredCard registeredCard)throws Exception;

}

