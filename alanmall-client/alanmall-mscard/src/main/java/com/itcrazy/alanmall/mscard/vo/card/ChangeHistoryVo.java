package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 换卡/挂失/补卡记录页面展示类
 * @author zhangli
 * 2018-09-17
 */
public class ChangeHistoryVo{

	// 编号
	private Long id;

	// 旧卡号
	private String oldCardNo;

	// 新卡号
	private String newCardNo;

	// 换卡补卡区分
	private Integer type;

	// 充值余额总和
	private Integer rechargeBalance;

	// 充值奖励余额总和
	private Integer reward;

	// 挂账总额
	private Double credit;

	// 卡类别名称
	private String categoryName;

	// 卡状态
	private Integer status;

	// 卡状态名称
	private String statusName;

	// 挂失操作时间
	private String createTime;

	// 挂失操作人
	private String createName;

	// 挂失补办操作时间
	private String updateTime;

	// 挂失补办操作人
	private String updateName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getRechargeBalance() {
		return rechargeBalance;
	}

	public void setRechargeBalance(Integer rechargeBalance) {
		this.rechargeBalance = rechargeBalance;
	}

	public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
