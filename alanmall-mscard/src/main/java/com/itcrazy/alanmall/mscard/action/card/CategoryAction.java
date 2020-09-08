package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CategoryDto;
import com.itcrazy.alanmall.mscard.manager.CategoryManager;
import com.itcrazy.alanmall.mscard.manager.ParameterManager;
import com.itcrazy.alanmall.mscard.model.Category;
import com.itcrazy.alanmall.mscard.model.Discount;
import com.itcrazy.alanmall.mscard.model.Parameter;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.merchant.manager.BrandManager;
import com.itcrazy.alanmall.merchant.manager.CityManager;
import com.itcrazy.alanmall.merchant.manager.ProvinceManager;
import com.itcrazy.alanmall.merchant.manager.StoreManager;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.mscard.vo.card.CategoryVo;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 卡类别设置
 * @author chenfei
 * 2018-09-03
 */
public class CategoryAction extends InterfaceBaseAction{

	private static final long serialVersionUID = 7431677120439673622L;

	private Long categoryId;
	private Category category;
	private CategoryVo detailVo;
	private CategoryDto categoryDto;
	private List<String> cityList;
	private List<String> brandStoreList;
	private List<String> discountList;

	@Reference
	CategoryManager categoryManager;
	@Reference
	BrandManager brandManager;
	@Reference
	CityManager cityManager;
	@Reference
	StoreManager storeManager;
	@Reference
	ProvinceManager provinceManager;
	@Reference
	ParameterManager parameterManager;

