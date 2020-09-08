package com.itcrazy.alanmall.mscard.action.login;

import lombok.Data;
import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.common.client.util.MD5Util;
import com.itcrazy.alanmall.merchant.dto.BrandDto;
import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.manager.BrandManager;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.user.carddto.UserScopeDto;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.manager.UserScopeManager;
import com.itcrazy.alanmall.user.model.RoleLevel;
import com.itcrazy.alanmall.user.model.User;
import com.itcrazy.alanmall.user.model.UserScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 商家用户登录
 *
 */
@Data
public class WebLoginAction extends InterfaceBaseAction {

	private static final long serialVersionUID = -4615135092329537016L;

	private String username;
	private String password;
	private String authcode;// 验证码

	private Long detailVo;
	@Reference
	private UserManager userManager;
	@Reference
	private UserScopeManager userScopeManager;
	@Reference
	private StoreManager storeManager;
	@Reference
	private BrandManager brandManager;
	private Boolean inValid() {

		if (username == null || "".equals(username.trim())) {
			result.setParamErrorInfo("username");
			return true;
		}
		if (password == null || "".equals(password.trim())) {
			result.setParamErrorInfo("password");
			return true;
		}
		if (authcode == null || "".equals(authcode.trim())) {
			result.setParamErrorInfo("authcode");
			return true;
		}
		return false;
	}

