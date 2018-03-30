package com.xiaolin.fish.common.rpc;

import com.xiaolin.fish.common.exception.BizException;
import com.xiaolin.fish.common.exception.ErrorContext;

import java.io.Serializable;

/**
 * 服务接口调用基础结构对象
 * 
 * @author erxiao
 *
 */
public class ServiceResponse<T> implements Response, Serializable {

	private static final long serialVersionUID = -5565312464113196398L;

	/**
	 * 业务请求是否处理成功
	 */
	private boolean success;

	/**
	 * 错误内容
	 */
	private ErrorContext errorContext;

	/**
	 * 业务处理结果对象
	 */
	private T data;

	/**
	 * 创建一个成功的返回结果对象，该构造方法会设置success=true、errorContext=null
	 * 
	 * @param data
	 */
	public ServiceResponse(T data) {
		this(true, null, data);
	}

	/**
	 * 创建一个异常请求结果，该构造方法会设置success=false
	 * 
	 * @param errorContext
	 * @param data
	 */
	public ServiceResponse(ErrorContext errorContext, T data) {
		this(false, errorContext, data);
	}

	/**
	 * @param errorContext
	 */
	public ServiceResponse(ErrorContext errorContext) {
		this(false, errorContext, null);
	}

	/**
	 * @param success
	 * @param errorContext
	 * @param data
	 */
	public ServiceResponse(boolean success, ErrorContext errorContext, T data) {
		this.success = success;
		this.errorContext = errorContext;
		this.data = data;
	}

	/**
	 * 创建一个成功的返回结果对象
	 * 
	 * @return
	 */
	public static <T> ServiceResponse<T> createSuccessResponse() {
		return new ServiceResponse<T>(true, null, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getData() {
		try {
			return (T) data;
		} catch (Exception e) {
			throw new RuntimeException("Get data exception.", e);
		}
	}

	/**
	 * 提前服务返回的业务数据，如果业务异常则抛出
	 * 
	 * @return
	 */
	public T pickDataThrowException() {
		if (errorContext != null) {
			throw new BizException(errorContext);
		} else {
			return getData();
		}
	}

	public boolean isSuccess() {
		return this.success;
	}

	/**
	 * 是否有效数据
	 */
	public boolean isExistData() {
		return this.data != null;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ErrorContext getErrorContext() {
		return errorContext;
	}

	public void setErrorContext(ErrorContext errorContext) {
		this.errorContext = errorContext;
	}

	public void setData(T data) {
		this.data = data;
	}

}
