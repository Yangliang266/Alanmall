package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.dto.Base.CardBaseDto;
import com.itcrazy.alanmall.mscard.manager.ParameterManager;
import com.itcrazy.alanmall.mscard.model.Parameter;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

/**
 * 卡系统参数配置
 *
 * @author zhangli
 *
 */
@SuppressWarnings("restriction")
public class ParameterAction extends InterfaceBaseAction {
	private static final long serialVersionUID = 2280960338939045947L;

	private Parameter detailVo;
	private Parameter param;
	private String chkPwdFlag;

	@Reference
	ParameterManager parameterManager;

	/**
	 * 获取卡系统参数信息
	 * @return
	 */
	public String getParameterDetail() {
		CardBaseDto baseDto = new CardBaseDto();
		baseDto.setIsDeleted(0);
		baseDto.setCompanyId(user.getCompanyId());
		// 根据商家ID查询卡系统参数信息
		detailVo = parameterManager.getParamDetail(baseDto);

		result.setSuccessInfo();
		return SUCCESS;
	}

	/**
	 * 更新卡系统参数
	 * @return
	 */
	public String updateParameter(){
		// 卡系统参数check
		if(param == null){
			result.setParamErrorInfo("parameter");
			return SUCCESS;
		}
		// 读卡器型号必须check
		if(param.getType() == null){
			result.setParamErrorInfo("type");
			return SUCCESS;
		}
		// 芯片卡密码必须check
		if(chkPwdFlag == "1") {
			if(StringUtils.isBlank(param.getPwd())){
				result.setParamErrorInfo("pwd");
				return SUCCESS;
			}
		}
		// 芯片卡密码数字范围check
		if(param.getLength() == 0 || param.getPrefix().length() + param.getLength() > 16){
			result.setParamErrorInfo("length");
			return SUCCESS;
		}
		param.setCompanyId(user.getCompanyId());
		// 芯片卡密码加密设置
		if(!StringUtils.isBlank(param.getPwd())){
			param.setPwd(encryptBASE64(param.getPwd()));
		}
		param.setCreateId(user.getId());
		// 新增系统参数设置
		param = parameterManager.addParam(param);

		result.setSuccessInfo();
		return SUCCESS;
	}

	public Parameter getDetailVo() {
		return detailVo;
	}

	public void setParam(Parameter param) {
		this.param = param;
	}

	public Parameter getParam() {
		return param;
	}

	public String getChkPwdFlag() {
		return chkPwdFlag;
	}

	public void setChkPwdFlag(String chkPwdFlag) {
		this.chkPwdFlag = chkPwdFlag;
	}

	private static String encryptBASE64(String key) {
        byte[] bt = key.getBytes();
        return (new BASE64Encoder()).encodeBuffer(bt);
    }
}
