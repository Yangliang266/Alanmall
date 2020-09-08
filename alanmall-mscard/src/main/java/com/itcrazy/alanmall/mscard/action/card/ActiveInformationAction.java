package com.itcrazy.alanmall.mscard.action.card;

import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.dto.Base.ActiveInformationDto;
import com.itcrazy.alanmall.mscard.manager.ActiveInformationManager;
import com.itcrazy.alanmall.mscard.model.ActiveInformation;
import com.itcrazy.alanmall.mscard.model.CreditSetting;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 激活卡信息表
 *
 * @author zhangli
 *
 */
public class ActiveInformationAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 4210031200936073021L;

	private ActiveInformationDto activeDto;

	private ActiveInformation detailVo;
	private ActiveInformation activeInfo;
	private String updStatusFlag;
	private List<String> creditList;

	@Reference
	ActiveInformationManager activeManager;

	/**
	 * 获取激活卡信息
	 * @return
	 */
	public String getActiveInformationDetail(){

		if(activeDto == null){
			activeDto = new ActiveInformationDto();
		}

		activeDto.setCompanyId(user.getCompanyId());
		activeDto.setStore(user.getStoreId());
		// 根据查询条件获取当前激活卡信息
		detailVo = activeManager.getActiveDetail(activeDto);
		if(detailVo != null) {
			detailVo.setStatusName(KeyValueConvert.getCardStatusValue(detailVo.getStatus()));
			if(detailVo.getSex() != null) {
				detailVo.setSexName(KeyValueConvert.getCardSexValue(detailVo.getSex()));
			}
		}

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 更新激活卡信息表
	 * @return
	 */
	public String updateActiveInformation() {
		if (activeInfo == null) {
			activeInfo = new ActiveInformation();
		}
		activeInfo.setCompanyId(user.getCompanyId());
		activeInfo.setUpdateId(user.getId());

		// 各个门店挂帐额度设置
		List<CreditSetting> creditSettings = new ArrayList<>();
		if(creditList != null) {
			for(String d : creditList) {
				String[] strArr = d.split(":");
				String strId = strArr[0];
				String credit = strArr[1];
				CreditSetting creditSetting = new CreditSetting();
				// 门店不以字母开头
				if(isNum(strId)) {
					// 挂帐类型 0: 品牌、 1: 门店
					creditSetting.setType(CardConstants.CARD_CREDIT_TYPE_STORE);
					creditSetting.setCode(strId);
				} else {
					// 品牌id以'b'开头，
					creditSetting.setType(CardConstants.CARD_CREDIT_TYPE_BRAND);
					creditSetting.setCode(strId.substring(1, strId.length()));
				}

				// 挂帐额度
				creditSetting.setCreditQuota((new BigDecimal(credit)).
						setScale(CardConstants.DEFAULT_DISCOUNT_NUM,
						CardConstants.DEFAULT_DISCOUNT_ROUNDING_MODE));

				creditSetting.setCreateId(user.getId());
				creditSetting.setCompanyId(user.getCompanyId());

				creditSettings.add(creditSetting);
			}
		}

		//  操作数据
		try {
			// 入库成功后的单号
			String headInReceiptNo = activeManager.updateActive(activeInfo,updStatusFlag,creditSettings);
			result.setResultInfo(0, headInReceiptNo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResultInfo(-1, "操作失败");
			return SUCCESS;
		}
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


	public ActiveInformationDto getActiveDto() {
		return activeDto;
	}

	public void setActiveDto(ActiveInformationDto activeDto) {
		this.activeDto = activeDto;
	}

	public ActiveInformation getDetailVo() {
		return detailVo;
	}

	public void setDetailVo(ActiveInformation detailVo) {
		this.detailVo = detailVo;
	}

	public ActiveInformation getActiveInfo() {
		return activeInfo;
	}

	public void setActiveInfo(ActiveInformation activeInfo) {
		this.activeInfo = activeInfo;
	}

	public String getUpdStatusFlag() {
		return updStatusFlag;
	}

	public void setUpdStatusFlag(String updStatusFlag) {
		this.updStatusFlag = updStatusFlag;
	}

	public List<String> getCreditList() {
		return creditList;
	}

	public void setCreditList(List<String> creditList) {
		this.creditList = creditList;
	}

}
