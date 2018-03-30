/**
 * 
 */
package com.xiaolin.fish.common.utils;

import com.xiaolin.fish.common.exception.*;
import com.xiaolin.fish.common.rpc.ServiceResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author erxiao
 *
 */
public class ExceptionUtils {

	public static ErrorContext createErrorContext(BaseError error) {
		return new ErrorContext(error.getErrorCode(), error.getMessage());
	}

	/**
	 * 创建异常，错误描述信息会将error的错误描述信息及参数message进行拼接作为新的错误描述信息
	 * 
	 * @param error
	 * @param message
	 * @return
	 */
	public static BizException createException(BaseError error, String message) {
		String errorMassage = error.getMessage();
		if (!StringUtil.isBlank(message)) {
			errorMassage = errorMassage + " " + message;
		}
		ErrorContext context = new ErrorContext(error, errorMassage);
		return new BizException(context);
	}

	/**
	 * 错误描述信息会将error的错误描述信息及参数message进行拼接作为新的错误描述信息
	 * 
	 * @param errorCode
	 * @param message
	 */
	public static void throwException(BaseError errorCode, String message) {
		throw createException(errorCode, message);
	}

	public static BizException createException(ErrorCode errorCode, String message) {
		ErrorContext context = new ErrorContext(errorCode, message);
		return new BizException(context);
	}

	public static void throwException(ErrorCode errorCode, String message) {
		throw createException(errorCode, message);
	}

	public static <T> ServiceResponse<T> createCommonExceptionServiceResponse(Throwable e, ErrorCode unkonwnException) {
		if (e instanceof BizException) {
			BizException bizException = (BizException) e;
			return new ServiceResponse<T>(bizException.getErrorContext(), null);
		} else {
			ErrorContext errorContext = new ErrorContext(unkonwnException, CommonErrorCode.UNKONWN.getMessage());
			return new ServiceResponse<T>(errorContext, null);
		}
	}

	public static String getStackTraceMessage(Throwable exception) {
		if (exception == null) {
			return null;
		}
		String failMessage = null;
		try {
			ByteArrayOutputStream buf = new ByteArrayOutputStream();
			exception.printStackTrace(new java.io.PrintWriter(buf, true));
			failMessage = buf.toString();
			buf.close();
		} catch (IOException e1) {
			failMessage = exception.getMessage();
		}
		return failMessage;
	}
}
