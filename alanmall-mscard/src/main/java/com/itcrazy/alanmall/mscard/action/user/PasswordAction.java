package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.common.client.util.MD5Util;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

/**
 * 登录帐号修改自己密码
 * @author DDD
 *
 */
public class PasswordAction extends InterfaceBaseAction{


	private static final long serialVersionUID = 5430910441675773525L;
	private String oldPassword;
	private String newPassword;

	@Reference
	private UserManager userManager;

	/**
	 * 登录用户修改自己密码
	 * @return
	 */
	public String updatePassword() {

		if (oldPassword == null) {
			result.setParamErrorInfo("oldPassword");
			return SUCCESS;
		}
		if (newPassword == null) {
			result.setParamErrorInfo("newPassword");
			return SUCCESS;
		}

		User user = SessionData.getUser(getRequest(), getResponse());
		String md5Pass = MD5Util.MD5(oldPassword);
		if (!md5Pass.equals(user.getPassword())) {
			result.setCode(1000);
			return SUCCESS;
		}
		User cu=new User();
		cu.setId(user.getId());
		cu.setPassword(MD5Util.MD5(newPassword));
		userManager.updateUser(cu); //更新数据库
		
		user.setPassword(cu.getPassword());
		SessionData.setUser(getRequest(), getResponse(), user); //更新缓存
		
		result.setSuccessInfo();
		return SUCCESS;
	}

	

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	


}
