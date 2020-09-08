package com.itcrazy.alanmall.mscard.action.card;

import org.apache.dubbo.config.annotation.Reference;
import com.itcrazy.alanmall.mscard.manager.RegisteredCardManager;
import com.itcrazy.alanmall.mscard.model.RegisteredCard;
import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.util.KeyValueConvert;
import com.itcrazy.alanmall.common.client.cache.SessionCache;
import com.itcrazy.alanmall.common.client.constains.CardConstants;
import com.itcrazy.alanmall.common.client.file.SysConfig;
import com.itcrazy.alanmall.common.client.util.MD5Util;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;
import com.itcrazy.alanmall.mscard.vo.card.RegisteredCardVo;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 记名卡管理
 * @author huangchunbo
 * 2018-09-19
 */
@SuppressWarnings("restriction")
public class RegisteredCardAction extends InterfaceBaseAction{


	private static final long serialVersionUID = -6677682833908224859L;

	private RegisteredCard registeredCard;

	private String regCardNo;

	private RegisteredCardVo detailVo;
	private String editFlag;
	private String oldPwd;
	private String oldPwdConfirm;
	private String newPwd;
	private String newPwdConfirm;
	private String chkCode;
	private String telChkFlag;
	private String flag;

	@Reference
	RegisteredCardManager registeredCardManager;

	/**
	 * 根据条件判断单张发卡或编辑
	 * @return
	 */
	public String updateRegisteredCard(){
		if (registeredCard == null) {
			result.setParamErrorInfo("registeredCard");
			return SUCCESS;
		}

		if (registeredCard.getIsNamed() == 0) {
			// 是记名卡是页面数据check
			if ("add".equals(editFlag)) {
				// 姓名check
				if (registeredCard.getUserName() == null) {
					result.setParamErrorInfo("userName");
					return SUCCESS;
				}

				if (registeredCard.getIdNumber() == null) {
					result.setParamErrorInfo("idNumber");
					return SUCCESS;
					}
					// 身份证号码check
					String idRegex = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
					Pattern pi = Pattern.compile(idRegex);
					Matcher mi = pi.matcher(registeredCard.getIdNumber());
					boolean isMatcher = mi.matches();
					if (!isMatcher) {
						result.setParamErrorInfo("idNumber");
						return SUCCESS;
					}
			}
				// 手机号check
				if (registeredCard.getTelephone() == null) {
					result.setParamErrorInfo("telephone");
					return SUCCESS;
				}
				String telRegex = "^((1[358][0-9])|(14[57])|(17[0678])|(19[7]))\\d{8}$";
				Pattern p = Pattern.compile(telRegex);
		        Matcher m = p.matcher(registeredCard.getTelephone());
		        boolean isMatch = m.matches();
		        if (!isMatch) {
		        	result.setParamErrorInfo("telephone");
					return SUCCESS;
		        }
		}else if (registeredCard.getIsNamed() == 1) {
			// 非记名卡时 页面输入数据check
			if (!StringUtils.isBlank(registeredCard.getIdNumber())) {
				// 身份证号码check
				String idRegex = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
				Pattern pi = Pattern.compile(idRegex);
				Matcher mi = pi.matcher(registeredCard.getIdNumber());
				boolean isMatcher = mi.matches();
				if (!isMatcher) {
					result.setParamErrorInfo("idNumber");
					return SUCCESS;
				}
			}
			// 手机号check
			if (!StringUtils.isBlank(registeredCard.getTelephone())) {
				String telRegex = "^((1[358][0-9])|(14[57])|(17[0678])|(19[7]))\\d{8}$";
				Pattern p = Pattern.compile(telRegex);
		        Matcher m = p.matcher(registeredCard.getTelephone());
		        boolean isMatch = m.matches();
		        if (!isMatch) {
		        	result.setParamErrorInfo("telephone");
					return SUCCESS;
		        }
			}
		}

		// 邮箱check
        if(!StringUtils.isBlank(registeredCard.getMail())) {
			String mailRegex = "(^[a-z0-9]+([._\\\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$)";
			Pattern pm = Pattern.compile(mailRegex);
			Matcher mm = pm.matcher(registeredCard.getMail());
			boolean isMail = mm.matches();
			if(!isMail) {
				result.setParamErrorInfo("mail");
				return SUCCESS;
			}
        }

        // 短信验证码check
        if("1".equals(telChkFlag) && !StringUtils.isBlank(registeredCard.getTelephone())) {
        	Object objCache = SessionCache.get(CardConstants.CACHE_KEY_CARD + registeredCard.getTelephone());
            if(objCache != null) {
                //检查验证码
            	if(!StringUtils.isBlank(chkCode) && !chkCode.equals(objCache)) {
            		result.setResultInfo(1, "短信验证码不正确，请重新输入。");
        			return SUCCESS;
            	}
            }else {
            	result.setResultInfo(1, "请先发送短信验证码。");
      			return SUCCESS;
            }
        }

		// 更新的场合，原密码与新密码check
		if("edit".equals(editFlag)) {
			if(!StringUtils.isBlank(newPwd)) {
				// 原始支付密码一致性check
				if(!StringUtils.isBlank(oldPwd)) {
					if(!oldPwd.equals(oldPwdConfirm)) {
						result.setResultInfo(1, "原始密码不一致。");
						return SUCCESS;
					}
				}

				// 新支付密码一致性check
				if(!newPwd.equals(newPwdConfirm)) {
					result.setResultInfo(1, "新密码不一致。");
					return SUCCESS;
				}

				// 新支付密码与原密码不一致性check
				if(oldPwd.equals(newPwd)){
					result.setResultInfo(1, "新密码与原始密码不能相同。");
					return SUCCESS;
				}
			}
		}
		 // 密码加密
        if(!StringUtils.isBlank(registeredCard.getPayPsw())) {
        	registeredCard.setPayPsw(encryptBASE64(registeredCard.getPayPsw()));
        }

			registeredCard.setCompanyId(user.getCompanyId());
		if("add".equals(editFlag)) {
			registeredCard.setStoreTo(user.getStoreId());
			registeredCard.setCreateId(user.getId());
			registeredCard.setUpdateId(user.getId());
			registeredCard.setPublishId(user.getId());
			try {
				registeredCardManager.OperaregisteredCard(registeredCard,flag);
			} catch (Exception e) {
				e.printStackTrace();
				result.setResultInfo(1, "单张发卡失败");
				return SUCCESS;
			}

			// 调用卡管系统卡激活接口
			if("0".equals(flag)) {
				String interfaceUrl = SysConfig.getCommonConf("INTERFACE_5IMEISHI");
				String userName = SysConfig.getCommonConf("INTERFACE_USERNAME");
				String password = SysConfig.getCommonConf("INTERFACE_PASSWORD");

				String urlStr = interfaceUrl + "/erp/sendTridCardMember.action";
				Long t = System.currentTimeMillis() / 1000;
				String random = RandomNumUtil.getCharacterAndNumber(4);
				String s = MD5Util.MD5(password + random);
				String content = "<xml><MsgType><![CDATA[sendTridCardMember]]></MsgType>" +
						"<Mobile><![CDATA[" + registeredCard.getTelephone() + "]]></Mobile>" +
						"<StoreId><![CDATA[" + user.getStoreId() + "]]></StoreId>" +
						"<Code><![CDATA[" + registeredCard.getCardNo() + "]]></Code>" +
						"<CodeType><![CDATA[" + registeredCard.getCategory() + "]]></CodeType>" +
						"<MemberLevelId><![CDATA[" + registeredCard.getMemberLevelId() + "]]>" +
						"</MemberLevelId><Self>true</Self></xml>";
				String params = "username=" + userName + "&randomnum=" + random + "&timestamp=" +
						t + "&signature=" + MD5Util.MD5(s + t) + "&content=" + content;

				String retValue = ActiveAction.sendUrl(urlStr, params);
				JSONObject jObject = (JSONObject)JSONObject.fromObject(retValue).get("result");

				result.setCode((Integer)jObject.get("code"));
				result.setMsg((String)jObject.get("msg"));
			}else {
				result.setSuccessInfo();
			}

		}else {
			registeredCard.setUpdateId(user.getId());
			try {
				registeredCardManager.updateRegisteredCard(registeredCard);
			} catch (Exception e) {
				e.printStackTrace();
				result.setResultInfo(1, "更新失败");
				return SUCCESS;
			}
			result.setSuccessInfo();

		}
		return SUCCESS ;

	}

