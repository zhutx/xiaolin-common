package com.xiaolin.fish.common.web;

import com.xiaolin.fish.common.exception.CommonErrorCode;
import com.xiaolin.fish.common.exception.ErrorContext;
import com.xiaolin.fish.common.rpc.ServiceResponse;

import java.io.Serializable;

/**
 * @author erxiao
 *
 */
public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 4890448199017522464L;

	public static final String SUCCESS_RESULT = "0";

	public static final String SUCCESS_MESSAGE = "操作成功";

	private String result = SUCCESS_RESULT;

	private String message = SUCCESS_MESSAGE;

	// 业务数据
	public T data;

	public BaseResponse() {
		super();
	}

	public BaseResponse(T data) {
		this.data = data;
	}

	public BaseResponse(ServiceResponse<T> serviceResponse) {
		if (!serviceResponse.isSuccess()) {
			ErrorContext errorContext = serviceResponse.getErrorContext();
			if (errorContext != null) {
				setResult(errorContext.getCode());
				setMessage(errorContext.getMessage());
			} else {
				setResult(CommonErrorCode.UNKONWN.getCode());
				setMessage(CommonErrorCode.UNKONWN.getMessage());
			}
		}
		this.data = serviceResponse.getData();
	}

	public BaseResponse(String resultCode, String message) {
		this.result = resultCode;
		this.message = message;
	}

	public BaseResponse(String resultCode, String message, T data) {
		this.result = resultCode;
		this.message = message;
		this.data = data;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}