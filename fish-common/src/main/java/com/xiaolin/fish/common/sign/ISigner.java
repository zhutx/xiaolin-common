package com.xiaolin.fish.common.sign;

public interface ISigner {

	public enum Encoding {
		Base64, Base32
	}

	/**
	 * 对字符串签名，使用统一的key
	 * 
	 * @param source
	 * @return
	 */
	public String signString(String source);

	/**
	 * 对字符串签名，使用统一的key
	 * 
	 * @param source
	 * @param en 结果字符串编码方式
	 * @return
	 */
	public String signString(String source, Encoding en);

	/**
	 * 对字符串签名，使用传入的key
	 * 
	 * @param source
	 * @param key
	 * @return
	 */
	public String signString(String source, String key);

	/**
	 * 对字符串签名，使用传入的key
	 * 
	 * @param source
	 * @param key
	 * @param en 结果字符串编码方式
	 * @return
	 */
	public String signString(String source, String key, Encoding en);
}