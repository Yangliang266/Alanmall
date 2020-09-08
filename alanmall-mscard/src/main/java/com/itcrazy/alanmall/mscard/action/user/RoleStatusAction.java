package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.user.carddto.UserDto;
import com.itcrazy.alanmall.user.manager.RoleManager;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.Role;

public class RoleStatusAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -5606145801476473824L;

	private Role role;
	@Reference
	private RoleManager roleManager;
	@Reference
	private UserManager userManager;

	public String updateRoleStatus() {
		if (role.getStatus() == null) {
			result.setParamErrorInfo("status");
			return SUCCESS;
		}
		if (role.getId() == null) {
			result.setParamErrorInfo("id");
			return SUCCESS;
		}
		if (role.getStatus() != Role.STATUS_FLAG_OK) {
			UserDto udto = new UserDto();
			udto.setRoleId(role.getId());
			Integer t = userManager.getPageTotal(udto);
			if (t > 0) {
				result.setResultInfo(1, "请先关闭该角色下的所有账户后，再关闭角色。");
				return SUCCESS;
			}
		}
		Role ur = new Role();
		ur.setId(role.getId());
		ur.setStatus(role.getStatus());
		roleManager.updateRole(ur);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
