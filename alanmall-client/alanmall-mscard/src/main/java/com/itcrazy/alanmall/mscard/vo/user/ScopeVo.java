package com.itcrazy.alanmall.mscard.vo.user;

import java.util.ArrayList;
import java.util.List;

public class ScopeVo {

	public static final long COMPANY_START_ID=100000000;
	public static final long BRAND_START_ID  =10000000;
	private Long id;
	private String name;
	private Integer isChecked;
	private List<ScopeVo> subs=new ArrayList<ScopeVo>();
	
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
	public List<ScopeVo> getSubs() {
		return subs;
	}
	public void setSubs(List<ScopeVo> subs) {
		this.subs = subs;
	}
	public Integer getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(Integer isChecked) {
		this.isChecked = isChecked;
	}
	
	

}
