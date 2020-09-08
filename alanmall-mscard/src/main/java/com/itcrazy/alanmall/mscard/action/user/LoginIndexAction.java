package com.itcrazy.alanmall.mscard.action.user;

import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.service.LoginModuleService;
import com.itcrazy.alanmall.mscard.vo.user.LoginIndexVo;
import com.itcrazy.alanmall.mscard.vo.user.ModuleVo;
import com.itcrazy.alanmall.user.model.Module;

import java.util.List;

/**
 * 登录landing page显示界面
 * @author DDD
 * 
 */
public class LoginIndexAction extends InterfaceBaseAction {

	private static final long serialVersionUID = 2366301491377013530L;
	private LoginIndexVo detailVo = new LoginIndexVo();

	private LoginModuleService loginModuleService;

	public String getLoginIndexDetail() {
		detailVo.setNewRechargeSum(0D);
		detailVo.setRechargeLeft(0.0);
		detailVo.setYesCashConsu(0.0);
		detailVo.setYesCommentScore(0);
		detailVo.setYesConsu(0.0);
		detailVo.setYesRechargeConsu(0.0);
		detailVo.setYesRewardConsu(0.0);

		List<ModuleVo> mvList = loginModuleService.getLoginModuleList(
				user, Module.ID_TOP_PARENT,"");
		
		if (mvList != null) {
			for (ModuleVo mv : mvList) {
				
				if (mv.getId().equals(Module.ID_CRM_ANAY)) {
					detailVo.setIsShowAnay(Module.IS_FLAG_YES);
				}
				if (mv.getId().equals(Module.ID_CRM_CONFIG)) {
					detailVo.setIsShowConfig(Module.IS_FLAG_YES);
				}
				if (mv.getId().equals(Module.ID_CRM_MEMBER)) {
					detailVo.setIsShowMember(Module.IS_FLAG_YES);
				}
				if (mv.getId().equals(Module.ID_CRM_PROM)) {
					detailVo.setIsShowProm(Module.IS_FLAG_YES);
				}
				if (mv.getId().equals(Module.ID_CRM_TRADE)) {
					detailVo.setIsShowTrade(Module.IS_FLAG_YES);
				}
				if (mv.getId().equals(Module.ID_CRM_WECHAT)) {
					detailVo.setIsShowWechat(Module.IS_FLAG_YES);
				}
			}
		}
		result.setSuccessInfo();
		return SUCCESS;

	}

	 

	public LoginIndexVo getDetailVo() {
		return detailVo;
	}

	public void setLoginModuleService(LoginModuleService loginModuleService) {
		this.loginModuleService = loginModuleService;
	}

}
