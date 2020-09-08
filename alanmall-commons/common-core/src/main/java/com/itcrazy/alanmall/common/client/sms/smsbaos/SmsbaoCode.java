package com.itcrazy.alanmall.common.client.sms.smsbaos;

public enum SmsbaoCode {
	PASSWD_ERR(30, "密码错误"), ACC_NOT_EXISTS(40, "账号不存在"), INSUFFICIENT_FUNDS(41,
			"余额不足"), ACC_EXPIRE(42, "账号过期"), IP_LIMIT(43, "IP地址限制"), SENSITIVE_WORD(
			50, "内容含有敏感词"), INVALID_NUMBER(51, "手机号码不正确"), INVALID_INVOKE(60,
			"尚未充值,接口不可调用");

	private int code;
	private String name;

	private SmsbaoCode(int _code, String _name) {
		this.code = _code;
		this.name = _name;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public static String getName(int code) {
		for (SmsbaoCode c : SmsbaoCode.values()) {
			if (c.getCode() == code) {
				return c.name;
			}
		}
		return null;
	}
}
