package com.itcrazy.alanmall.mscard.action.interceptor;

import com.itcrazy.alanmall.common.client.cache.SessionCache;
import com.itcrazy.alanmall.common.client.session.RepeatUpdateSession;
import com.itcrazy.alanmall.common.client.util.RequestParam;
import com.itcrazy.alanmall.common.vo.Result;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 系统提交判断
 * 
 * @author DDD
 * 
 */
public class UpdateInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 5936731576727629542L;
	
	private static int UPDATE_LIMIT_SECONDS=3;
	private Result result = new Result();

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		
		StringBuffer sb = request.getRequestURL();


		String reqUrl = sb.toString().toLowerCase();

		if (reqUrl.startsWith("update") || reqUrl.startsWith("modify")) { // 更新方法
			int endIndex=sb.toString().indexOf("action");
			
			String requestUrl=sb.toString().substring(0, endIndex);
			 
			Cookie[] cookies = request.getCookies();
			String sid = "";
			if(cookies!=null)
			{
				for(int i=0;i<cookies.length;i++){
					if(SessionCache.COOKIE_NAME.equals(cookies[i].getName())){
						sid = cookies[i].getValue();		
						break;
					}
				}
			}

			if (sid != null && sid.length() > 5) { // 包含sid
				Boolean isRepeat = RepeatUpdateSession.isRepeat(sid,requestUrl,UPDATE_LIMIT_SECONDS);

				if (isRepeat) { // 重复
					result.setRepeatSubmit();
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					invocation.getStack().set("result", result);
					Map<String, Object> params = invocation.getInvocationContext()
							.getParameters();
					String callback = RequestParam.getRequestParam(params,
							"callback");
					if (callback != null) {
						request.setAttribute("callback", callback);
					}

					return "updateInterceptorResult";
				}
			}
		}

		
		return invocation.invoke();

	}

}
