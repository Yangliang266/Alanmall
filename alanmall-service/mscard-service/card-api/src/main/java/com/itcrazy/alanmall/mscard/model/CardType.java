package com.itcrazy.alanmall.mscard.model;

/**
 * 读卡器型号实体类
 * @author zhangli
 * 2018-09-04
 */
public class CardType extends CardBaseModel{
	// 编号
	private Long id;

	// 型号名称
	private String name;

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

}
