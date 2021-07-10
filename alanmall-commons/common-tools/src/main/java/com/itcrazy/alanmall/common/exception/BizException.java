package com.itcrazy.alanmall.common.exception;

/**
 * 业务层异常类
 */
public class BizException extends BaseBusinessException {

    private static final long serialVersionUID = -8822375444656350515L;

    public BizException() {
        super();
    }

    public BizException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BizException(Throwable arg0) {
        super(arg0);
    }

    public BizException(String errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public BizException(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }

    public BizException(String errorCode, String message, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.message = message;
    }
}
