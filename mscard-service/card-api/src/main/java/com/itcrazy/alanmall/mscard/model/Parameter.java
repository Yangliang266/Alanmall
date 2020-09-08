package com.itcrazy.alanmall.mscard.model;

/**
 * 卡系统参数实体类
 * @author zhangli
 * 2018-09-05
 */
public class Parameter extends CardBaseModel{
	// 读卡器型号
	private Integer type;

	// 芯片卡密码
	private String pwd;

	// 卡号前缀
	private String prefix;

	// 自然增长段长度
	private int length;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
