package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.PayModeDto;
import com.itcrazy.alanmall.mscard.manager.PayModeManager;
import com.itcrazy.alanmall.mscard.model.PayMode;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.mscard.vo.card.PayModeVo;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 充值支付方式设置
 *
 * @author zhangli
 *
 */
public class PayModeAction extends InterfaceBaseAction {


	private static final long serialVersionUID = 8120081436591319217L;

	private PayMode payMode;
	private PayModeDto payModeDto;
	@Reference
	PayModeManager payModeManager;

	/*
	 * 充值支付方式设置一览
	 */
	public String getPayModeList() {

		if(payModeDto == null) {
			payModeDto = new PayModeDto();
		}

		payModeDto.setIsDeleted(0);
		payModeDto.setCompanyId(user.getCompanyId());
		// 根据商家ID获取支付方式列表
		List<PayMode> payModeList = payModeManager.getPageList(payModeDto);
		List<PayModeVo> payModeVoList = new ArrayList<PayModeVo>();

		// 将查询的数据设置到用于显示的PayModeVo对象中
		if(payModeList != null && payModeList.size()>0){

			for(PayMode p : payModeList){
				PayModeVo pv = new PayModeVo();

				pv.setId(p.getId());
				pv.setName(p.getName());
				pv.setStatus(p.getStatus());
				pv.setStatusName(KeyValueConvert.getStatusValue(p.getStatus()));
				pv.setDel(p.getDel());

				payModeVoList.add(pv);
			}
		}

		pageData.rows = payModeVoList;
		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 更新充值支付方式
	 * @return
	 */
	public String updatePayMode(){
		// 支付方式必须check
		if(payMode == null){
			result.setParamErrorInfo("payMode");
			return SUCCESS;
		}

		// 支付方式名称必须check
		if(payMode.getStatus() == null) {
			if(StringUtils.isBlank(payMode.getName())) {
				result.setParamErrorInfo("name");
				return SUCCESS;
			}
		}

		if (payMode.getId() == null) {
			// 新增操作
			payMode.setStatus(1);
			payMode.setCreateId(user.getId());
			payMode.setCompanyId(user.getCompanyId());
			payModeManager.addPayMode(payMode);
		}else {
			// 更新操作
			payMode.setUpdateId(user.getId());
			payModeManager.updatePayMode(payMode);
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 删除充值支付方式(逻辑删除)
	 * @return
	 */
	public String deletePayMode(){
		// 支付方式主键必须check
		if (payMode.getId() == null) {
			result.setParamErrorInfo("id");
			return SUCCESS;
		}

		// 更新支付方式表
		payMode.setUpdateId(user.getId());
		payMode.setIsDeleted(1);
		payModeManager.updatePayMode(payMode);
		result.setSuccessInfo();
		return SUCCESS;
	}

	public PayMode getPayMode() {
		return payMode;
	}

	public void setPayMode(PayMode payMode) {
		this.payMode = payMode;
	}

	public PayModeDto getPayModeDto() {
		return payModeDto;
	}

	public void setPayModeDto(PayModeDto payModeDto) {
		this.payModeDto = payModeDto;
	}
}
