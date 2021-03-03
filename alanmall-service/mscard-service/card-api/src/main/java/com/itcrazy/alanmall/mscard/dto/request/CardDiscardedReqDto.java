package com.itcrazy.alanmall.mscard.dto.request;


import com.itcrazy.alanmall.common.framework.dto.CardBaseRequestDto;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;

/**
 * 作废dto实体类
 * @author yangliang
 * 2018-09-10
 */
public class CardDiscardedReqDto extends CardBaseRequestDto {
	/**
	 *
	 */
	private static final long serialVersionUID = -484438904784258758L;

	// 查询卡号
	private String cardNo;

	// 商家id
	private Long companyId;

	// 作废单号
	private String receiptNo;

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public void requestCheck() {

	}
}
