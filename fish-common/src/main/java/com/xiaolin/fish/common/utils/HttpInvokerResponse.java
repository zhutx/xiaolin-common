package com.xiaolin.fish.common.utils;

import java.io.Serializable;

public class HttpInvokerResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4000995823362596525L;

	private int responseCode;

	private String body;

	public HttpInvokerResponse() {

	}

	public HttpInvokerResponse(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}

	/**
	 * responseCode == 200
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		return this.responseCode == 200;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
