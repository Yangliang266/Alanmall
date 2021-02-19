package com.itcrazy.alanmall.user.intercepter;

import com.alibaba.fastjson.JSON;
import com.itcrazy.alanmall.common.result.ResponseData;
import com.itcrazy.alanmall.common.result.ResponseUtil;
import com.itcrazy.alanmall.common.util.CookieUtil;
import com.itcrazy.alanmall.user.manager.IUserLoginService;
import com.itcrazy.alanmall.user.annotation.Anoymous;
import com.itcrazy.alanmall.user.constants.SysRetCodeConstants;
import com.itcrazy.alanmall.user.dto.CheckAuthRequest;
import com.itcrazy.alanmall.user.dto.CheckAuthResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class TokenIntercepter extends HandlerInterceptorAdapter {

    @DubboReference
    IUserLoginService iUserLoginService;

    public static String ACCESS_TOKEN="access_token";

    public static String USER_INFO_KEY="userInfo";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1 判断hander是否是 控制器方法 不是返回true 不需拦截
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }



        HandlerMethod methodHandle = (HandlerMethod) handler;
        // 2 判断是否被anoymous注解标记 被标记 返回true 不需要拦截
        if (isAnoymous(methodHandle)) {
            return true;
        }
        // 3 cookie 获取 token
        String token = CookieUtil.getCookieValue(request,ACCESS_TOKEN);

        // 3.1 token获取不到 返回false token获取失败
        if (StringUtils.isEmpty(token)) {
            ResponseData responseData = new ResponseUtil().setErrorMsg("token 已失效");
            // 44 45 目的？
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(JSON.toJSON(responseData).toString());
            return false;
        }

        // 3.2 token获取成功 验证token 验证失败 返回false
        CheckAuthRequest checkAuthRequest = new CheckAuthRequest();
        checkAuthRequest.setToken(token);
        CheckAuthResponse checkAuthResponse = iUserLoginService.validToken(checkAuthRequest);

        if (SysRetCodeConstants.SUCCESS.getCode().equals(checkAuthResponse.getCode())) {
            // 3.3 token验证成功 setAttribute 后续使用
            request.setAttribute(USER_INFO_KEY, checkAuthResponse.getUserinfo());
//            log.info("suucess: " + checkAuthResponse.getUserinfo());
            return super.preHandle(request, response, handler);
        }

        ResponseData responseData=new ResponseUtil().setErrorMsg(checkAuthResponse.getMsg());
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(JSON.toJSON(responseData).toString());
//        log.info("fali: " + checkAuthResponse.getUserinfo());
        return false;
    }

    /**
     * @Author yangl
     * @Description //TODO 注解标记为true 不需要拦截
     * @Date 10:14 2020/9/26
     * @Param [handlerMethod]
     * @return boolean
     **/
    private boolean isAnoymous(HandlerMethod handlerMethod) {
        Object bean = handlerMethod.getBean();
        Class clazz = bean.getClass();

        // 判断控制器handler 是否存在注解标记
        if (clazz.getAnnotation(Anoymous.class) != null) {
            return true;
        }

        // 判断控制器方法上是否存在注解标记
        Method method = handlerMethod.getMethod();
        return method.getAnnotation(Anoymous.class)!=null;
    }
}
