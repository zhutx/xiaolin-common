package com.xiaolin.fish.common.exception;

import com.xiaolin.fish.common.rpc.RequestContext;

import java.io.Serializable;

/**
 * 应用业务错误上下文
 * 
 * @author erxiao
 *
 */
public class ErrorContext implements ErrorCode, Serializable {

	private static final long serialVersionUID = 2572160403288468999L;

	private ErrorContext cause;

	private String errorCode;

	// 业务错误文案
	private String errorMessage;
	
	// 错误详情，主要包括异常信息
	private String errorDetails;
	
	private RequestContext requestContext;
	
	public ErrorContext() {
	}

	public ErrorContext(ErrorCode errorCode) {
		this(null, errorCode, null);
	}

	public ErrorContext(ErrorCode errorCode, String errorMessage) {
		this(null, errorCode, errorMessage);
	}

	public ErrorContext(ErrorContext causeErrorConent, ErrorCode errorCode) {
		this(causeErrorConent, errorCode, null);
	}

	public ErrorContext(ErrorContext causeErrorConent, ErrorCode errorCode, String errorMessage) {
		this.errorCode = errorCode.getCode();
		this.errorMessage = errorMessage;
		this.cause = causeErrorConent;
	}
	
	public ErrorContext(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	@Override
	public String getCode() {
		return this.errorCode;
	}

	public String getMessage() {
		return this.errorMessage;
	}

	public ErrorContext getCause() {
		return cause;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}

	/**
	 * 比较错误内容的错误码是否匹配。如果errorContext中无错误码，则返回false
	 * 
	 * @param ec
	 * @return
	 */
	public boolean equalsErrorCode(ErrorCode ec) {
		if (ec == null || errorCode == null) {
			return false;
		}
		return ec.getCode().equals(errorCode);
	}

}