	// 编辑页面显示
	public String getRegisteredCardDetail(){
		if(regCardNo == null){
			result.setSuccessInfo();
			return SUCCESS;
		}

		RegisteredCard rc = registeredCardManager.getCardNo(regCardNo,user.getCompanyId());
		RegisteredCardVo rv = null;
		if(rc != null) {
			rv = new RegisteredCardVo();
			rv.setCardNo(rc.getCardNo());
			rv.setUserName(rc.getUserName());
			if(rc.getSex()!=null) {
				rv.setSex(KeyValueConvert.getCardSexValue(rc.getSex()));
			}else {
				rv.setSex("");
			}

			rv.setTelephone(rc.getTelephone());
			rv.setIdNumber(rc.getIdNumber());
			rv.setPayPsw(decryptBASE64(rc.getPayPsw()));
			rv.setMail(rc.getMail());
			rv.setAddress(rc.getAddress());
			rv.setBirthday(rc.getBirthday());
		}

		setDetailVo(rv);

		result.setSuccessInfo();
		return SUCCESS;


	}

	public RegisteredCard getRegisteredCard() {
		return registeredCard;
	}

	public void setRegisteredCard(RegisteredCard registeredCard) {
		this.registeredCard = registeredCard;
	}
	public String getRegCardNo() {
		return regCardNo;
	}
	public void setRegCardNo(String regCardNo) {
		this.regCardNo = regCardNo;
	}
	public RegisteredCardVo getDetailVo() {
		return detailVo;
	}
	public void setDetailVo(RegisteredCardVo rv) {
		this.detailVo = rv;
	}
	public String getEditFlag() {
		return editFlag;
	}
	public void setEditFlag(String editFlag) {
		this.editFlag = editFlag;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getOldPwdConfirm() {
		return oldPwdConfirm;
	}
	public void setOldPwdConfirm(String oldPwdConfirm) {
		this.oldPwdConfirm = oldPwdConfirm;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getNewPwdConfirm() {
		return newPwdConfirm;
	}
	public void setNewPwdConfirm(String newPwdConfirm) {
		this.newPwdConfirm = newPwdConfirm;
	}

	 public String getChkCode() {
		return chkCode;
	}

	public void setChkCode(String chkCode) {
		this.chkCode = chkCode;
	}

	/**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
	public static String encryptBASE64(String key) {
        byte[] bt = key.getBytes();
        return (new BASE64Encoder()).encodeBuffer(bt);
    }

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
	public static String decryptBASE64(String key) {
        byte[] bt;
        try {
            bt = (new BASE64Decoder()).decodeBuffer(key);
            return new String(bt, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

	public String getTelChkFlag() {
		return telChkFlag;
	}

	public void setTelChkFlag(String telChkFlag) {
		this.telChkFlag = telChkFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
