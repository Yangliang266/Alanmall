package com.itcrazy.alanmall.common.vo;

public class Result {

	private static int CODE_SUCCESS = 0;
	private static int CODE_REPEAT_SUBMIT = 100; // 重复提交
	private static int CODE_REJECT = 200;
	private static int CODE_PARAM_ERROR = 300;
	private static int CODE_SERVER_ERROR = 500;
	private static int CODE_NOT_FIND = 404;

	private Integer code;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
		msg = SysException.getCommonConf(code);
	}

	public void setNotFind() {
		this.code = Result.CODE_NOT_FIND;
		this.msg = "不存在";
	}

	public void setNotFind(String msg) {
		this.code = Result.CODE_NOT_FIND;
		this.msg = msg;
	}

	public void setResultInfo(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void replaceMsg(String msg1) {
		if (msg != null) {
			msg = msg.replaceAll("msg1", msg1);
		}

	}

	public void setSuccessInfo() {
		this.code = Result.CODE_SUCCESS;
		this.msg = "success";
	}

	public void setRejectInfo() {
		this.code = Result.CODE_REJECT;
		this.msg = SysException.getCommonConf(Result.CODE_REJECT);
	}

	public void setParamErrorInfo(String params) {
		this.code = Result.CODE_PARAM_ERROR;
		this.msg = params + SysException.getCommonConf(Result.CODE_PARAM_ERROR);
	}

	public void setServerErrorInfo(String errorInfo) {
		this.code = Result.CODE_SERVER_ERROR;
		this.msg = SysException.getCommonConf(Result.CODE_SERVER_ERROR)
				+ errorInfo;
	}

	public void setRepeatSubmit() {
		this.code = Result.CODE_REPEAT_SUBMIT;
		this.msg = SysException.getCommonConf(Result.CODE_REPEAT_SUBMIT);
	}
}
