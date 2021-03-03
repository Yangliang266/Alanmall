package com.itcrazy.alanmall.mscard.model;

/**
 * 充值支付方式设置实体类
 * @author zhangli
 * 2018-09-04
 */
public class PayMode extends CardBaseModel{
	// 编号
	private Long id;

	// 名称
	private String name;

	// 状态
	private Integer status;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del;
	}

}
