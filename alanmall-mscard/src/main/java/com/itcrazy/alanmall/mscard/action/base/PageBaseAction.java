package com.itcrazy.alanmall.mscard.action.base;


import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.user.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web页面请求基类
 * 
 * @author DDD
 *
 */
public abstract class PageBaseAction extends ActionSupport {
	private static final long serialVersionUID = 1665217731754671541L;
	private final static Log log = LogFactory.getLog(PageBaseAction.class);
	protected User user;
	private String path;

	private Integer isDevModel;
	
	public PageBaseAction() { // 页面直接读取的数据
		try {
			user = SessionData.getUser(getRequest(), getResponse());
			path = SysConfig.getCommonConf("SERVER_HOST");
			 
			String devModel = SysConfig.getCommonConf("IS_DEV_MODEL").trim();
			isDevModel = Integer.valueOf(devModel);

		} catch (Exception e) {
			log.error("BaseAction", e);
		}
	}

	/**
	 * 得到当前可操作Response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 得到当前可操作Request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getIsDevModel() {
		return isDevModel;
	}

 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIsDevModel(Integer isDevModel) {
		this.isDevModel = isDevModel;
	}

	 
}