package com.itcrazy.alanmall.mscard.vo.card;

import java.util.Date;

/**
 * 记名卡信息实体类
 * @author huangchunbo
 * 2018-09-19
 */
public class RegisteredCardVo {


    // 卡号
	private String cardNo;

    // 姓名
	private String userName;

	// 性别
	private String sex;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
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

}
