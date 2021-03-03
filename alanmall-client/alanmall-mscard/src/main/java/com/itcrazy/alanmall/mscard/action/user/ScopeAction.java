package com.itcrazy.alanmall.mscard.action.user;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.mscard.vo.user.ScopeVo;
import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.manager.*;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Company;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.user.carddto.UserScopeDto;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.manager.UserScopeManager;
import com.itcrazy.alanmall.user.model.RoleLevel;
import com.itcrazy.alanmall.user.model.User;
import com.itcrazy.alanmall.user.model.UserScope;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 运营人员登录后选择操作
 * 
 * @author DDD
 * 
 */
public class ScopeAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -8321850391218267365L;

	private String name;
	private String storeIds;
	@Reference
	private UserScopeManager userScopeManager;
	private CompanyManager companyManager;
	private BrandManager brandManager;
	private StoreManager storeManager;
	@Reference
	private UserManager userManager;
	private CityManager cityManager;
	private ProvinceManager provinceManager;
	
	public String getScopeList() {
		if (name == null) {
			result.setParamErrorInfo("name");
			return SUCCESS;
		}
		User dataU=userManager.getUserById(user.getId());
		
		boolean includeHQ = false;//是否包括“总部”
		StoreDto dto = new StoreDto();
		if(dataU.getIsAllScope()==User.IS_FLAG_YES){//全部
			if(user.getRoleLevelId()==RoleLevel.ID_COMPANY){
				dto.setCompanyId(user.getCompanyId());
			}
			if(user.getRoleLevelId()==RoleLevel.ID_BRAND){
				dto.setBrandId(user.getBrandId());
			}
			if(user.getRoleLevelId()==RoleLevel.ID_SHOP){
				dto.setStoreIds(user.getStoreId()+"");
			}
		}else{
			UserScopeDto usdto = new UserScopeDto();
			usdto.setUserId(user.getId());
			List<UserScope> usList = userScopeManager.getPageList(usdto);
//			String sids = "0,";
			String sids = "";

			for (UserScope us : usList) {
			    if(us.getStoreId() == 0) {
			        includeHQ = true;
			    }
				sids += us.getStoreId() + ",";
			}
			//sids += "0";
			
			if(sids.endsWith(",")) {
			    sids = sids.substring(0, sids.length()-1);
			}
			
			dto.setStoreIds(sids);
		}
		
		dto.setName(name);
		
		List<Store> stList = storeManager.getAdminStoreList(dto); //
		if (stList == null || stList.size() == 0) {
			result.setResultInfo(1, "名称不存在");
			return SUCCESS;
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
				brandIdList.add(brandId);
				
				//添加虚拟“总部”门店
				if(dataU.getIsAllScope()==User.IS_FLAG_YES || includeHQ){//全部权限或包括“总部”门店
	                ScopeVo sc = new ScopeVo();
	                sc.setId(-s.getBrandId());//格式：-brandId，如-44
	                //sc.setId(0L);
	                sc.setName("总部");
	                bSV.getSubs().add(sc);
				}
			}

			ScopeVo sc = new ScopeVo();
			sc.setId(s.getId());
			sc.setName(s.getName());
			bSV.getSubs().add(sc);
		} 
		pageData.rows = svList;
		result.setSuccessInfo();
		return SUCCESS;
	}
	
	public String updateScope() {
		if (storeIds == null) {
			result.setParamErrorInfo("storeIds");
			return SUCCESS;
		}

		StoreDto dto = new StoreDto();
		dto.setStoreIds(storeIds.toLowerCase());
		dto.setLimit(Integer.MAX_VALUE);
		List<Store> stList = storeManager.getPageList(dto);

		if (stList == null || stList.size() == 0) {
			result.setResultInfo(1, "门店列表为空");
			return SUCCESS;
		}
		Long companyId = null;
		Long brandId = null;
		String brandIds = "0,";

		for (Store s : stList) {
			 
			if (companyId == null) {
				companyId = s.getCompanyId();
			}
			if (!companyId.equals(s.getCompanyId())) {
				companyId = 0L;
			}
			if (!brandIds.contains("," + s.getBrandId() + ",")) {
				brandIds += s.getBrandId() + ",";
			}
		}
		brandIds += "0";
		brandIds = brandIds.replaceAll("0,", "").replaceAll(",0", "");
		if (brandIds.contains(",")) {
			brandId = null;
		} else {
			brandId = Long.valueOf(brandIds);
		}

		if (companyId == 0) {
			result.setResultInfo(1, "只能选择一个商家");
			return SUCCESS;
		}

		user.setCompanyId(companyId);
		user.setBrandId(brandId);
		user.setBrandIds(brandIds);
		if(storeIds.contains("-")) {//“总部”在页面上选择，格式为：-brandId，如-44
		    user.setStoreIds("0,"+storeIds);
		    user.setIncludeHQ(true);
		}else{
		    user.setStoreIds(storeIds);
		    user.setIncludeHQ(false);
		}
//	    user.setStoreIdsWithoutHQ(storeIds);
		if(storeIds.contains(",")){
			user.setStoreId(null);
		}else{
			user.setStoreId(Long.valueOf(storeIds));
		}
		User dataU=userManager.getUserById(user.getId());
		if(dataU.getIsAllScope()==User.IS_FLAG_YES){//管理全部门店品牌
			StoreDto sDto=new StoreDto();
			sDto.setLimit(Integer.MAX_VALUE);
			if(user.getRoleLevelId()==RoleLevel.ID_BRAND){
				sDto.setBrandId(user.getBrandId());
			}
			if(user.getRoleLevelId()==RoleLevel.ID_COMPANY || user.getRoleLevelId()==RoleLevel.ID_OFFICE){
				sDto.setCompanyId(user.getCompanyId());
			}
			sDto.setStatus(Store.STATUS_FLAG_OK);
			List<Store> scopList=storeManager.getPageList(sDto);
			if(scopList.size()!=stList.size()){
				user.setIsAllScope(UserScope.IS_FLAG_NO);
			}else{
				user.setIsAllScope(UserScope.IS_FLAG_YES);
			}
		}
		SessionData.setUser(getRequest(), getResponse(), user);
		 
		result.setSuccessInfo();
		return SUCCESS;
	}
	
	/**
     * 获取营销活动中所需要的门店信息(按城市分组)
     * @return
     */
    public String getScopeList4Prom() {
        if (user == null) {
            result.setParamErrorInfo("user");
            return SUCCESS;
        }
        if (user.getStoreIds() == null || "".equals(user.getStoreIds().trim())) {
            result.setParamErrorInfo("user.storeIds");
            return SUCCESS;
        }
        StoreDto dto = new StoreDto();
        dto.setStoreIds(user.getStoreIds());
        dto.setStatus(0);//已开通
        List<Store> stList = storeManager.getAdminStoreList(dto); 
        if (stList == null || stList.size() == 0) {
            result.setResultInfo(1, "门店不存在");
            return SUCCESS;
        }

        List<Long> companyIdList = new ArrayList<Long>();
        List<Long> brandIdList = new ArrayList<Long>();
        List<String> cityList = new ArrayList<String>();

        List<ScopeVo> svList = new ArrayList<ScopeVo>();
        ScopeVo cSV = null;
        ScopeVo bSV = null;
        ScopeVo citySV = null;
        long provinceStartId = 1000000;
        long cityStartId = 100000;
        for (Store s : stList) {
            Long companyId = s.getCompanyId() + ScopeVo.COMPANY_START_ID;
            Long brandId = s.getBrandId() + ScopeVo.BRAND_START_ID;

            if (!companyIdList.contains(companyId)) {
                Company c = companyManager.getCompanyById(s.getCompanyId());
                cSV = new ScopeVo();
                cSV.setId(companyId);
                cSV.setName(c.getName());
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
                brandIdList.add(brandId);
            }
            
            //门店
            ScopeVo sc = new ScopeVo();
            sc.setId(s.getId());
            sc.setName(s.getName());
            
            if (s.getCityId() != null && s.getCityId() > 0) {
                String cityIdKey = brandId.toString() + cityStartId + s.getCityId();
                if(s.getProvinceId() != null && s.getProvinceId() > 0) {
                    if(s.getProvinceId() == 1 || s.getProvinceId() == 2 || s.getProvinceId() == 3) {//直辖市：上海、北京、天津的city为区名称 
                        cityIdKey = brandId.toString() + provinceStartId + s.getProvinceId();
                    }
                }
                
                if(!cityList.contains(cityIdKey)) {
                    String cityName = "";
                    if(s.getProvinceId() != null && s.getProvinceId() > 0) {
                        if(s.getProvinceId() == 1 || s.getProvinceId() == 2 || s.getProvinceId() == 3) {//直辖市：上海、北京、天津的city为区名称 
                            //cityName = "上海市";
                            cityName = provinceManager.getProvinceName(s.getProvinceId());
                        } else {
                            cityName = cityManager.getCityName(s.getCityId());
                        }
                    }

                    if(StringUtils.isBlank(cityName)) {
                        continue;
                    }
                    
                    //城市分组
                    citySV = new ScopeVo();
                    citySV.setId(Long.valueOf(cityIdKey));
                    citySV.setName(cityName);
                    bSV.getSubs().add(citySV);
                    
                    cityList.add(cityIdKey);
                }
                
                //门店分组于城市下
                citySV.getSubs().add(sc);
            } else { //门店没有归属城市
                //分组于品牌下
                bSV.getSubs().add(sc);
            }
        }
        
        pageData.rows = svList;
        result.setSuccessInfo();
        return SUCCESS;
    }

	/**
	 * 获取营销活动中所需要的门店信息
	 * @return
	 */
	/*public String getScopeList4Prom() {
		if (user == null) {
			result.setParamErrorInfo("user");
			return SUCCESS;
		}
		if (user.getStoreIds() == null || "".equals(user.getStoreIds().trim())) {
			result.setParamErrorInfo("user.storeIds");
			return SUCCESS;
		}
		StoreDto dto = new StoreDto();
		dto.setStoreIds(user.getStoreIds());
		dto.setStatus(0);//已开通
		List<Store> stList = storeManager.getAdminStoreList(dto); 
		if (stList == null || stList.size() == 0) {
			result.setResultInfo(1, "门店不存在");
			return SUCCESS;
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
				brandIdList.add(brandId);
			}

			ScopeVo sc = new ScopeVo();
			sc.setId(s.getId());
			sc.setName(s.getName());
			bSV.getSubs().add(sc);
		}
		pageData.rows = svList;
		result.setSuccessInfo();
		return SUCCESS;
	}*/

	public void setUserScopeManager(UserScopeManager userScopeManager) {
		this.userScopeManager = userScopeManager;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBrandManager(BrandManager brandManager) {
		this.brandManager = brandManager;
	}

	public void setStoreManager(StoreManager storeManager) {
		this.storeManager = storeManager;
	}

	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}

	public void setStoreIds(String storeIds) {
		this.storeIds = storeIds;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

    /**
     * @param cityManager the cityManager to set
     */
    public void setCityManager(CityManager cityManager) {
        this.cityManager = cityManager;
    }

    /**
     * @param provinceManager the provinceManager to set
     */
    public void setProvinceManager(ProvinceManager provinceManager) {
        this.provinceManager = provinceManager;
    }

}
