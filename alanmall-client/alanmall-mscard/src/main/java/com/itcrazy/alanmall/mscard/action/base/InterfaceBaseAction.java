package com.itcrazy.alanmall.mscard.action.base;

import com.itcrazy.alanmall.common.framework.dto.BaseDto;
import com.itcrazy.alanmall.common.vo.PageData;
import com.itcrazy.alanmall.common.vo.Result;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.user.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接口基类
 *
 * @author DDD
 *
 */
public abstract class InterfaceBaseAction extends ActionSupport {
	private static final long serialVersionUID = -5329931031530732674L;
	protected Result result = new Result();
	protected PageData pageData = new PageData();
	protected User user = SessionData.getUser(getRequest(), getResponse());
	//2016-8-11 add by kenny begin
	public static final String NO_STORE_ID_DISP_NM = "总部";

	public void pageSet(BaseDto baseDto) {
		HttpServletRequest request = ServletActionContext.getRequest();
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		if (page != null && rows != null) {
			baseDto.setLimit(Integer.valueOf(rows));
			baseDto.setPgNumber(Integer.valueOf(page));
		}
		String order = request.getParameter("order");
		String sort = request.getParameter("sort");
		if (order != null && sort != null) {
			baseDto.setDir(order);
			baseDto.setSort(sort);
		}
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public Result getResult() {
		return result;
	}

	public PageData getPageData() {
		return pageData;
	}


}