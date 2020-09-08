package com.itcrazy.alanmall.mscard.vo.user;


public class RoleVo {

	private Long id;
	private String name;
	private String companyName;
	private String remark;
	private Integer isDefault;
	private String roleLevelName;
	private Integer status;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getRoleLevelName() {
		return roleLevelName;
	}
	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
