package com.itcrazy.alanmall.mscard.action.user;


import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.service.LoginModuleService;

/**
 * 获取登录用户菜单
 * 
 * @author DDD
 * 
 */
public class ModuleAction extends InterfaceBaseAction {


	private static final long serialVersionUID = 6372202197141557484L;

	private Long parentId;

	private LoginModuleService loginModuleService;

	public String getModuleList() {
		if (user.getCompanyId() == null) {
			return SUCCESS;
		}
		String excludes="";//排除不显示的菜单
		if(parentId!=null && parentId!=0 && user.getStoreId()==null){//单个门店时候才显示的菜单
			excludes=",1116,1160,1165,1177,1178,1209,";
		}
			
		pageData.rows = loginModuleService.getLoginModuleList(
				user, parentId,excludes);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setLoginModuleService(LoginModuleService loginModuleService) {
		this.loginModuleService = loginModuleService;
	}

}
