/**
 * 
 */
package com.xiaolin.fish.common.rpc;

import java.io.Serializable;

/**
 * 请求上下文，主要包括请求id、请求来源、请求执行者
 * @author erxiao 2017年9月27日
 */
public class RequestContext implements Serializable {
	
	private static final long serialVersionUID = 2219990510112822917L;

	private String requestId;

	private String consumerHost;
	
	private String providerHost;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getConsumerHost() {
		return consumerHost;
	}

	public void setConsumerHost(String consumeHost) {
		this.consumerHost = consumeHost;
	}

	public String getProviderHost() {
		return providerHost;
	}

	public void setProviderHost(String providerHost) {
		this.providerHost = providerHost;
	}
	
}
