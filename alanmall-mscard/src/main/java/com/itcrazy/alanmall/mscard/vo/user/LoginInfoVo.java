package com.itcrazy.alanmall.mscard.vo.user;

public class LoginInfoVo {

	private String companyName;
	private String loginDate;
	private String userName;
	private Integer leftSmsNum;
	private String scopeName; //管理范围名称
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getLeftSmsNum() {
		return leftSmsNum;
	}
	public void setLeftSmsNum(Integer leftSmsNum) {
		this.leftSmsNum = leftSmsNum;
	}
	public String getScopeName() {
		return scopeName;
	}
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	

}
