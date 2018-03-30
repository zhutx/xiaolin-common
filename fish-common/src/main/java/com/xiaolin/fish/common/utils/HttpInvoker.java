package com.xiaolin.fish.common.utils;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpInvoker {

	private static CloseableHttpClient httpclient;

	private static int MAX_HTTP_CONNECTION = 1000;

	static {
		PoolingHttpClientConnectionManager poolingmgr = new PoolingHttpClientConnectionManager(30000,TimeUnit.MILLISECONDS);
		poolingmgr.setDefaultMaxPerRoute(MAX_HTTP_CONNECTION);
		poolingmgr.setMaxTotal(2 * MAX_HTTP_CONNECTION);
		httpclient = HttpClientBuilder.create().setConnectionManager(poolingmgr).build();
	}

	public static HttpInvokerResponse invokerPostForm(String invokerUrl, Map<String, String> stringBody, Map<String, byte[]> byteBody) {
		HttpPost httpost = new HttpPost(invokerUrl);
		try {
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			if (stringBody != null) {
				for (String key : stringBody.keySet()) {
					builder.addTextBody(key, stringBody.get(key), ContentType.parse("text/json; charset=utf-8"));
				}
			}
			if (byteBody != null) {
				for (String key : byteBody.keySet()) {
					builder.addBinaryBody(key, byteBody.get(key));
					builder.addPart(key, new ByteArrayBody(byteBody.get(key), key));
				}
			}
			HttpEntity entity = builder.build();
			httpost.setEntity(entity);
		} catch (Exception e) {
			return new HttpInvokerResponse(400);
		}
		return invoker(httpost, null, null);
	}

	/**
	 * 如果调用异常，{@link HttpInvokerResponse#getResponseCode()} = 0
	 * 
	 * @param invokerUrl
	 * @param requestMethod
	 * @param headerMap
	 * @param body
	 * @return
	 */
	public static HttpInvokerResponse invokerPost(String invokerUrl, Map<String, String> headerMap, Map<String, String> parametrMap, Object body) {
		HttpPost httpost = new HttpPost(invokerUrl);
		try {
			Gson gson = new Gson();
			String bodyJson = gson.toJson(body);
			StringEntity entity = new StringEntity(bodyJson, "UTF-8");
			entity.setContentType("application/json");
			entity.setContentEncoding("UTF-8");
			httpost.setEntity(entity);
		} catch (Exception e) {
			return new HttpInvokerResponse(400);
		}
		httpost.addHeader("Content-Type", "application/json;charset=UTF-8");
		return invoker(httpost, headerMap, parametrMap);
	}

	public static HttpInvokerResponse invokerGet(String invokerUrl, Map<String, String> headerMap, Map<String, String> parametrMap) {
		HttpGet httpGet = new HttpGet(invokerUrl);
		return invoker(httpGet, headerMap, parametrMap);
	}

	public static HttpInvokerResponse invokerDelete(String invokerUrl, Map<String, String> headerMap, Map<String, String> parametrMap) {
		HttpDelete httpDelete = new HttpDelete(invokerUrl);
		return invoker(httpDelete, headerMap, parametrMap);
	}

	private static HttpInvokerResponse invoker(final HttpRequestBase request, Map<String, String> headerMap, Map<String, String> parametrMap) {
		HttpInvokerResponse result = new HttpInvokerResponse();
		CloseableHttpResponse response = null;
		try {
			if (headerMap != null) {
				for (String key : headerMap.keySet()) {
					request.setHeader(key, headerMap.get(key));
				}
			}
			if (parametrMap != null) {
				for (String key : parametrMap.keySet()) {
					request.setHeader(key, parametrMap.get(key));
				}
			}
			//request.addHeader("Content-Type", "application/json; charset=utf-8");
			request.setHeader("Cache-Control", "no-cache");
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(30000).build();
			request.setConfig(requestConfig);
			response = httpclient.execute(request);
			HttpEntity responseEntity = response.getEntity();
			result.setBody(EntityUtils.toString(responseEntity, "UTF-8"));
			result.setResponseCode(response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			result.setResponseCode(0);
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
				}
			}
		}
		return result;
	}

}
