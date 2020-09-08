package com.itcrazy.alanmall.mscard.action.page;


import com.itcrazy.alanmall.mscard.action.base.PageBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.common.client.cache.SessionCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 菜单页面处理类
 * @author DDD
 *
 */
public class PageAction extends PageBaseAction{
	private static final long serialVersionUID = -6154662773034494487L;
	private Long m1; //菜单
	private Long m2;
	private Long m3;
	private Long m4;

	public String index() {
		if(user.getStoreId()!=null && user.getStoreId()==0){//
			return INPUT;
		}

		return SUCCESS;
	}

	@SuppressWarnings("unused")
	public String quit() {
		HttpServletRequest request = getRequest();
		SessionCache.remove(getRequest(), getResponse(),
				SessionData.User_SID_KEY);
		HttpSession session = request.getSession();
		session = null;
		return SUCCESS;
	}

	public String loginPage(){
		return SUCCESS;
	}
	public Long getM1() {
		return m1;
	}

	public void setM1(Long m1) {
		this.m1 = m1;
	}

	public Long getM2() {
		return m2;
	}

	public void setM2(Long m2) {
		this.m2 = m2;
	}

	public Long getM3() {
		return m3;
	}

	public void setM3(Long m3) {
		this.m3 = m3;
	}

	public Long getM4() {
		return m4;
	}

	public void setM4(Long m4) {
		this.m4 = m4;
	}


}
