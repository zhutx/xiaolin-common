package com.xiaolin.fish.common.exception;

import com.xiaolin.fish.common.exception.v1.ErrorLevel;
import com.xiaolin.fish.common.exception.v1.ErrorType;
import com.xiaolin.fish.common.exception.v1.V1Error;

/**
 * 第一代版本错误码
 * 
 * @author erxiao
 *
 */
public enum CommonErrorCode implements ErrorCode {

	/** 未知错误 */
	UNKONWN(ErrorType.SYSTEM, ErrorLevel.CRITICAL, "000", "0000", "未知错误"),

	/** 无效参数异常错误 */
	ILLEGAL_ARGUMENT_EXCEPTION(ErrorType.SYSTEM, ErrorLevel.ERROR, "000", "0001", "无效参数异常错误"),

	/** 获取主键失败 **/
	IDGENERATORERROR(ErrorType.SERVICE, ErrorLevel.CRITICAL, "000", "0002", "获取主键失败"),

	/** 缓存操作超时 **/
	CACHE_TIMEOUT(ErrorType.SERVICE, ErrorLevel.ERROR, "000", "0003", "缓存操作超时"),

	/** 缓存操作异常 **/
	CACHE_EXCEPTION(ErrorType.SERVICE, ErrorLevel.ERROR, "000", "0004", "缓存操作异常"),

	NOTSUPPORT_ERROR_VERSION(ErrorType.SYSTEM, ErrorLevel.ERROR, "000", "0005", "不支持的错误版本"),
	
	TUBE_TIMEOUT(ErrorType.SYSTEM, ErrorLevel.ERROR, "000", "0006", "服务调用超时"),
	
	SERVICE_BUSY(ErrorType.SERVICE, ErrorLevel.WARN, "000", "0007", "服务繁忙，处理失败");

	private BaseError error;

	CommonErrorCode(ErrorType errorType, ErrorLevel errorLevel, String systemCode, String systemErrorCode, String message) {
		this.error = new V1Error(errorType, errorLevel, systemCode, systemErrorCode, message);
	}

	@Override
	public String getCode() {
		return this.error.getCode();
	}

	/**
	 * @return the errorMessage
	 */
	public String getMessage() {
		return error.getMessage();
	}

	public boolean equalsTo(ErrorCode ec) {
		return getCode().equals(ec.getCode());
	}

}
