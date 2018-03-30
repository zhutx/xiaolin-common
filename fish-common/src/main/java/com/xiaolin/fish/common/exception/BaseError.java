/**
 * 
 */
package com.xiaolin.fish.common.exception;

/**
 * @author erxiao 2017年4月10日
 */
public class BaseError implements ErrorCode {

	private ErrorCode errorCode;
	
	private String message;

	/**
	 * @param errorCode
	 */
	public BaseError(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	/**
	 * @param errorCode
	 * @param message
	 */
	public BaseError(ErrorCode errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * (non-Javadoc)
	 * @see com.xiaolin.fish.common.exception.ErrorCode#getCode()
	 */
	@Override
	public String getCode() {
		return errorCode.getCode();
	}
	
	public boolean equalsTo(ErrorCode ec) {
		return getCode().equals(ec.getCode());
	}
	
}
