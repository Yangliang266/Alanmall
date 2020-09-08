package com.itcrazy.alanmall.mscard.action.common;

import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.common.vo.PageData;
import com.itcrazy.alanmall.common.vo.Result;
import com.itcrazy.alanmall.merchant.manager.*;
import com.itcrazy.alanmall.merchant.model.*;

import java.util.List;

/**
 * 获取地区接口
 * 
 * @author DDD
 * 
 */
public class AreaAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 8660013845386518513L;

	private Long cityId;
	private Long provinceId;

	private Result result = new Result();
	private PageData pageData = new PageData();

	private LandMarkManager landMarkManager;
	private CityManager cityManager;
	private ProvinceManager provinceManager;
	private CountyManager countyManager;
	private BusinessCircleManager businessCircleManager;

	public String getProvinceList() {
		List<Province> pList = provinceManager.getAllProvinceList();
		pageData.rows = pList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getLandMarkList() {
		if (cityId == null) {
			result.setParamErrorInfo("cityId");
			return SUCCESS;
		}
		List<LandMark> lmList = landMarkManager.getLandMarkListByCityId(cityId);
		pageData.rows = lmList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getCityList() {
		if (provinceId == null) {
			result.setParamErrorInfo("provinceId");
			return SUCCESS;
		}
		List<City> cityList = cityManager.getCityListById(provinceId);
		pageData.rows = cityList;
		result.setSuccessInfo();

		return SUCCESS;
	}

	public String getCountyList() {
		if (cityId == null) {
			result.setParamErrorInfo("cityId");
			return SUCCESS;
		}
		List<County> cList = countyManager.getCountyListById(cityId);
		pageData.rows = cList;
		result.setSuccessInfo();

		return SUCCESS;
	}

	public String getBusinessCircleList() {
		if (cityId == null) {
			result.setParamErrorInfo("cityId");
			return SUCCESS;
		}
		List<BusinessCircle> bcList = businessCircleManager
				.getBusinessCircleListByCityId(cityId);
		pageData.rows = bcList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public void setLandMarkManager(LandMarkManager landMarkManager) {
		this.landMarkManager = landMarkManager;
	}

	public Result getResult() {
		return result;
	}

	public PageData getPageData() {
		return pageData;
	}

	public void setCityManager(CityManager cityManager) {
		this.cityManager = cityManager;
	}

	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}

	public void setCountyManager(CountyManager countyManager) {
		this.countyManager = countyManager;
	}

	public void setBusinessCircleManager(
			BusinessCircleManager businessCircleManager) {
		this.businessCircleManager = businessCircleManager;
	}

}
