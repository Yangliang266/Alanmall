package com.itcrazy.alanmall.mscard.vo.user;

import java.util.ArrayList;
import java.util.List;

public class RoleModuleVo {

	private Long id;
	private String name;
	private Integer leaf; //是否叶子节点
	private Integer checked;
	private List<RoleModuleVo> subs=new ArrayList<RoleModuleVo>();
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
	public Integer getLeaf() {
		return leaf;
	}
	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	public List<RoleModuleVo> getSubs() {
		return subs;
	}
	public void setSubs(List<RoleModuleVo> subs) {
		this.subs = subs;
	}
	

}