	public String webLogin() {

		if (inValid()) {
			return SUCCESS;
		}

		String sessionCode = SessionData.getAuthCode(getRequest(),
				getResponse());

		if (sessionCode == null) {
			result.setCode(1102);
			return SUCCESS;
		}
		if (!sessionCode.toLowerCase().equals(authcode.toLowerCase())) {
			result.setCode(1103);
			return SUCCESS;
		}

		User user = userManager.getUserByLoginName(username);

		if (user == null) {
			result.setCode(1104);
			return SUCCESS;
		}



		if (user.getStatus() != User.STATUS_FLAG_OK) {
			result.setCode(1105);
			return SUCCESS;
		}
		if (!user.getPassword().equals(MD5Util.MD5(password))) {
			result.setCode(1107);
			return SUCCESS;
		}
	    if(user.getIsAllScope()==User.IS_FLAG_YES){//管理全部范围
			if(user.getRoleLevelId()==RoleLevel.ID_OFFICE){//5i运营管理员
				user.setCompanyId(null);
				user.setBrandId(null);
				user.setStoreId(null);
				user.setStoreIds(null);
//				user.setStoreIdsWithoutHQ(null);
				user.setIncludeHQ(true);
				SessionData.setUser(getRequest(), getResponse(), user);
			}

			if(user.getRoleLevelId()==RoleLevel.ID_COMPANY){//商家管理员
				BrandDto bdto=new BrandDto();
				bdto.setCompanyId(user.getCompanyId());
				List<Brand> bList=brandManager.getPageList(bdto);
				if(bList==null || bList.size()<1){
					result.setResultInfo(1001, "品牌不存在");
					return SUCCESS;
				}
				if(bList.size()==1){
					Brand b=bList.get(0);
					user.setBrandId(b.getId());
					user.setBrandIds(b.getId()+"");
				}
				if(bList.size()>1){
					user.setBrandId(null);
					StringBuilder sb=new StringBuilder("0");
					for(Brand b:bList){
						sb.append(","+b.getId());
					}
					user.setBrandIds(sb.toString());
				}
				StoreDto sdto=new StoreDto();
				sdto.setCompanyId(user.getCompanyId());
				sdto.setLimit(Integer.MAX_VALUE);
				List<Store> sList=storeManager.getPageList(sdto);
				if(sList==null ||  sList.size()<1){
					result.setResultInfo(1001, "门店不存在");
					return SUCCESS;
				}
				if(sList.size()==1){
					user.setStoreIds(sList.get(0).getId()+"");
//					user.setStoreIdsWithoutHQ(sList.get(0).getId()+"");
					user.setStoreId(sList.get(0).getId());
				}else{
					StringBuilder sbStore=new StringBuilder("0");
					for(Store s:sList){
						sbStore.append(","+s.getId());
					}
					user.setStoreIds(sbStore.toString());
//					user.setStoreIdsWithoutHQ(sbStore.toString().substring(2));
					user.setStoreId(null);
				}

				user.setIncludeHQ(true);

			}
			if(user.getRoleLevelId()==RoleLevel.ID_BRAND){//管理品牌下面所有门店
				user.setBrandIds(user.getBrandId()+"");
				StoreDto sdto=new StoreDto();
				sdto.setCompanyId(user.getCompanyId());
				sdto.setLimit(Integer.MAX_VALUE);
				List<Store> sList=storeManager.getPageList(sdto);
				if(sList==null ||  sList.size()<1){
					result.setResultInfo(1001, "门店不存在");
					return SUCCESS;
				}
				if(sList.size()==1){

					user.setStoreId(sList.get(0).getId());
					user.setStoreIds(sList.get(0).getId()+"");
//					user.setStoreIdsWithoutHQ(sList.get(0).getId()+"");
				}else{
					StringBuilder sbStore=new StringBuilder("0");
					for(Store s:sList){
						sbStore.append(","+s.getId());
					}
					user.setStoreId(null);
					user.setStoreIds(sbStore.toString());
//					user.setStoreIdsWithoutHQ(sbStore.toString().substring(2));
				}

				user.setIncludeHQ(true);
			}
			if(user.getRoleLevelId()==RoleLevel.ID_SHOP){
				user.setBrandIds(user.getBrandId()+"");
				user.setStoreIds(user.getStoreId()+"");
//				user.setStoreIdsWithoutHQ(user.getStoreId()+"");

				user.setIncludeHQ(false);
			}

			SessionData.setUser(getRequest(), getResponse(), user);
			result.setSuccessInfo();
			return SUCCESS;
		}
		//管理部分门店,从user_scope中获取
	    user.setCompanyId(null);
		user.setBrandId(null);
		user.setStoreId(null);
		UserScopeDto usdto=new UserScopeDto();
		usdto.setUserId(user.getId());
		List<UserScope> usList=userScopeManager.getPageList(usdto);
		if(usList==null || usList.size()==0){
			result.setCode(1106);
			return SUCCESS;
		}

		List<Long> cIdList=new ArrayList<Long>();
		List<Long> bIdList=new ArrayList<Long>();
		List<Long> sIdList=new ArrayList<Long>();
		for(UserScope us:usList){
			if(!cIdList.contains(us.getCompanyId())){
				cIdList.add(us.getCompanyId());
			}
			if(!bIdList.contains(us.getBrandId())){
				bIdList.add(us.getBrandId());
			}
			if(!sIdList.contains(us.getStoreId())){
				sIdList.add(us.getStoreId());
			}
		}
		if(cIdList.size()==1){//用户管理一个商家
			Long cId=cIdList.get(0);
			detailVo=cId;
			user.setCompanyId(cId);
			if(bIdList.size()==1){//只管理一个品牌
				Long bId=bIdList.get(0);
				user.setBrandId(bId);
			}else{
				String bIds=null;
				for(Long bId:bIdList){
					if(bIds==null){
						bIds=String.valueOf(bId);
					}else{
						bIds=bIds+","+String.valueOf(bId);
					}
				}
				user.setBrandId(null);
				user.setBrandIds(bIds);
			}
			String sIds=null;
			for(Long sId:sIdList){
				if(sIds==null ){
					//sIds="0,"+sId;//“总部”门店在office里分配
				    sIds = String.valueOf(sId);
				}else{
					sIds+=","+sId;
				}
			}

			user.setStoreIds(sIds);
//			if(sIds != null && sIds.contains(",")){
//				user.setStoreIdsWithoutHQ(sIds.substring(2));
//			} else {
//				user.setStoreIdsWithoutHQ("");
//			}

			if(!sIds.contains(",")){//管理多个门店
				user.setStoreId(sIdList.get(0));
			}
		}else{ //管理多个商家
			user.setCompanyId(null);
			user.setBrandId(null);
			user.setStoreIds(null);
//			user.setStoreIdsWithoutHQ(null);
		}

//		user.setCompanyId(28L);
//		user.setBrandId(24L);
//		user.setStoreId(1L);
//		user.setStoreIds("0,81,82");
//
//		user.setCompanyId(39L);
//		user.setBrandId(44L);
//		user.setBrandIds("44");
//		user.setStoreId(null);
//		user.setStoreIds("0,4292322,3842321,3722321,3001527,3001480,3000859,3000858,3000799,3000509,3000368,173,172,111,110,109");

		SessionData.setUser(getRequest(), getResponse(), user);

		result.setSuccessInfo();
		return SUCCESS;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setUserScopeManager(UserScopeManager userScopeManager) {
		this.userScopeManager = userScopeManager;
	}

	public Long getDetailVo() {
		return detailVo;
	}

	public void setStoreManager(StoreManager storeManager) {
		this.storeManager = storeManager;
	}

	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}


}
