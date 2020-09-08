package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 跳号规则设置页面展示类
 * @author zhangzhongtian
 * 2018-09-19
 */
public class JumpNumberRuleVo {

	// 编号
	private Long id;

	// 跳号数字
	private int jumpNumber;

	// 状态
	private int status;

	// 状态名称
	private String statusName;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getJumpNumber() {
		return jumpNumber;
	}

	public void setJumpNumber(int jumpNumber) {
		this.jumpNumber = jumpNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
