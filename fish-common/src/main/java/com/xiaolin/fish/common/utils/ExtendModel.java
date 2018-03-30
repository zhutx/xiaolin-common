package com.xiaolin.fish.common.utils;

import java.util.HashMap;

/**
 * 基于Map的扩展模型集合类
 * 
 * @author erxiao 2016年10月25日
 */
public class ExtendModel extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1186406607219072895L;

	public Object getObject(String key) {
		return this.get(key);
	}

	/**
	 * 不存在时返回空字符串""
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		return getString(key, "");
	}

	public String getString(String key, String defaultVal) {
		Object obj = getObject(key);
		if (obj == null) {
			return defaultVal;
		} else {
			return obj.toString();
		}
	}

	/**
	 * 不存在时返回0
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key) {
		return getInt(key, 0);
	}

	public int getInt(String key, int defaultVal) {
		Object obj = getObject(key);
		if (obj == null) {
			return defaultVal;
		}
		try {
			return new Double(obj.toString()).intValue();
		} catch (Exception e) {
			return defaultVal;
		}
	}

	/**
	 * 不存在时返回0
	 * 
	 * @param key
	 * @return
	 */
	public float getFloat(String key) {
		return getFloat(key, 0);
	}

	public float getFloat(String key, float defaultVal) {
		Object obj = getObject(key);
		if (obj == null) {
			return defaultVal;
		}
		try {
			return new Float(obj.toString()).floatValue();
		} catch (Exception e) {
			return defaultVal;
		}
	}

	/**
	 * 不存在时，默认返回false
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	public boolean getBoolean(String key, boolean defaultVal) {
		Object obj = getObject(key);
		if (obj == null) {
			return defaultVal;
		}
		try {
			return new Boolean(obj.toString()).booleanValue();
		} catch (Exception e) {
			return defaultVal;
		}
	}
}
