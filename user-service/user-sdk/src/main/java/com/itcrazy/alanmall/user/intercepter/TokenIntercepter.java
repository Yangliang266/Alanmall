package com.itcrazy.alanmall.user.intercepter;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.common.util.CookieUtil;
import com.itcrazy.alanmall.user.IUserLoginService;
import com.itcrazy.alanmall.user.dto.CheckAuthRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;

public class TokenIntercepter extends HandlerInterceptorAdapter {

    @Reference(timeout = 3000)
    IUserLoginService iUserLoginService;

    public static String ACCESS_TOKEN="access_token";

    public static String USER_INFO_KEY="userInfo";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1 判断hander是否是 控制器方法 不是返回true 不需拦截
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        MethodHandle methodHandle = (MethodHandle) handler;

        // 2 判断是否被anoymous注解标记 被标记 返回true 不需要拦截
        if (isAnoymous(methodHandle)) {
            return true;
        }
        // 3 cookie 获取 token
        String token = CookieUtil.getCookieValue(request,ACCESS_TOKEN);

        // 3.1 token获取不到 返回false token获取失败
        if (StringUtils.isEmpty(token)) {
            ResponseData responseData = new ResponseUtil<>().setErrorMsg("token 已失效");
            // 44 45 目的？
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(JSON.toJSON(responseData).toString());
            return false;
        }

        // 3.2 token获取成功 验证token 验证失败 返回false
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
        checkAuthRequest.setToken(token);
        iUserLoginService.validToken(checkAuthRequest);

        // 3.3 token验证成功 setAttribute 后续使用

        return super.preHandle(request, response, handler);
    }

    private boolean isAnoymous(MethodHandle methodHandle) {
        return true;
    }
}
