package com.itcrazy.alanmall.mscard.vo.card;

/**
 * 充值支付方式设置页面展示类
 * @author zhangli
 * 2018-09-05
 */
public class PayModeVo {

	// 编号
	private Long id;

	// 名称
	private String name;

	// 状态
	private int status;

	// 状态名称
	private String statusName;

	// 删除
	private String del;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}
