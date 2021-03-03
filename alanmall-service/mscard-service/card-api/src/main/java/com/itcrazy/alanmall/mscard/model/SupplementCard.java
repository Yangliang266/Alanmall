package com.itcrazy.alanmall.mscard.model;

/**
 * 换卡/挂失/补卡记录实体类
 * @author zhangli
 * 2018-09-17
 */
public class SupplementCard extends CardBaseModel{
	// 旧卡号
	private String oldCardNo;

	// 新卡号
	private String newCardNo;

	// 上传文件名
	private String fileName;

	public String getOldCardNo() {
		return oldCardNo;
	}

	public void setOldCardNo(String oldCardNo) {
		this.oldCardNo = oldCardNo;
	}

	public String getNewCardNo() {
		return newCardNo;
	}

	public void setNewCardNo(String newCardNo) {
		this.newCardNo = newCardNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
