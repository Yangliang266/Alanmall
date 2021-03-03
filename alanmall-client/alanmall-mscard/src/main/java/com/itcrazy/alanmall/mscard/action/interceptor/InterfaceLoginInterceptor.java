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
import java.util.Map;


public class InterfaceLoginInterceptor extends AbstractInterceptor {
	private final Log log = LogFactory.getLog(InterfaceLoginInterceptor.class);
	private static final long serialVersionUID = -7893720415150752485L;

	private Result result = new Result();

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> params = invocation.getInvocationContext()
				.getParameters();

		if (params.get("sid") == null) {
			result.setParamErrorInfo("sessionid");
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("result", result);
			log.error("access from " + invocation.getAction().getClass());
			return "userInterfaceLogin";
		}
		Object oSid = params.get("sid");
		StringBuilder sb = new StringBuilder();
		if (oSid instanceof String[]) {
			String[] arr = (String[]) oSid;
			for (String value : arr) {
				sb.append(value);
			}
		}
		User user = SessionData.getUser(sb.toString());
		if (user == null || user.getId() == null) {
			result.setRejectInfo();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("result", result);
			return "userInterfaceLogin";
		}

		return invocation.invoke();
	}
}
