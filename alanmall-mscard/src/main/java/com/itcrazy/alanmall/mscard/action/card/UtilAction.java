package com.itcrazy.alanmall.mscard.action.card;

import com.itcrazy.alanmall.office.manager.SmsManager;
import com.itcrazy.alanmall.office.model.Sms;
import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.dto.Base.CategoryDto;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeRewardDto;
import com.itcrazy.alanmall.mscard.manager.CardInforManager;
import com.itcrazy.alanmall.mscard.manager.CategoryManager;
import com.itcrazy.alanmall.mscard.manager.RechargeRewardManager;
import com.itcrazy.alanmall.mscard.model.Category;
import com.itcrazy.alanmall.mscard.model.RechargeReward;
import com.itcrazy.alanmall.mscard.model.UCloudToken;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.vo.card.CardScopeVo;
import com.itcrazy.alanmall.mscard.vo.user.ScopeVo;
import com.itcrazy.alanmall.common.client.cache.SessionCache;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.util.DateFormat;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;
import com.itcrazy.alanmall.merchant.co.CityCo;
import com.itcrazy.alanmall.merchant.co.ProvinceCityCo;
import com.itcrazy.alanmall.merchant.dto.BrandDto;
import com.itcrazy.alanmall.merchant.dto.StoreDto;
import com.itcrazy.alanmall.merchant.manager.*;
import com.itcrazy.alanmall.merchant.model.Brand;
import com.itcrazy.alanmall.merchant.model.Store;
import com.itcrazy.alanmall.user.manager.UserManager;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 工具aciton
 * 某些页面展示的的部分内容需要请求接口，
 * 避免创建过多的action，所以创建此类
 * @author chenfei
 * 2018-09-11
 */
public class UtilAction extends InterfaceBaseAction{


	private static final long serialVersionUID = 2805359858527851473L;


	@Reference
	private BrandManager brandManager;
	@Reference
	private CityManager cityManager;
	@Reference
	private StoreManager storeManager;
	@Reference
	private CategoryManager categoryManager;
	@Reference
	private CardInforManager cardInforManager;
	@Reference
	private CompanyManager companyManager;
	@Reference
	private ProvinceManager provinceManager;
	@Reference
	private UserManager userManager;
	@Reference
    private SmsManager smsManager;
	@Reference
	private RechargeRewardManager rechargeRewardManager;

	private CategoryDto categoryDto;
	private List<CardScopeVo> utilVoBrandList;
	private List<Long> brandIds;
	private List<String> provinceCityIds;
	private List<String> storeIds;
	private List<CardScopeVo> utilVoProvinceCityList;
	private List<CardScopeVo> utilVoBrandStoreList;
	private List<CardScopeVo> utilVoAbleBrandStoreList;
	private String utilVoSerialNo;
	private String url;
	private Long categoryId;
	private List<RechargeReward> utilVoRewardRulesList;
	private UCloudToken utilVoUCloudToken;
	private String utilVoOrderNo;

	// 短信验证码用
	private String checkFlag;
	private String mobile;

