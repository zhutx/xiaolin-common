/**
 * 
 */
package com.xiaolin.fish.common.exception.v1;

import com.xiaolin.fish.common.exception.BaseError;

/**
 * @author erxiao 2017年4月10日
 */
public class V1Error extends BaseError {

	public V1Error(ErrorType errorType, ErrorLevel errorLevel, String systemCode, String systemErrorCode, String message) {
		super(new V1ErrorCode(errorType, errorLevel, systemCode, systemErrorCode), message);
	}
	
	public V1Error(ErrorType errorType, ErrorLevel errorLevel, String systemCode, String systemErrorCode) {
		super(new V1ErrorCode(errorType, errorLevel, systemCode, systemErrorCode));
	}

}
