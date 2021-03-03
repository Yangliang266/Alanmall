package com.itcrazy.alanmall.mscard.service;

import com.itcrazy.alanmall.mscard.vo.user.ModuleVo;
import com.itcrazy.alanmall.user.model.User;

import java.util.List;

/**
 * 登录模块
 * @author DDD
 *
 */
public interface LoginModuleService {

	/**
	 * 
	 * @param user
	 * @param moduleParentId
	 * @param excludes 
	 * @return
	 */
	public List<ModuleVo> getLoginModuleList(User user, Long moduleParentId, String excludes);
}