	/**
	 * 获取品牌列表
	 * @return
	 */
	public String getBrandList() {
		if (user == null) {
			result.setParamErrorInfo("user");
			return SUCCESS;
        }

		BrandDto brandDto = new BrandDto();
		pageSet(brandDto);
		brandDto.setLimit(Integer.MAX_VALUE);
		brandDto.setCompanyId(user.getCompanyId());
		List<Brand> brandList = brandManager.getBrandListBasic(brandDto);

		List<CardScopeVo> bvList = new ArrayList<CardScopeVo>();
		for(Brand b : brandList) {
			CardScopeVo csv = new CardScopeVo();
			csv.setId(b.getId());
			csv.setStrId("b" + b.getId());
			csv.setName(b.getName());
			bvList.add(csv);
		}
		setUtilVoBrandList(bvList);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 根据品牌，获取省市列表
	 * @return
	 */
	public String getProvinceCityList() {
		if (user == null) {
			result.setParamErrorInfo("user");
			return SUCCESS;
        }

		if(brandIds == null) {
			brandIds = new ArrayList<>();
		}

		/*********** 根据品牌获取城市 Begin**************/
		List<ProvinceCityCo> provinceCityCoList = new ArrayList<>();
		Map<String, List<String>> provinceCityCoMap = new HashMap<>();
		// 获取品牌对应的所有省（此处会重复）
		for(Long bId : brandIds) {
			// 根据companyId和brandId获得品牌所在的省市
			List<ProvinceCityCo> pccList =  cityManager.getProvinceCityList(user.getCompanyId(), bId);
			provinceCityCoList.addAll(pccList);
		}

		// 将重复的省市去掉
		for(ProvinceCityCo p : provinceCityCoList) {
			List<String> nv = new ArrayList<>();

			List<CityCo> cl = p.getCities();
			String pk = p.getId() + ":" + p.getName();

			// 获取此省下的所有市
			for(CityCo c : cl) {
				nv.add(c.getId() + ":" + c.getName());
			}

			// 在去过重的map里获取省
			List<String> pv = provinceCityCoMap.get(pk);
			// 如果去过重的省市Map中不存在，直接放入
			if(pv == null) {
				provinceCityCoMap.put(pk, nv);
			}else {
				pv.removeAll(nv);	// 从以去重的市列表中去除本省下的市
				pv.addAll(nv);		// 再将本省下的市全部加入去重后的省中
				provinceCityCoMap.put(pk, pv);	// 将值存入map
			}
		}

		// Map<String, List<String>> 转 List<CardScopeVo>,上方不直接使用CardScopeVo是因为无法去重
		List<CardScopeVo> pvList = new ArrayList<CardScopeVo>();
		for(String key : provinceCityCoMap.keySet()) {
			CardScopeVo pcv = new CardScopeVo();
			pcv.setStrId(key.split(":")[0]);
			pcv.setName(key.split(":")[1]);

			List<String> citys = provinceCityCoMap.get(key);
			List<CardScopeVo> cvList = new ArrayList<CardScopeVo>();
			for(String city : citys) {
				CardScopeVo ccv = new CardScopeVo();
				ccv.setStrId(city.split(":")[0]);
				ccv.setName(city.split(":")[1]);
				cvList.add(ccv);
			}
			pcv.setSubs(cvList);
			pvList.add(pcv);
		}

		setUtilVoProvinceCityList(pvList);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获得品牌省市门店列表
	 * @return
	 */
	public String getBrandStoreList(){

		if(brandIds == null) {
			brandIds = new ArrayList<>();
		}
		if(provinceCityIds == null) {
			provinceCityIds = new ArrayList<>();
		}

		/*********** 根据品牌和城市获取门店 Begin**************/
		List<CardScopeVo> bvList = new ArrayList<CardScopeVo>();
		for(Long brandId : brandIds) {

			List<CardScopeVo> svList = new ArrayList<CardScopeVo>();
			// 可能是省的id，也可能是市的id
			for(String id : provinceCityIds) {
				// 获取省市下的门店
				List<Store> storeList = storeManager.getListByCity(user.getCompanyId(), brandId, id);

				// 转换
				for(Store s : storeList) {
					CardScopeVo sv = new CardScopeVo();
					sv.setId(s.getId());
					sv.setName(s.getName());
					svList.add(sv);
				}
			}

			CardScopeVo bv = new CardScopeVo();
			bv.setStrId("b"+brandId);
			bv.setName(brandManager.getBrandById(brandId).getName());
			bv.setSubs(svList);

			bvList.add(bv);
		}

		setUtilVoBrandStoreList(bvList);
		/*********** 根据品牌和城市获取门店 End**************/
		result.setSuccessInfo();
		return SUCCESS;
	}


	/**
	 * 根据卡类别获取可充值/挂账的品牌和门店
	 * @return
	 */
	public String getAbleBrandStoreList() {
		if (user == null) {
			result.setParamErrorInfo("user");
			return SUCCESS;
        }

		if (categoryId == null) {
			result.setParamErrorInfo("categoryId");
			return SUCCESS;
		}

		// 获取卡类别
		Category categoryById = categoryManager.getCategoryById(categoryId, user.getCompanyId());

		// 品牌全参与
		String allJoinBrands = categoryById.getAllJoinBrands();
		// 可消费品牌
		String brands = categoryById.getBrands();
		// 可消费门店
		String stores = categoryById.getStores();

		String[] aAllJoinBrands = StringUtils.isBlank(allJoinBrands) ? new String[] {}  : allJoinBrands.split(",");
		String[] aBrands = StringUtils.isBlank(brands) ? new String[] {}  : brands.split(",");
		String[] aStores = StringUtils.isBlank(stores) ? new String[] {}  : stores.split(",");

		// 获取品牌下的门店
		List<CardScopeVo> bvList = new ArrayList<CardScopeVo>();

		// 循环品牌
		for(String strBrandId : aBrands) {
			Long brandId = Long.valueOf(strBrandId);

			// 品牌list的子集 门店List
			List<CardScopeVo> svList = new ArrayList<CardScopeVo>();

			// 获取品牌下所有的省市
			List<ProvinceCityCo> pccList =  cityManager.getProvinceCityList(user.getCompanyId(), brandId);
			// 城市可能是省的id，也可能是市的id
			for(ProvinceCityCo ppc : pccList) {
				// 获取省市下的门店
				List<Store> storeList = storeManager.getListByCity(user.getCompanyId(), brandId, ppc.getId());

				// 转换
				for(Store s : storeList) {
					CardScopeVo sv = new CardScopeVo();
					sv.setId(s.getId());
					sv.setName(s.getName());

					// 当品牌全参与时，或者非全参与，门店是消费门店时，将门店加入list中
					if(ArrayUtils.contains(aAllJoinBrands, brandId.toString() )
							|| ArrayUtils.contains(aStores, s.getId().toString())) {
						svList.add(sv);
					}
				}
			}

			// 向品牌list中加入品牌
			Brand brandById = brandManager.getBrandById(brandId);
			CardScopeVo bv = new CardScopeVo();
			bv.setStrId("b"+brandById.getId());
			bv.setId(null);	// 如果要使用strId,这里要设置null
			bv.setName(brandById.getName());
			bv.setSubs(svList);
			bvList.add(bv);
		}

		setUtilVoAbleBrandStoreList(bvList);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取所有卡类别
	 * @return
	 */
	public String getCategoryList(){
		if(categoryDto == null){
			categoryDto = new CategoryDto();
		}

		pageSet(categoryDto);
		categoryDto.setCompanyId(user.getCompanyId());
		categoryDto.setLimit(Integer.MAX_VALUE);
		List<Category> categoryList = categoryManager.getPageList(categoryDto);

		pageData.rows = categoryList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取批次号(制卡管理)
	 * @return
	 */
	public String getCardInfo() {

		CardBaseDto cardBaseDto = new CardBaseDto();
		cardBaseDto.setCompanyId(user.getCompanyId());
		utilVoSerialNo = cardInforManager.getMaxSerilNo(cardBaseDto);

		setUtilVoSerialNo(utilVoSerialNo);
		result.setSuccessInfo();
		return SUCCESS;
	}


	/**
     * 获取营销活动中所需要的门店信息(按城市分组)
     * @return
     */
    @SuppressWarnings("unlikely-arg-type")
	public String getScopeList4Prom() {
        if (user == null) {
            result.setParamErrorInfo("user");
            return SUCCESS;
        }

        Long userStoreId = user.getStoreId();
        String storeIds = "";
		StoreDto sdto=new StoreDto();
		sdto.setCompanyId(user.getCompanyId());
		sdto.setLimit(Integer.MAX_VALUE);
		List<Store> sList=storeManager.getPageList(sdto);
		if(sList==null ||  sList.size()<1){
			result.setResultInfo(1001, "门店不存在");
			return SUCCESS;
		}
		if(sList.size()==1){
			if(userStoreId != null && storeIds.equals(userStoreId)) {
				result.setResultInfo(1001, "不存在其他门店");
				return SUCCESS;
			}else {
				storeIds += sList.get(0).getId();
			}
		}else{
			for(int i = 0 ; i < sList.size(); i++){
				if(userStoreId != null && userStoreId.equals(sList.get(i).getId())) {
					continue;
				}
				storeIds += sList.get(i).getId()+",";
			}
			// 去除最后一个逗号
			storeIds = storeIds.substring(0,storeIds.length()-1);
		}

        if (storeIds == null || "".equals(storeIds.trim())) {
            result.setParamErrorInfo("user.storeIds");
            return SUCCESS;
        }

        StoreDto dto = new StoreDto();
        dto.setStoreIds(storeIds);
        dto.setStatus(0);//已开通
        List<Store> stList = storeManager.getAdminStoreList(dto);
        if (stList == null || stList.size() == 0) {
            result.setResultInfo(1, "门店不存在");
            return SUCCESS;
        }

        List<Long> brandIdList = new ArrayList<Long>();
        List<String> cityList = new ArrayList<String>();
        List<ScopeVo> svList = new ArrayList<ScopeVo>();

        ScopeVo bSV = null;
        ScopeVo citySV = null;
        long provinceStartId = 1000000;
        long cityStartId = 100000;
        for (Store s : stList) {

            Long brandId = s.getBrandId() + ScopeVo.BRAND_START_ID;
            if (!brandIdList.contains(brandId)) {
                Brand b = brandManager.getBrandById(s.getBrandId());
                if (b == null) {
                    continue;
                }
                bSV = new ScopeVo();
                bSV.setId(brandId);
                bSV.setName(b.getName());
                svList.add(bSV);
                brandIdList.add(brandId);
            }

            //门店
            ScopeVo sc = new ScopeVo();
            sc.setId(s.getId());
            sc.setName(s.getName());

            // 当门店有归属城市的情况
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
            } else {
                // 当门店没有归属城市的情况下，即门店分组于品牌之下
                bSV.getSubs().add(sc);
            }
        }

        pageData.rows = svList;
        result.setSuccessInfo();
        return SUCCESS;
    }

    /**
	 * 短信验证
	 * @return
	 */
	public String getCheckMsg(){

		Sms sms = new Sms();
        sms.setSendLevel(Sms.SEND_LEVEL_HIGH);
        sms.setBrandId(user.getBrandId());
        sms.setCompanyId(user.getCompanyId());
        sms.setCreateId(user.getId());
        sms.setMobile(mobile);
        sms.setPlanTime(new Date());
        sms.setSource(2);
        String valid = RandomNumUtil.getNumber(4);
        sms.setSmsContent("您本次操作的验证码是["+ valid +"](5分钟内有效),请尽快完成验证");
        sms.setSmsTypeId(3L);

        smsManager.addSms(sms);

        String key = "";
        if("0".equals(checkFlag)) {
        	// 挂失画面，发送短信验证码的场合
        	key = CardConstants.CACHE_KEY_LOST;
        }else if("1".equals(checkFlag)) {
        	// 补办画面，发送短信验证码的场合
        	key = CardConstants.CACHE_KEY_SUPPLEMENT;
        }else {
        	// 激活中记名卡信息填写画面，发送验证码的场合
        	key = CardConstants.CACHE_KEY_CARD;
        }
        //存入缓存
        SessionCache.put(key + mobile, valid, 5);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取充值奖励规则
	 * @return
	 */
	public String getRewardRulesList() {

		if (categoryId == null) {
			result.setParamErrorInfo("categoryId");
			return SUCCESS;
		}

		RechargeRewardDto rechargeRewardDto = new RechargeRewardDto();
		rechargeRewardDto.setCardCategorie(categoryId.toString());
		List<RechargeReward> RewardRules = rechargeRewardManager.getRewardRules(rechargeRewardDto);
		setUtilVoRewardRulesList(RewardRules);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取上传配置信息
	 * @return
	 */
	public String getUCloudToken() {

		String bucketName = SysConfig.getCommonConf("CARD_UCLOUD_BUCKET_NAME");
		String bucketUrl = SysConfig.getCommonConf("CARD_UCLOUD_BUCKET_URL");
		String tokenPublicKey = SysConfig.getCommonConf("CARD_UCLOUD_TOKEN_PUBLIC_KEY");
		String tokenPrivateKey = SysConfig.getCommonConf("CARD_UCLOUD_TOKEN_PRIVATE_KEY");
		String tokenServerUrl = SysConfig.getCommonConf("CARD_UCLOUD_TOKEN_SERVER_URL");
		String prefix = SysConfig.getCommonConf("CARD_UCLOUD_PREFIX");

		UCloudToken uCloudToken = new UCloudToken();

		uCloudToken.setBucketName(bucketName);
		uCloudToken.setBucketUrl(bucketUrl);
		uCloudToken.setTokenPublicKey(tokenPublicKey);
		uCloudToken.setTokenPrivateKey(tokenPrivateKey);
		uCloudToken.setTokenServerUrl(tokenServerUrl);
		uCloudToken.setPrefix(prefix);
		setUtilVoUCloudToken(uCloudToken);
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 自动生成订单号（实体授信卡消费画面）
	 * @return
	 */
	public String getOrderNo() {

		Long storeId = user.getStoreId();
		String random = RandomNumUtil.getNumber(4);
		utilVoOrderNo = (storeId==null?"":storeId.toString()) + "-" + DateFormat.dateToString(new Date(), "yyyyMMddHHmmss") +
				"-" + random;

		result.setSuccessInfo();
		return SUCCESS;
	}

	public List<CardScopeVo> getUtilVoBrandList() {
		return utilVoBrandList;
	}

	public void setUtilVoBrandList(List<CardScopeVo> utilVoBrandList) {
		this.utilVoBrandList = utilVoBrandList;
	}

	public List<CardScopeVo> getUtilVoProvinceCityList() {
		return utilVoProvinceCityList;
	}

	public void setUtilVoProvinceCityList(List<CardScopeVo> utilVoProvinceCityList) {
		this.utilVoProvinceCityList = utilVoProvinceCityList;
	}

	public List<CardScopeVo> getUtilVoBrandStoreList() {
		return utilVoBrandStoreList;
	}

	public void setUtilVoBrandStoreList(List<CardScopeVo> utilVoBrandStoreList) {
		this.utilVoBrandStoreList = utilVoBrandStoreList;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public void setCategoryDto(CategoryDto categoryDto) {
		this.categoryDto = categoryDto;
	}

	public String getUtilVoSerialNo() {
		return utilVoSerialNo;
	}

	public void setUtilVoSerialNo(String utilVoSerialNo) {
		this.utilVoSerialNo = utilVoSerialNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Long> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<Long> brandIds) {
		this.brandIds = brandIds;
	}

	public List<String> getProvinceCityIds() {
		return provinceCityIds;
	}

	public void setProvinceCityIds(List<String> provinceCityIds) {
		this.provinceCityIds = provinceCityIds;
	}

	public List<String> getStoreIds() {
		return storeIds;
	}

	public void setStoreIds(List<String> storeIds) {
		this.storeIds = storeIds;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<CardScopeVo> getUtilVoAbleBrandStoreList() {
		return utilVoAbleBrandStoreList;
	}

	public void setUtilVoAbleBrandStoreList(List<CardScopeVo> utilVoAbleBrandStoreList) {
		this.utilVoAbleBrandStoreList = utilVoAbleBrandStoreList;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public List<RechargeReward> getUtilVoRewardRulesList() {
		return utilVoRewardRulesList;
	}

	public void setUtilVoRewardRulesList(List<RechargeReward> utilVoRewardRulesList) {
		this.utilVoRewardRulesList = utilVoRewardRulesList;
	}


	public UCloudToken getUtilVoUCloudToken() {
		return utilVoUCloudToken;
	}

	public void setUtilVoUCloudToken(UCloudToken utilVoUCloudToken) {
		this.utilVoUCloudToken = utilVoUCloudToken;
	}

	public String getUtilVoOrderNo() {
		return utilVoOrderNo;
	}

	public void setUtilVoOrderNo(String utilVoOrderNo) {
		this.utilVoOrderNo = utilVoOrderNo;
	}

}
