package com.xiaolin.fish.common.rpc;

import com.xiaolin.fish.common.exception.ErrorContext;

/**
 * @author erxiao
 *
 */
public interface Response {

	/**
	 * 业务处理是否成功
	 * 
	 * @return
	 */
	public boolean isSuccess();

	/**
	 * 获取错误内容，当业务处理失败时该接口必须返回错误内容
	 * 
	 * @return
	 */
	public ErrorContext getErrorContext();

	/**
	 * 获取业务处理结果
	 * 
	 * @return
	 */
	public <T> T getData();
}
