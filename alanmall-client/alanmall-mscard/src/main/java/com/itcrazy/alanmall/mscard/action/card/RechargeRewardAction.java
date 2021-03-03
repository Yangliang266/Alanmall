package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.RechargeRewardDto;
import com.itcrazy.alanmall.mscard.manager.CategoryManager;
import com.itcrazy.alanmall.mscard.manager.RechargeRewardManager;
import com.itcrazy.alanmall.mscard.model.RechargeReward;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * 充值／奖励设置
 *
 * @author zhangli
 *
 */
public class RechargeRewardAction extends InterfaceBaseAction {


	private static final long serialVersionUID = 7069487434529150519L;

	private RechargeReward rechargeReward;
	private RechargeRewardDto rechargeRewardDto;
	@Reference
	RechargeRewardManager rechargeRewardManager;
	@Reference
	CategoryManager categoryManager;

	/**
	 * 获取充值/奖励列表
	 * @return
	 */
	public String getRechargeRewardList() {
		if (rechargeRewardDto == null ) {
			rechargeRewardDto = new RechargeRewardDto();
		}
		rechargeRewardDto.setCompanyId(user.getCompanyId());

		// 根据商家ID获取充值/奖励列表
		List<RechargeReward> rechargeRewardList = rechargeRewardManager.getPageList(rechargeRewardDto);

		pageData.rows = rechargeRewardList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 更新充值奖励设置
	 * @return
	 */
	public String updateRechargeReward(){
		// 充值/奖励必须check
		if(rechargeReward == null){
			result.setParamErrorInfo("rechargeReward");
			return SUCCESS;
		}

		// 卡类别必须check
		if(StringUtils.isBlank(rechargeReward.getCardCategories())) {
			result.setParamErrorInfo("cardCategories");
			return SUCCESS;
		}

		// 充值方式必须check
		if(rechargeReward.getRechargeMode() == null) {
			result.setParamErrorInfo("rechargeMode");
			return SUCCESS;
		}

		// 充值金额必须check
		if(StringUtils.isBlank(rechargeReward.getRecharge())) {
			result.setParamErrorInfo("recharge");
			return SUCCESS;
		}

		String currRechargeMin = "";
		String currRechargeMax = "";
		if(rechargeReward.getRechargeMode() == 1) {
			// 金额段充值的场合，每充金额数check
			String[] arrRecharge = rechargeReward.getRecharge().split(",");
			if(arrRecharge.length < 3) {
				result.setResultInfo(1, "每充值金额参数不完整。");
				//result.setParamErrorInfo("recharge");
				return SUCCESS;
			}
			// 金额段充值的场合，充值金额值check
			if(StringUtils.isBlank(arrRecharge[0]) || StringUtils.isBlank(arrRecharge[1]) || StringUtils.isBlank(arrRecharge[2])) {
				result.setResultInfo(1, "充值金额段参数不完整。");
				//result.setParamErrorInfo("recharge");
				return SUCCESS;
			}
			currRechargeMin = arrRecharge[0];
			currRechargeMax = arrRecharge[1];

			// 充值金额Min值<充值金额Max值check
			if(Integer.parseInt(currRechargeMin) > Integer.parseInt(currRechargeMax)) {
				result.setResultInfo(1, "充值金额段最小值不得大于最大值。");
				//result.setParamErrorInfo("recharge");
				return SUCCESS;
			}
			// 每充金额< [充值金额Max值-充值金额Min值]
			if(Integer.parseInt(arrRecharge[2]) > (Integer.parseInt(currRechargeMax) - Integer.parseInt(currRechargeMin))) {
				result.setResultInfo(1, "每充金额不得大于[充值金额Max值-充值金额Min值]。");
				//result.setParamErrorInfo("recharge");
				return SUCCESS;
			}
		}

		// 奖励规则必须check
		if(rechargeReward.getRewardMode() == null) {
			result.setParamErrorInfo("rewardMode");
			return SUCCESS;
		}

		// 奖励金额必须check
		if(rechargeReward.getReward() == null) {
			result.setParamErrorInfo("reward");
			return SUCCESS;
		}

		if (rechargeReward.getId() == null) {
			RechargeRewardDto rechargeRewardDto = new RechargeRewardDto();
			List<RechargeReward> rechargeRewardList = new ArrayList<>();
			String[] arrCategory = rechargeReward.getCardCategories().split(",");
			String[] arrRech;
			for (String category:arrCategory) {
				// 数据已存在性check
				rechargeRewardDto.setCompanyId(user.getCompanyId());
				rechargeRewardDto.setCardCategorie(category);
				rechargeRewardDto.setRechargeMode(rechargeReward.getRechargeMode());
				rechargeRewardDto.setRecharge(rechargeReward.getRecharge());
				// 根据当前条件检索数据
				rechargeRewardList = rechargeRewardManager.getPageList(rechargeRewardDto);
				if(rechargeRewardList.size() != 0) {
					result.setResultInfo(1, "卡类别的充值奖励设置重复。");
					return SUCCESS;
				}

				// 金额段充值的场合，数据交叉性check
				if(rechargeReward.getRechargeMode() == 1) {
					rechargeRewardDto.setRecharge(null);
					// 根据当前条件检索数据
					rechargeRewardList = rechargeRewardManager.getPageList(rechargeRewardDto);
					for(RechargeReward rechargeReward:rechargeRewardList) {
						arrRech = rechargeReward.getRecharge().split(",");
						if(Integer.parseInt(currRechargeMin) > Integer.parseInt(arrRech[0]) && Integer.parseInt(currRechargeMin) < Integer.parseInt(arrRech[1])) {
							result.setResultInfo(1, "充值金额范围重叠。");
							return SUCCESS;
						}
						if(Integer.parseInt(currRechargeMax) > Integer.parseInt(arrRech[0]) && Integer.parseInt(currRechargeMax) < Integer.parseInt(arrRech[1])) {
							result.setResultInfo(1, "充值金额范围重叠。");
							return SUCCESS;
						}
					}
				}
			}

			// 若存在当前支付方式，充值金额，奖励规则，奖励金额的数据，则更新卡类别
			RechargeRewardDto rechargeDto = new RechargeRewardDto();
			rechargeDto.setRechargeMode(rechargeReward.getRechargeMode());
			rechargeDto.setRecharge(rechargeReward.getRecharge());
			rechargeDto.setRewardMode(rechargeReward.getRewardMode());
			rechargeDto.setReward(rechargeReward.getReward());
			rechargeDto.setCompanyId(user.getCompanyId());
			rechargeRewardList = rechargeRewardManager.getPageList(rechargeDto);
			if(rechargeRewardList.size() == 0) {
				// 新增操作
				rechargeReward.setCreateId(user.getId());
				rechargeReward.setCompanyId(user.getCompanyId());
				rechargeRewardManager.addRechargeReward(rechargeReward);
			}else {
				// 更新操作
				RechargeReward recharge = new RechargeReward();
				String newCategories = rechargeRewardList.get(0).getCardCategories() + "," + rechargeReward.getCardCategories();
				recharge.setCardCategories(newCategories);
				recharge.setUpdateId(user.getId());
				recharge.setId(rechargeRewardList.get(0).getId());
				rechargeRewardManager.updateRechargeReward(recharge);
			}

		}else {
			RechargeRewardDto rechargeRewardDto = new RechargeRewardDto();
			List<RechargeReward> rechargeRewardList = new ArrayList<>();
			String[] arrCategory = rechargeReward.getCardCategories().split(",");
			String[] arrRech;
			if(rechargeReward.getRechargeMode() == 1) {
				for (String category:arrCategory) {
					// 金额段充值的场合，数据交叉性check
					rechargeRewardDto.setCompanyId(user.getCompanyId());
					rechargeRewardDto.setCardCategorie(category);
					rechargeRewardDto.setRechargeMode(rechargeReward.getRechargeMode());
					rechargeRewardDto.setId(rechargeReward.getId());

					// 根据当前条件检索数据
					rechargeRewardList = rechargeRewardManager.getPageList(rechargeRewardDto);
					for(RechargeReward rechargeReward:rechargeRewardList) {
						arrRech = rechargeReward.getRecharge().split(",");
						if(Integer.parseInt(currRechargeMin) > Integer.parseInt(arrRech[0]) && Integer.parseInt(currRechargeMin) < Integer.parseInt(arrRech[1])) {
							result.setResultInfo(1, "充值金额范围重叠。");
							return SUCCESS;
						}
						if(Integer.parseInt(currRechargeMax) > Integer.parseInt(arrRech[0]) && Integer.parseInt(currRechargeMax) < Integer.parseInt(arrRech[1])) {
							result.setResultInfo(1, "充值金额范围重叠。");
							return SUCCESS;
						}
					}
				}
			}

			// 更新操作
			rechargeReward.setUpdateId(user.getId());
			rechargeRewardManager.updateRechargeReward(rechargeReward);
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 删除充值奖励(逻辑删除)
	 * @return
	 */
	public String deleteRechargeReward(){
		// 充值/奖励主键必须check
		if (rechargeReward.getId() == null) {
			result.setParamErrorInfo("id");
			return SUCCESS;
		}

		// 更新充值/奖励信息
		rechargeReward.setIsDeleted(1);
		rechargeReward.setUpdateId(user.getId());
		rechargeRewardManager.updateRechargeReward(rechargeReward);

		result.setSuccessInfo();
		return SUCCESS;
	}

	public RechargeReward getRechargeReward() {
		return rechargeReward;
	}

	public void setRechargeReward(RechargeReward rechargeReward) {
		this.rechargeReward = rechargeReward;
	}

	public RechargeRewardDto getRechargeRewardDto() {
		return rechargeRewardDto;
	}

	public void setRechargeRewardDto(RechargeRewardDto rechargeRewardDto) {
		this.rechargeRewardDto = rechargeRewardDto;
	}

}
