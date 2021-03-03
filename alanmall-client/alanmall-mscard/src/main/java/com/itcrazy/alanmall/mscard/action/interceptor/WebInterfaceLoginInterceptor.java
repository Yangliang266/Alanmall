package com.itcrazy.alanmall.mscard.action.interceptor;


import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.common.vo.Result;
import com.itcrazy.alanmall.user.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebInterfaceLoginInterceptor extends AbstractInterceptor {
	private final Log log = LogFactory.getLog(WebInterfaceLoginInterceptor.class);
	private static final long serialVersionUID = -7893720415150752485L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();


		User user = SessionData.getUser(request, response);
		if (user == null) { //判断是否登录,以及登陆是否过期,跳转到登陆界面
			log.error("user == null");
			Result result=new Result();
			result.setRejectInfo();
			request.setAttribute("result", result);
			return "userInterfaceLogin";
		}

		
		
		return invocation.invoke();

	}



	
	
}
