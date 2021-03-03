package com.itcrazy.alanmall.mscard.filter;

import com.itcrazy.alanmall.common.client.cache.SessionCache;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Cookie[] cookies = httpRequest.getCookies();
		String cookieValue = null;
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++){
				if(SessionCache.COOKIE_NAME.equals(cookies[i].getName())){
					cookieValue = cookies[i].getValue();		
					break;
				}
			}
		}
		
		
		if(cookieValue == null){
			 cookieValue = RandomNumUtil.getUUIDString();
			
			 Cookie cookie = new Cookie(SessionCache.COOKIE_NAME, cookieValue);
			 cookie.setPath("/");
			 httpResponse.addCookie(cookie);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
		
	}

}
