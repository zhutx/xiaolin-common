/**
 * 
 */
package com.xiaolin.fish.common.exception;

/**
 * RPC调用时需要抛出异常
 * 
 * @author erxiao 2017年3月3日
 */
public class RpcThrowException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4386091624472976488L;

	public RpcThrowException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public RpcThrowException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public RpcThrowException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public RpcThrowException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public RpcThrowException(Throwable arg0) {
		super(arg0);
	}
}
