package com.xiaolin.fish.common.sign.impl;

import com.xiaolin.fish.common.sign.ISigner;
import com.xiaolin.fish.common.utils.Base32;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;

public abstract class AbstractHMacSigner implements ISigner {
	
	private static final Encoding DefaultEncoding = Encoding.Base64;

	private static final String DefaultCharset = "UTF-8";

	private static final String Base64StringCharset = "ISO-8859-1";
	
	private String uniformKey;

	protected String getUniformKey() {
		return uniformKey;
	}

	public void setUniformKey(String uniformKey) {
		this.uniformKey = uniformKey;
	}
	
	/**
	 * 获取使用统一key的Mac
	 * @return
	 */
	protected abstract Mac getMac();
	
	/**
	 * 获取传入key对应的Mac的
	 * @param key
	 * @return
	 */
	protected abstract Mac getMac(String key);
	
	private ThreadLocal<Mac> localMac = new ThreadLocal<Mac>();
	
	/**
	 * 使用统一的mac,由于使用单例，Max非线程安全，需要使用threadLocal
	 * @return
	 */
	private Mac getLocalMac() {
		Mac mac = localMac.get();
		if (mac == null) {
			mac = getMac();
			localMac.set(mac);
		}
		return mac;
	}
	

	public String signString(String source) {
		return signString(source, DefaultEncoding);
	}
	
	public String signString(String source, Encoding en) {
		Mac mac = getLocalMac();
		try {
			byte[] bs = mac.doFinal(source.getBytes(DefaultCharset));
			return en == Encoding.Base32 ? Base32.encode(bs) : new String(
					Base64.encodeBase64(bs), Base64StringCharset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

	public String signString(String source, String key) {
		return signString(source, key, DefaultEncoding);
	}
	
	public String signString(String source, String key, Encoding en) {
		Mac mac = getMac(key);
		try {
			byte[] bs = mac.doFinal(source.getBytes(DefaultCharset));
			return en == Encoding.Base32 ? Base32.encode(bs) : new String(
					Base64.encodeBase64(bs), Base64StringCharset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}