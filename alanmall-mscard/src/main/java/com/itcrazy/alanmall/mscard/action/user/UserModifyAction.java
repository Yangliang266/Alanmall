package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.common.client.util.MD5Util;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

/**
 * 用户状态,重置密码
 * @author DDD
 *
 */
public class UserModifyAction extends InterfaceBaseAction {

	private static final long serialVersionUID = -6419368447328657417L;

	private User companyUser;
	@Reference
	private UserManager userManager;

	public String updateUserModify() {
		if (companyUser.getId() == null) {
			result.setParamErrorInfo("companyUsr.id");
			return SUCCESS;
		}
		if(companyUser.getPassword()!=null){
			String pass=companyUser.getPassword().substring(5);
			companyUser.setPassword(MD5Util.MD5(pass));
		}
		userManager.updateUser(companyUser);
		result.setSuccessInfo();
		return SUCCESS;
	}

	 

	public User getCompanyUser() {
		return companyUser;
	}



	public void setCompanyUser(User companyUser) {
		this.companyUser = companyUser;
	}



	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

}
