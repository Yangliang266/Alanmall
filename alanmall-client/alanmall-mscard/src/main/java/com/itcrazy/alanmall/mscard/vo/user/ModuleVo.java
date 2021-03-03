package com.itcrazy.alanmall.mscard.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SuppressWarnings("rawtypes")
public class ModuleVo implements Serializable, Comparable{


	private static final long serialVersionUID = -3150976409022121234L;
	private Long id;
	private String name;
	private String url;
	private Integer showOrder;
	private List<ModuleVo> subModule=new ArrayList<ModuleVo>();
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<ModuleVo> getSubModule() {
		return subModule;
	}
	public void setSubModule(List<ModuleVo> subModule) {
		this.subModule = subModule;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object o) {
		if(subModule.size()>0){
			Collections.sort(subModule);
		 
		}
		
		ModuleVo mv=(ModuleVo)o;
		if(this.showOrder==null || mv.showOrder==null){
			return 0;
		}
		return this.showOrder-mv.showOrder;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
	
	

}
