package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.vo.user.ScopeVo;
import com.itcrazy.alanmall.mscard.vo.user.UserVo;
import com.itcrazy.alanmall.common.client.util.MD5Util;
import com.itcrazy.alanmall.merchant.manager.BrandManager;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.user.carddto.UserDto;
import com.itcrazy.alanmall.user.manager.RoleManager;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.manager.UserScopeManager;
import com.itcrazy.alanmall.user.model.Role;
import com.itcrazy.alanmall.user.model.RoleLevel;
import com.itcrazy.alanmall.user.model.User;
import com.itcrazy.alanmall.user.model.UserScope;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理
 * 
 * @author DDD
 * 
 */
public class UserAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -6419368447328657417L;

	private User companyUser;
	private String storeIds;// 选择管理的门店
	private Long userId;
	private UserDto userDto;
	private User detailVo;
	@Reference
	private UserManager userManager;
	private BrandManager brandManager;
	private StoreManager storeManager;
	@Reference
	private RoleManager roleManager;
	@Reference
	private UserScopeManager userScopeManager;
	 
	public String updateUser() {
		if (companyUser == null) {
			result.setParamErrorInfo("User");
			return SUCCESS;
		}
		if (companyUser.getRealName() == null) {
			result.setParamErrorInfo("realname");
			return SUCCESS;
		}
		if (companyUser.getMobile() == null
				|| companyUser.getMobile().length() != 11) {
			result.setParamErrorInfo("手机号码");
			return SUCCESS;
		}
		if (companyUser.getRoleId() == null) {
			result.setParamErrorInfo("角色");
			return SUCCESS;
		}
		if(companyUser.getIsAllScope()==null){
			result.setParamErrorInfo("是否全部门店");
			return SUCCESS;
		}
		if (storeIds == null) {
			result.setParamErrorInfo("门店");
			return SUCCESS;
		}
		Role r = roleManager.getRoleById(companyUser.getRoleId());
		if (r == null) {
			result.setParamErrorInfo("角色不存在");
			return SUCCESS;
		}

		companyUser.setCompanyId(user.getCompanyId());
		if (r.getRoleLevelId() == RoleLevel.ID_COMPANY) {// 商家角色

			companyUser.setBrandId(0L);
			companyUser.setStoreId(0L);
		}
		if (r.getRoleLevelId() == RoleLevel.ID_BRAND) {// 品牌角色,1个品牌
			int n = 0;
			for (String sid : storeIds.split(",")) {
				Long bId = Long.valueOf(sid);
				if (bId > ScopeVo.BRAND_START_ID
						&& bId < ScopeVo.COMPANY_START_ID) {
					n++;
					if (n > 1) {
						result.setResultInfo(11, "品牌组不能管理多个品牌");
						return SUCCESS;
					}
					companyUser.setBrandId(bId - ScopeVo.BRAND_START_ID);
				}
			}
		}
		if (r.getRoleLevelId() == RoleLevel.ID_SHOP) {// 品牌角色,1个品牌
			int n = 0;
			for (String sid : storeIds.split(",")) {
				Long bId = Long.valueOf(sid);
				if (bId < ScopeVo.BRAND_START_ID && bId > 0) {
					n++;
					if (n > 1) {
						result.setResultInfo(11, "门店角色不能管理多个门店");
						return SUCCESS;
					}
					companyUser.setStoreId(bId);
					Store s = storeManager.getStoreById(bId);
					if (s == null) {
						result.setResultInfo(13, "门店不存在");
						return SUCCESS;
					}
					companyUser.setBrandId(s.getBrandId());
				}
			}
		}

		User u = userManager.getUserByLoginName(companyUser.getMobile());
		if (u != null) {
			if (companyUser.getId() == null
					|| !companyUser.getId().equals(u.getId())) {
				result.setResultInfo(1, "手机号码已经存在");
				return SUCCESS;
			}
		}
		if (companyUser.getEmail() != null
				&& !"".equals(companyUser.getEmail().trim())) {
			u = userManager.getUserByLoginName(companyUser.getEmail());
			if (u != null) {
				if (companyUser.getId() == null
						|| !companyUser.getId().equals(u.getId())) {
					result.setResultInfo(1, "邮箱已经存在");
					return SUCCESS;
				}
			}
		}
		
		 

		companyUser.setRoleLevelId(r.getRoleLevelId());
		companyUser.setUpdateId(user.getId());
		if (companyUser.getId() == null) {

			companyUser.setCompanyId(user.getCompanyId());
			companyUser.setCreateId(user.getId());
			companyUser.setStatus(User.STATUS_FLAG_OK);
			String pass = companyUser.getMobile().substring(5);
			companyUser.setPassword(MD5Util.MD5(pass));
			companyUser.setIsMemberUnlock(User.IS_FLAG_NO);
			userManager.addUser(companyUser);
		} else {

			userManager.updateUser(companyUser);
			UserScope us = new UserScope();
			us.setUserId(companyUser.getId());
			us.setUpdateId(user.getId());
			userScopeManager.removeUserScope(us);// 删除管理的门店
		}

		

			List<UserScope> usList = new ArrayList<UserScope>();
			for (String sid : storeIds.split(",")) { // 设置同样的管理门店
				Long id = Long.valueOf(sid);
				if (id > ScopeVo.BRAND_START_ID) {
					continue;
				}
				
                UserScope us = new UserScope();
				if(id < 0) {//“总部”门店id，格式：-brandId，如-44
	                Brand brand = brandManager.getBrandById(-id);
	                if(brand == null) {
	                    continue;
	                }
	                us.setCompanyId(brand.getCompanyId());
	                us.setBrandId(brand.getId());
	                us.setStoreId(0L);//总部门店id存为0
	            } else {
	                Store s = storeManager.getStoreById(id);
	                if(s==null){
	                    continue;
	                }
	                us.setBrandId(s.getBrandId());
	                us.setCompanyId(s.getCompanyId());
	                us.setStoreId(s.getId());
	            }
				us.setCreateId(user.getId());
				us.setUpdateId(user.getId());
				us.setUserId(companyUser.getId());
				usList.add(us);
			}
			userScopeManager.saveBatch(usList);
		
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getUserList() {
		if (userDto == null) {
			userDto = new UserDto();
		}
		//设置成缓存里面存的商户id
		userDto.setCompanyId(user.getCompanyId());
		//设置成缓存里面存的品牌
		userDto.setBrandIds(user.getBrandIds());
		pageSet(userDto);
		List<User> uList = userManager.getPageList(userDto);
		if (uList != null && uList.size() > 0) {
			List<UserVo> cuvList = new ArrayList<UserVo>();
			for (User u : uList) {
				UserVo uv = new UserVo();
				if (u.getBrandId() != null) {
					Brand b = brandManager.getBrandById(u.getBrandId());
					if (b != null) {
						uv.setBrandName(b.getName());
					}

				}
				if (u.getStoreId() != null) {
					Store s = storeManager.getStoreById(u.getStoreId());
					if (s != null) {
						uv.setStoreName(s.getName());
					}

				}

				uv.setEmail(u.getEmail());
				uv.setId(u.getId());
				uv.setMobile(u.getMobile());
				uv.setRealName(u.getRealName());
				uv.setStatus(u.getStatus());
				uv.setIsAllScopeName(u.getIsAllScopeName());
				uv.setRoleLevelId(u.getRoleLevelId());
				uv.setIsMemberUnlock(u.getIsMemberUnlock());
				Role r = roleManager.getRoleById(u.getRoleId());
				if (r != null) {
					uv.setRoleName(r.getName());
					uv.setRoleLevelName(RoleLevel.getName(r.getRoleLevelId()));
				}
				uv.setStatusName(u.getStatusName());
				if (u.getMobile() != null && u.getMobile().length() == 11) {
					String password = u.getMobile().substring(5);
					if (MD5Util.MD5(password).equals(u.getPassword())) {
						uv.setInitPassword(password);
					}
				}
				cuvList.add(uv);
			}
			pageData.rows = cuvList;
			pageData.setTotal(uList.size());
		}
		Integer total = userManager.getPageTotal(userDto);
		pageData.setTotal(total);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getUserDetail() {

		if (userId == null) {
			result.setParamErrorInfo("userId");
			return SUCCESS;
		}
		detailVo = userManager.getUserById(userId);
		 
		result.setSuccessInfo();
		return SUCCESS;
	}
	
	 
	public User getCompanyUser() {
		return companyUser;
	}

	public void setCompanyUser(User companyUser) {
		this.companyUser = companyUser;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}

	public void setStoreManager(StoreManager storeManager) {
		this.storeManager = storeManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserScopeManager(UserScopeManager userScopeManager) {
		this.userScopeManager = userScopeManager;
	}

	public User getDetailVo() {
		return detailVo;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setStoreIds(String storeIds) {
		this.storeIds = storeIds;
	}

     

    
}
