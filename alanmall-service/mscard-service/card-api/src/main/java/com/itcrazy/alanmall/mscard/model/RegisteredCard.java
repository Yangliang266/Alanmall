package com.itcrazy.alanmall.mscard.model;

import java.util.Date;

/**
 * 记名卡信息实体类
 * @author huangchunbo
 * 2018-09-19
 */
public class RegisteredCard extends CardBaseModel{
    // 卡号
	private String cardNo;

    // 姓名
	private String userName;

	// 性别
	private Integer sex;

	// 手机号码
	private String telephone;

	// 身份证号码
	private String idNumber;

	// 支付密码
	private String payPsw;

	// 电子邮件
	private String mail;

	// 送货地址
	private String address;

	// 生日
	private Date birthday;

    // 目的门店
    private Long storeTo;

    // 卡状态
 	private int status;

 	// 是否记名卡
 	private int isNamed;

 	// 卡支付密码是否必填
	private  int isPswMust;

	// 发卡时间
	private Date publishTime;

	// 发卡人
	private Long publishId;

	// 卡类别
	private Integer category;

	// 会员等级
	private Long memberLevelId;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPayPsw() {
		return payPsw;
	}

	public void setPayPsw(String payPsw) {
		this.payPsw = payPsw;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getStoreTo() {
		return storeTo;
	}

	public void setStoreTo(Long storeTo) {
		this.storeTo = storeTo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsNamed() {
		return isNamed;
	}

	public void setIsNamed(int isNamed) {
		this.isNamed = isNamed;
	}

	public int getIsPswMust() {
		return isPswMust;
	}

	public void setIsPswMust(int isPswMust) {
		this.isPswMust = isPswMust;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Long getPublishId() {
		return publishId;
	}

	public void setPublishId(Long publishId) {
		this.publishId = publishId;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Long getMemberLevelId() {
		return memberLevelId;
	}

	public void setMemberLevelId(Long memberLevelId) {
		this.memberLevelId = memberLevelId;
	}

}