	/**
	 * 获取卡类别列表
	 * @return
	 */
	public String getCategoryList(){

		if(categoryDto == null){
			categoryDto = new CategoryDto();
		}

		pageSet(categoryDto);
		categoryDto.setCompanyId(user.getCompanyId());
		List<Category> categoryList = categoryManager.getPageList(categoryDto);
		List<CategoryVo> categoryVoList = new ArrayList<CategoryVo>();

		if(categoryList != null && categoryList.size()>0){

			for(Category c : categoryList){
				CategoryVo cv = new CategoryVo();

				cv.setId(c.getId());
				cv.setName(c.getName());
				cv.setBin(c.getBin() != null ? c.getBin() : "");
				cv.setIsNamed(KeyValueConvert.getCardYesNoValue(c.getIsNamed()));
				cv.setRechargeQuota(c.getRechargeQuota() != null ? c.getRechargeQuota().setScale(0).toString() : "");
				cv.setIsPwdMust(KeyValueConvert.getCardYesNoValue(c.getIsPwdMust()));
				cv.setIsRecharge(KeyValueConvert.getCardYesNoValue(c.getIsRecharge()));
				cv.setRechargeCount(c.getRechargeCount());
				cv.setIsCredit(KeyValueConvert.getCardYesNoValue(c.getIsCredit()));

				// 折扣需联合查询
				cv.setDiscount("/");
				String strDiscounts = "";
				NumberFormat percent = NumberFormat.getPercentInstance();
				List<Discount> categoryDiscountList = c.getDiscountList();
				for(Discount discount : categoryDiscountList) {
					if(discount.getType() == CardConstants.CARD_DISCOUNT_TYPE_BRAND) {
						Brand brandById = brandManager.getBrandById(Long.valueOf(discount.getCode()));
						if(brandById != null) {
							strDiscounts +=  "," + brandById.getName();
							percent.setMaximumFractionDigits(2);
							strDiscounts += percent.format(discount.getDiscount());
						}
					}
				}
				cv.setDiscount(StringUtils.isBlank(strDiscounts) ? "/" : strDiscounts.substring(1));

				// 可消费品牌
				String[] aBrands = StringUtils.isBlank(c.getBrands()) ? new String[] {}  : c.getBrands().split(",");
				String strBrands = "";
				for(String brandId : aBrands) {
					if(StringUtils.isBlank(brandId)) {
						continue;
					}
					Brand brandById = brandManager.getBrandById(Long.valueOf(brandId));
					if(brandById != null) {
						strBrands +=  "," + brandById.getName();
					}
				}
				cv.setBrands(StringUtils.isBlank(strBrands) ? "/" : strBrands.substring(1));

				// 可消费门店
				String[] aStores = StringUtils.isBlank(c.getStores()) ? new String[] {}  : c.getStores().split(",");
				String strStores = "";
				for(String storeId : aStores) {
					if(StringUtils.isBlank(storeId)) {
						continue;
					}
					Store storeById = storeManager.getStoreById(Long.valueOf(storeId));
					if(storeById != null) {
						strStores +=  "," + storeById.getName();
					}
				}
				cv.setStores(StringUtils.isBlank(strStores) ? "/" : strStores.substring(1));

				// 可消费城市
				String[] aCitys = StringUtils.isBlank(c.getCities()) ? new String[] {} : c.getCities().split(",");
				String strCitys = "";
				for(String cityId : aCitys) {
					if(StringUtils.isBlank(cityId)) {
						continue;
					}else if(cityId.trim().startsWith("p")) {
						strCitys += "," + provinceManager.getProvinceName(Long.valueOf(cityId.trim().substring(1)));
					}else if(cityId.trim().startsWith("c")) {
						strCitys += "," + cityManager.getCityName(Long.valueOf(cityId.trim().substring(1)));
					}else {
						continue;
					}
				}
				cv.setCities(StringUtils.isBlank(strCitys) ? "/" : strCitys.substring(1));

				cv.setStatus(KeyValueConvert.getStatusValue(c.getStatus()));
				cv.setRemarks(c.getRemarks());

				categoryVoList.add(cv);
			}
		}

		pageData.rows = categoryVoList;

		Integer t = categoryManager.getPageTotal(categoryDto);
		pageData.setTotal(t);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取单个卡类别详细
	 * @return
	 */
	public String getCategoryDetail(){
		if(categoryId == null){
			result.setParamErrorInfo("categoryId");
			return SUCCESS;
		}

		Category c = categoryManager.getCategoryById(categoryId,user.getCompanyId());

		if (c == null) {
			result.setNotFind("此卡类别不存在");
			return SUCCESS;
		}

		CategoryVo cv = new CategoryVo();
		cv.setId(c.getId());
		cv.setName(c.getName());
		cv.setBin(c.getBin() != null ? c.getBin() : "");
		cv.setIsNamed(KeyValueConvert.getCardYesNoValue(c.getIsNamed()));
		cv.setRechargeQuota(c.getRechargeQuota() != null ? c.getRechargeQuota().setScale(0).toString() : "");
		cv.setIsPwdMust(KeyValueConvert.getCardYesNoValue(c.getIsPwdMust()));
		cv.setIsRecharge(KeyValueConvert.getCardYesNoValue(c.getIsRecharge()));
		cv.setRechargeCount(c.getRechargeCount());
		cv.setDiscount(multiplyOneHundred(c.getDiscount()).toString());
		cv.setIsCredit(KeyValueConvert.getCardYesNoValue(c.getIsCredit()));

		cv.setBrands(c.getBrands());
		cv.setCities(c.getCities());
		cv.setStores(c.getStores());
		cv.setAllJoinBrands(c.getAllJoinBrands());

		if (c.getDiscountList()!=null && !c.getDiscountList().isEmpty()) {
			for(Discount discount : c.getDiscountList()) {
				if (discount.getType() == CardConstants.CARD_DISCOUNT_TYPE_BRAND) {
					discount.setCode("b" + discount.getCode());
				}
				// 小数转整数
				discount.setDiscount(multiplyOneHundred(discount.getDiscount()));
			}
		}
		cv.setDiscountList(c.getDiscountList());
		cv.setRemarks(c.getRemarks());
		setDetailVo(cv);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 新增修改卡类别
	 * @return
	 */
	public String updateCategory(){

		if(category == null){
			result.setResultInfo(-1, "参数对象丢失，操作失败。");
			return SUCCESS;
		}

		// 修改卡状态
		if(category.getOperateType() == Category.OPERATE_TYPE_UPDATE_STATUS) {
			updateStatus();
		}else if(category.getOperateType() == Category.OPERATE_TYPE_ADD
				|| category.getOperateType() == Category.OPERATE_TYPE_EDIT){
		// 新增/编辑
			addOrUpdateCategory();
		}else if(category.getOperateType() == Category.OPERATE_TYPE_DELETE){
		// 删除
			deleteCategory();
		}else {
			result.setParamErrorInfo("operateType");
			return SUCCESS;
		}
		return SUCCESS;
	}

	/**
	 * 修改卡类别状态
	 */
	private void updateStatus() {
		if(category.getId() == null) {
			result.setParamErrorInfo("id");
			return;
		}
		category.setUpdateId(user.getId());

		try {
			categoryManager.updateCategoryStatus(category);
			result.setResultInfo(0,"卡类别状态更新成功。");
		} catch (Exception e) {
			result.setResultInfo(-1, "出现异常，操作失败。");
		}
	}

	/**
	 * 新增编辑卡类别
	 */
	private void addOrUpdateCategory() {
		if(StringUtils.isBlank(category.getName())){
			result.setParamErrorInfo("name");
			return;
		}
		if (StringUtils.isNotBlank(category.getBin())) {
			category.setBin(category.getBin().trim());
			if (StringUtils.isNotEmpty(category.getBin())) {
				CardBaseDto baseDto = new CardBaseDto();
				baseDto.setIsDeleted(0);
				baseDto.setCompanyId(user.getCompanyId());
				Parameter paramDetail = parameterManager.getParamDetail(baseDto);
				// 如果bin长度大于数据库中卡号自增的长度
				if (paramDetail == null || paramDetail.getLength() < category.getBin().length()
						|| !StringUtils.isNumeric(category.getBin())) {
					result.setParamErrorInfo("BIN");
					return;
				}
			}
		}

		if(category.getIsNamed() != CardConstants.KEY_YES && category.getIsNamed() !=  CardConstants.KEY_NO){
			result.setParamErrorInfo("isNamed");
			return;
		}
		if(category.getIsPwdMust() != CardConstants.KEY_YES && category.getIsPwdMust() != CardConstants.KEY_NO){
			result.setParamErrorInfo("isPwdMust");
			return;
		}
		if(category.getIsRecharge() != CardConstants.KEY_YES && category.getIsRecharge() != CardConstants.KEY_NO){
			result.setParamErrorInfo("isRecharge");
			return;
		}
		if (category.getIsRecharge() == CardConstants.KEY_NO) {
			category.setRechargeCount(null);
		}
		if(category.getIsCredit() != CardConstants.KEY_YES && category.getIsCredit() != CardConstants.KEY_NO){
			result.setParamErrorInfo("isCredit");
			return;
		}
		if(category.getDiscount() != null ) {
			// 整数转小时 60 -> 0.60
			category.setDiscount(divideOneHundred(category.getDiscount()));
			if(!isDiscount(category.getDiscount())){
				result.setParamErrorInfo("discount");
				return;
			}
		}else {
			category.setDiscount(BigDecimal.ONE);
		}

		// 获得可消费品牌 / 门店
		if(brandStoreList != null) {
			StringBuffer allJoinBrands = new StringBuffer();
			StringBuffer stores = new StringBuffer();
			for(int i=0; i<brandStoreList.size(); i++ ) {
				String s = brandStoreList.get(i);
				// 品牌id以'b'开头, 此种情况下为全品牌参与
				if(isNum(s+"")) {
					stores.append(s);
					stores.append(",");
				} else {
					allJoinBrands.append(s.substring(1, s.length()));
					allJoinBrands.append(",");
				}
			}
			category.setAllJoinBrands(allJoinBrands.toString());
			category.setStores(stores.toString());
		}
		if(cityList != null && brandStoreList != null) {
			// 获得可消费城市
			category.setCities(String.join(",", cityList));
		}

		List<Discount> discountModelList = new ArrayList<>();
		if(discountList != null) {
			StringBuffer brands = new StringBuffer();
			for(String d : discountList) {
				String[] strArr = d.split(":");
				String strId = strArr[0];
				String discount = strArr[1];
				Discount discountModel = new Discount();
				// 品牌id以'b'开头，
				if(isNum(strId)) {
					// 折扣类型 0: 品牌、 1: 门店
					discountModel.setType(CardConstants.CARD_DISCOUNT_TYPE_STORE);
					discountModel.setCode(strId);
				} else {
					discountModel.setType(CardConstants.CARD_DISCOUNT_TYPE_BRAND);
					discountModel.setCode(strId.substring(1, strId.length()));
					brands.append(discountModel.getCode());
					brands.append(",");
				}

				// 折扣率
				discountModel.setDiscount(divideOneHundred(new BigDecimal(discount)).
						setScale(CardConstants.DEFAULT_DISCOUNT_NUM,
						CardConstants.DEFAULT_DISCOUNT_ROUNDING_MODE));
				discountModel.setCreateId(user.getId());
				discountModel.setCompanyId(user.getCompanyId());

				discountModelList.add(discountModel);
			}
			category.setBrands(brands.toString());
		}
		// 卡类别状态
		category.setStatus(CardConstants.KEY_ENABLE);
		category.setCompanyId(user.getCompanyId());
		category.setCreateId(user.getId());

		try {
			// 新增
			if(category.getOperateType() == Category.OPERATE_TYPE_ADD){
				categoryManager.addCategory(category, discountModelList);
				result.setResultInfo(0,"卡类别新增成功。");
			}else{
				// 修改
				category.setUpdateId(user.getId());
				categoryManager.updateCategory(category,discountModelList);
				result.setResultInfo(0,"卡类别编辑成功。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "出现异常，操作失败。");
		}
	}

	/**
	 * 删除从未启用的卡类别
	 */
	private void deleteCategory() {
		if(category.getId() == null){
			result.setParamErrorInfo("id");
			return;
		}

		category.setCompanyId(user.getCompanyId());
		category.setUpdateId(user.getId());

		try {
			if(-1 == categoryManager.deleteCategory(category)) {
				result.setResultInfo(-1, "此卡类别已被使用");
			}else {
				result.setResultInfo(0,"卡类别新增删除。");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "出现异常，操作失败。");
		}
	}

	/**
	 * 判断折扣率是否在0.01-1.00之间
	 * @param bigDecimal
	 * @return
	 */
	private boolean isDiscount(BigDecimal bigDecimal) {
		return (bigDecimal.compareTo(new BigDecimal("1.00")) != 1
				&& bigDecimal.compareTo(new BigDecimal("0.01")) != -1 );
	}

	/**
	 * 判断是否是数字
	 * @param str
	 * @return
	 */
	private  Boolean isNum(String str) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 将数字放大100倍，用于折扣率显示 0.60 -> 60
	 * @param bigDecimal
	 * @return
	 */
	private BigDecimal multiplyOneHundred (BigDecimal bigDecimal) {
		return bigDecimal.multiply(new BigDecimal(100)).setScale(0);
	}

	/**
	 * 将数字缩小100倍，用于折扣率显示 60 -> 0.60
	 * @param bigDecimal
	 * @return
	 */
	private BigDecimal divideOneHundred (BigDecimal bigDecimal) {
		return bigDecimal.divide(new BigDecimal(100));
	}

 	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public CategoryVo getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(CategoryVo detailVo) {
		this.detailVo = detailVo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public List<String> getBrandStoreList() {
		return brandStoreList;
	}

	public void setBrandStoreList(List<String> brandStoreList) {
		this.brandStoreList = brandStoreList;
	}

	public List<String> getDiscountList() {
		return discountList;
	}

	public void setDiscountList(List<String> discountList) {
		this.discountList = discountList;
	}
}
