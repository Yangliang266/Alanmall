package com.itcrazy.alanmall.mscard.session;

import com.itcrazy.alanmall.common.client.cache.SessionCache;
import com.itcrazy.alanmall.mscard.vo.user.ModuleVo;
import com.itcrazy.alanmall.user.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class SessionData {

	public final static String User_SID_KEY = "MERCHANT_SID_KEY";
	public final static String User_SID_CODE = "COMPANY_SID_CODE";
	
	private static Log log=LogFactory.getLog(SessionData.class);
	
	public final static int SEESSION_TIME_OUT = 60;// 过期时间设置24小时
	
	public static void setUser(String sid, User user) {
		SessionCache.put(SessionData.User_SID_KEY + sid, user, 16*SEESSION_TIME_OUT);
	}
	public static User getUser(String sid) {
		return (User)SessionCache.get(SessionData.User_SID_KEY + sid);
	}
	public static User getUser(HttpServletRequest request, HttpServletResponse response){
		return (User)SessionCache.get(request, response, SessionData.User_SID_KEY);
	}

	public static void setUser(HttpServletRequest request, HttpServletResponse response,User user){
		SessionCache.put(request, response, SessionData.User_SID_KEY, user,60*8);
	}
	
	public static void setModuleList(Long companyId,Long roleId,Long parentId,List<ModuleVo> moduleList){
		String key="getModuleList_"+companyId+"_"+roleId+"_"+parentId;
		SessionCache.put(key, moduleList,60);
	}
	
	@SuppressWarnings("unchecked")
	public static List<ModuleVo> getModuleList(Long companyId,Long roleId,Long parentId){
		String key="getModuleList_"+companyId+"_"+roleId+"_"+parentId;
		Object o=SessionCache.get(key);
		if(o==null){
			log.error("modulelist null");
			return null;
		}
		
		return (List<ModuleVo>)o;
	}
	public static void removeModuleList(Long companyId,Long roleId,Long parentId){
		String key="getModuleList_"+companyId+"_"+roleId+"_"+parentId;
		SessionCache.remove(key);
	}
	//图片验证码
	public static void setAuthCode(HttpServletRequest request, HttpServletResponse response, String code) {
		SessionCache.put(request,response,SessionData.User_SID_CODE , code, 10); //验证码10分钟失效
	}
	
	
	public static String getAuthCode(HttpServletRequest request, HttpServletResponse response) {
		return (String)SessionCache.get(request,response,SessionData.User_SID_CODE ); 
	}
	
	/**
	 * 短信验证码
	 * @param request
	 * @param response
	 * @param code
	 */
	public static void setSmsCode(HttpServletRequest request, HttpServletResponse response,String mobile, String code) {
		SessionCache.put(request,response, mobile , code, 10); //验证码10分钟失效
	}
	
	
	public static String getSmsCode(HttpServletRequest request, HttpServletResponse response,String mobile) {
		return (String)SessionCache.get(request,response,mobile ); 
	}

}
