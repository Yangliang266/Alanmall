package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.mscard.vo.user.ScopeVo;
import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.manager.BrandManager;
import com.itcrazy.alanmall.merchant.manager.CompanyManager;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Company;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.user.manager.UserScopeManager;
import com.itcrazy.alanmall.user.model.User;
import com.itcrazy.alanmall.user.model.UserScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 帐号管理,管理用户操作门店
 * @author DDD
 *
 */
public class UserScopeAction extends InterfaceBaseAction{


	private static final long serialVersionUID = -8321850391218267365L;

	private String flag;

	private Long userId;
	private CompanyManager companyManager;
	private BrandManager brandManager;
	private StoreManager storeManager;
	@Reference
	private UserScopeManager userScopeManager;
	
	public String getUserScopeList(){
		
		
		StoreDto dto = new StoreDto();
		dto.setCompanyId(user.getCompanyId());//编辑帐号时候,只选择当前操作的门店
		if(flag != null && flag.equalsIgnoreCase("ok")) {
		    dto.setStatus(Store.STATUS_FLAG_OK);
		}
		List<Store> stList = storeManager.getAdminStoreList(dto); //
		if (stList == null || stList.size() == 0) {
			result.setResultInfo(1, "门店不存在");
			return SUCCESS;
		}
		Map<String,UserScope> usMap=null;
		
		if(userId!=null){
			usMap=userScopeManager.storeIdMap(userId);;
		}
		
		User currentUser = SessionData.getUser(getRequest(), getResponse());
		boolean includeHQ = false;//是否包括“总部”
		if(currentUser.getIsAllScope() == User.IS_FLAG_YES || 
		        (currentUser.getStoreIds() != null && currentUser.getStoreIds().startsWith("0,"))) {
		    includeHQ = true;
		}
		
		List<Long> companyIdList = new ArrayList<Long>();
		List<Long> brandIdList = new ArrayList<Long>();

		List<ScopeVo> svList = new ArrayList<ScopeVo>();
		ScopeVo cSV = null;
		ScopeVo bSV = null;
		for (Store s : stList) {
			Long companyId = s.getCompanyId() + ScopeVo.COMPANY_START_ID;
			Long brandId = s.getBrandId() + ScopeVo.BRAND_START_ID;

			if (!companyIdList.contains(companyId)) {
				Company c = companyManager.getCompanyById(s.getCompanyId());
				cSV = new ScopeVo();
				cSV.setId(companyId);
				cSV.setName(c.getName());
				cSV.setIsChecked(UserScope.IS_FLAG_YES);
				svList.add(cSV);
				companyIdList.add(companyId);
			}
			if (!brandIdList.contains(brandId)) {
				Brand b = brandManager.getBrandById(s.getBrandId());
				if (b == null) {
					continue;
				}
				bSV = new ScopeVo();
				bSV.setId(brandId);
				bSV.setName(b.getName());
				cSV.getSubs().add(bSV);
				bSV.setIsChecked(UserScope.IS_FLAG_YES);
				brandIdList.add(brandId);
				
				//添加虚拟“总部”门店
				if(includeHQ) {
	                ScopeVo sc = new ScopeVo();
	                sc.setId(-s.getBrandId());//格式：-brandId，如-44
	                sc.setName("总部");
	                if (usMap != null && usMap.get(s.getBrandId() + "_0") != null) {//总部在db里存为0
	                    sc.setIsChecked(UserScope.IS_FLAG_YES);
	                } else {
	                    sc.setIsChecked(UserScope.IS_FLAG_NO);
	                    bSV.setIsChecked(UserScope.IS_FLAG_NO);
	                    cSV.setIsChecked(UserScope.IS_FLAG_NO);
	                }
	                
	                bSV.getSubs().add(sc);
				}
			}

			ScopeVo sc = new ScopeVo();
			sc.setId(s.getId());
			sc.setName(s.getName());
			if(usMap!=null && usMap.get(s.getBrandId() + "_" + s.getId())!=null){
				sc.setIsChecked(UserScope.IS_FLAG_YES);
			}else{
				sc.setIsChecked(UserScope.IS_FLAG_NO);
				bSV.setIsChecked(UserScope.IS_FLAG_NO);
				cSV.setIsChecked(UserScope.IS_FLAG_NO);
			}
			bSV.getSubs().add(sc);
		}
		pageData.rows = svList;
		result.setSuccessInfo();
		return SUCCESS;
	}
	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}
	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}
	public void setStoreManager(StoreManager storeManager) {
		this.storeManager = storeManager;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setUserScopeManager(UserScopeManager userScopeManager) {
		this.userScopeManager = userScopeManager;
	}
    public void setFlag(String flag) {
        this.flag = flag;
    }
	
	
}
