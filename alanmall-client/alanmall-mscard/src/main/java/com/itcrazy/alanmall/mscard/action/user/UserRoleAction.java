package com.itcrazy.alanmall.mscard.action.user;


import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.user.carddto.RoleDto;
import com.itcrazy.alanmall.user.manager.RoleManager;
import com.itcrazy.alanmall.user.model.Role;
import com.itcrazy.alanmall.user.model.RoleLevel;

public class UserRoleAction extends InterfaceBaseAction{



	private static final long serialVersionUID = -5490805738820172508L;
	@Reference
	private RoleManager roleManager;
	
	
	public String getUserRoleList(){
		RoleDto dto=new RoleDto();
		
		dto.setRoleLevelIds(RoleLevel.ID_COMPANY+","+RoleLevel.ID_BRAND+","+RoleLevel.ID_SHOP);
		dto.setCompanyId(user.getCompanyId());
		dto.setStatus(Role.STATUS_FLAG_OK);
		dto.setLimit(Integer.MAX_VALUE);
	    pageData.rows=roleManager.getPageList(dto);
		
		result.setSuccessInfo();
		return SUCCESS;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}
	
}
