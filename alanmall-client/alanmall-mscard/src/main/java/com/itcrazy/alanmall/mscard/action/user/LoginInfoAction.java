package com.itcrazy.alanmall.mscard.action.user;

import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.mscard.vo.user.LoginInfoVo;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.merchant.manager.CompanyManager;
import com.itcrazy.alanmall.merchant.model.Company;

import java.util.Date;

/**
 * 获取登录后用户提示信息
 * @author DDD
 *
 */
public class LoginInfoAction extends InterfaceBaseAction {
	private static final long serialVersionUID = -1148961845290272625L;

	private LoginInfoVo detailVo=new LoginInfoVo();;
	
	private CompanyManager companyManager;
 
	
	public String getLoginInfoDetail(){
		user= SessionData.getUser(super.getRequest(), super.getResponse());
		
		Date d=new Date();
		detailVo.setLoginDate(DateFormat.dateTimeToChinaDate(d));
		detailVo.setUserName(user.getRealName());
		Company company=companyManager.getCompanyById(user.getCompanyId());
		if(company!=null){
			detailVo.setCompanyName(company.getName());
		}else{
			detailVo.setCompanyName("选择商家");
		}
		detailVo.setScopeName(detailVo.getCompanyName());
		result.setSuccessInfo();
		return SUCCESS;
	}

	public LoginInfoVo getDetailVo() {
		return detailVo;
	}

	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}

}
