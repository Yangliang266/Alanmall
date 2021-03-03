package com.itcrazy.alanmall.mscard.dao;

import com.itcrazy.alanmall.common.framework.dao.BaseDao;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.RegisteredCard;
import com.itcrazy.alanmall.mscard.model.SupplementCard;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 门店卡激活（单张发卡，编辑）Dao接口
 * @author huangchunbo
 * 2018-09-29
 */
@Component
public interface RegisteredCardDao extends BaseDao<RegisteredCard, Long> {

	public int updateCardInformation(RegisteredCard registeredCard);

	public int insertRegisteredCard(SupplementCard supplementCard);

	public void saveActiveInfo(ActiveInformation activeInformation);

	public void updateCardInformationBill(RegisteredCard registeredCard);

	RegisteredCard getCardNo(@Param("cardNo") String cardNo, @Param("companyId") Long companyId);

	public int updateRegisteredCard(RegisteredCard registeredCard);

	/**
	 * 根据卡号和手机号获取支付密码
	 * @param cardNo
	 * @param companyId
	 * @return
	 */
	public String getPayPwdByCardNo(
            @Param("cardNo") String cardNo,
            @Param("companyId") Long companyId);

}
