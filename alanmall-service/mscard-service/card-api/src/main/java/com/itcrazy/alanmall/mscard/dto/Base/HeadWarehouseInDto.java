package com.itcrazy.alanmall.mscard.dto.Base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import lombok.Data;

import java.util.Date;

/**
 * 总部入库DTO实体类
 * @author luxf
 * 2018-09-04
 */
@Data
public class HeadWarehouseInDto extends BaseDto {

	private static final long serialVersionUID = -3604307499770044466L;

	// 制卡批次号
	private String serialNo;

	// 卡号
	private String cardNo;

	// 结束卡号
	private String cardNoEnd;

	// 入库单号
	private String receiptNo;

	// 制卡开始时间
	private Date createTimeBegin;

	// 制卡结束时间
	private Date createTimeEnd;

	// 商家ID
	private Long companyId;

	// 入库数量
	private String cardNoNum;

	public String getCardNoNum() {
		return cardNoNum;
	}

	public void setCardNoNum(String cardNoNum) {
		this.cardNoNum = cardNoNum;
	}

	public String getCardNoEnd() {
		return cardNoEnd;
	}

	public void setCardNoEnd(String cardNoEnd) {
		this.cardNoEnd = cardNoEnd;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	private String isDeleted;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Date getCreateTimeBegin() {
		return createTimeBegin;
	}

	public void setCreateTimeBegin(Date createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
