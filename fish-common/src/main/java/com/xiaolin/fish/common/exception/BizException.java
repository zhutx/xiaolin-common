/**
 * 
 */
package com.xiaolin.fish.common.exception;

/**
 * @author erxiao
 *
 */
public class BizException extends RpcThrowException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6343717153965726321L;

	private ErrorContext errorContext;

	public BizException() {
		super();
	}

	public BizException(ErrorContext errorContext) {
		super(errorContext.getCode() + " " + errorContext.getMessage());
		this.errorContext = errorContext;
	}

	public BizException(ErrorContext errorContext, Throwable exception) {
		super(errorContext.getCode() + " " + errorContext.getMessage() + " " + exception.getMessage(), exception);
		this.errorContext = errorContext;
	}

	public void setErrorContext(ErrorContext errorContext) {
		this.errorContext = errorContext;
	}

	/**
	 * @return the errorContext
	 */
	public ErrorContext getErrorContext() {
		return errorContext;
	}

	public String toString() {
		return errorContext.getCode() + " " + errorContext.getMessage();
	}

}
