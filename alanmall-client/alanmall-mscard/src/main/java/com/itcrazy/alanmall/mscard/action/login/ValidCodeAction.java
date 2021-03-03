package com.itcrazy.alanmall.mscard.action.login;

import com.itcrazy.alanmall.mscard.action.base.InterfaceBaseAction;
import com.itcrazy.alanmall.mscard.session.SessionData;
import com.itcrazy.alanmall.common.client.util.LoginImageValidCode;
import com.itcrazy.alanmall.common.client.util.RandomNumUtil;
import lombok.Data;

import java.io.ByteArrayInputStream;

@Data
public class ValidCodeAction extends InterfaceBaseAction {

	private static final long serialVersionUID = -9027018496105458419L;

	private ByteArrayInputStream inputStream;
	private String sid;
	public String getRandomNum() {
		String code = RandomNumUtil.getNumber(4);

		SessionData.setAuthCode(getRequest(),getResponse(),code);
		ByteArrayInputStream image = LoginImageValidCode.getRandomImgInputStream(code);
		this.setInputStream(image);
		return SUCCESS;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public String getSid() {
		return sid;
	}

}
