package com.itcrazy.alanmall.mscard.model;

/**
 * 跳号规则设置model实体类
 * @author zhangzhongtian
 * 2018-09-17
 */
public class JumpNumberRule extends CardBaseModel{
	// 编号
	private Long id;

	// 跳号数字
	private Integer jumpNumber;

	// 状态
	private int status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getJumpNumber() {
		return jumpNumber;
	}

	public void setJumpNumber(Integer jumpNumber) {
		this.jumpNumber = jumpNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
