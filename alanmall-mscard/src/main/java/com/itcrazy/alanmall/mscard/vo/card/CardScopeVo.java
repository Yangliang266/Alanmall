package com.itcrazy.alanmall.mscard.vo.card;

import java.util.ArrayList;
import java.util.List;

/**
 * CardScopeVo类，在ScopeVo上增加了部分属性
 * @author chenfei
 * 2018-09-26
 */
public class CardScopeVo {

	public static final long COMPANY_START_ID=100000000;
	public static final long BRAND_START_ID  =10000000;
	private Long id;
	private String strId;
	private String name;
	private Integer isChecked;
	private List<CardScopeVo> subs=new ArrayList<CardScopeVo>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Integer isChecked) {
		this.isChecked = isChecked;
	}
	public List<CardScopeVo> getSubs() {
		return subs;
	}
	public void setSubs(List<CardScopeVo> subs) {
		this.subs = subs;
	}
}
