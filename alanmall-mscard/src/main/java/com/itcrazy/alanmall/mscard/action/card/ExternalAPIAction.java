package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.manager.ExternalAPIManager;
import com.itcrazy.alanmall.mscard.model.Consume;
import com.itcrazy.alanmall.mscard.model.ExternalAPICardInfo;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.user.manager.UserManager;
import com.itcrazy.alanmall.user.model.User;

import java.math.BigDecimal;

/**
 * 激活卡信息表
 *
 * @author zhangli
 *
 */
public class ExternalAPIAction extends InterfaceBaseAction {


	private static final long serialVersionUID = -3918803645910485426L;

	private String cardNo;
	private ExternalAPICardInfo detailVo;

	private Consume consume;
	private String orderNo;
	private String remarks;

	@Reference
	ExternalAPIManager externalAPIManager;

	@Reference
	UserManager userManager;

	/**
	 * 获取卡信息
	 * @return
	 */
	public String getExternalAPIDetail(){

		detailVo = externalAPIManager.query(cardNo, user.getBrandId(), user.getStoreId(), user.getCompanyId());

		User createCardUser = userManager.getUserById(user.getId());
		if(detailVo != null && createCardUser != null) {
			detailVo.setOperatorName(createCardUser.getRealName());
        }

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 获取授信卡消费信息
	 * @return
	 * @throws Exception
	 */
	public String getExternalAPIList(){

		try {
			consume.setStoreId(user.getStoreId());
			consume.setAddReward(BigDecimal.ZERO);
			consume.setUserId(user.getId());
			consume.setCompanyId(user.getCompanyId());
			consume.setBrandId(user.getBrandId());
			int retValue = externalAPIManager.consumeWithRemarks(consume,remarks);
			if(retValue == 1) {
				result.setResultInfo(1, "参数验证不通过（或消费金额  != 本金消费 + 奖励金额 + 挂账消费金额+其他支付金额 ）。");
				return SUCCESS;
			}else if(retValue == 2) {
				result.setResultInfo(2, "密码验证失败（没有密码请传null）。");
				return SUCCESS;
			}else if(retValue == 3) {
				result.setResultInfo(3, "此卡为非激活卡。");
				return SUCCESS;
			}else if(retValue == 4) {
				result.setResultInfo(4, "消费金额 / 本金消费 / 奖励金额  大于对应的余额。");
				return SUCCESS;
			}else if(retValue == 5) {
				result.setResultInfo(5, "此卡不可挂账。");
				return SUCCESS;
			}else if(retValue == 6) {
				result.setResultInfo(6, "此卡可挂账，但是挂账消费金额大于剩余可挂账金额。");
				return SUCCESS;
			}else if(retValue == 7) {
				result.setResultInfo(7, "其他错误。");
				return SUCCESS;
			}else if(retValue == 8) {
				result.setResultInfo(8, "其他消费金额大于0时，支付方式不合法。");
				return SUCCESS;
			}else if(retValue == 9) {
				result.setResultInfo(9, "此卡本门店不可消费。");
				return SUCCESS;
			}else if(retValue == 10) {
				result.setResultInfo(10, "此订单号已存在。");
				return SUCCESS;
			}else if(retValue == 11) {
				result.setResultInfo(11, "此卡为亲情卡子卡，母卡卡号丢失。");
				return SUCCESS;
			}else if(retValue == 12) {
				result.setResultInfo(12, "此卡为亲情卡子卡，母卡非激活状态。");
				return SUCCESS;
			}else if(retValue == 13) {
				result.setResultInfo(13, "此卡为亲情卡不可挂账。");
				return SUCCESS;
			}
		}catch(Exception e){
			e.printStackTrace();			result.setResultInfo(9, "发生系统异常错误，请联系管理员。");
			result.setResultInfo(9, "发生系统异常错误，请联系管理员。");			return SUCCESS;
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 撤销订单
	 * @return
	 */
	public String getExternalAPIHistory(){

		try {
			int retValue = externalAPIManager.revokeConsume(orderNo, user.getCompanyId(), user.getId());
			if(retValue == 1) {
				result.setResultInfo(1, "参数验证不通过。");
				return SUCCESS;
			}else if(retValue == 2) {
				result.setResultInfo(2, "订单不存在/被删除。");
				return SUCCESS;
			}else if(retValue == 3) {
				result.setResultInfo(3, "订单消费失败/已被撤销。");
				return SUCCESS;
			}else if(retValue == 4) {
				result.setResultInfo(4, "消费和撤销不在在同一天，同一天才可撤销（不是24小时之内）。");
				return SUCCESS;
			}else if(retValue == 5) {
				result.setResultInfo(5, "其他错误(消费模式异常)。");
				return SUCCESS;
			}else if(retValue == 6) {
				result.setResultInfo(6, "消费卡号异常/卡非激活状态。");
				return SUCCESS;
			}else if(retValue == 7) {
				result.setResultInfo(7, "撤销后的奖励余额 < 0 ， 奖励余额不够扣除。");
				return SUCCESS;
			}
			else if(retValue == 8) {
				result.setResultInfo(8, "挂账订单的未清账总额 != 挂账订单的原始挂账额，即已经被清账，或者卡当前挂账总额小于撤销挂账额 不可撤销（撤销后，挂账总额会小于0）。");
				return SUCCESS;
			}
		} catch (Exception e) {
			result.setResultInfo(9, "发生系统异常错误，请联系管理员。");
			return SUCCESS;
		}
		result.setSuccessInfo();
		return SUCCESS;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public ExternalAPICardInfo getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(ExternalAPICardInfo detailVo) {
		this.detailVo = detailVo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Consume getConsume() {
		return consume;
	}

	public void setConsume(Consume consume) {
		this.consume = consume;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
