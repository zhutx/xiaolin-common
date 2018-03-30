package com.xiaolin.fish.common.utils;
import com.google.gson.GsonBuilder;

/**
 * @author erxiao 2016年2月26日
 */
public class JsonUtils {

	/**
	 * 将对象转换成json字符串，如果对象为null，返回{}
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		if (obj == null) {
			return "{}";
		} else {
			return new GsonBuilder().create().toJson(obj);
		}
	}

	/**
	 * 将json字符串转换成对象，如果json格式不正确，或json为空，则返回null
	 * 
	 * @param clazz
	 * @param json
	 * @param adapters
	 * @return
	 */
	public static <T> T fromJson(Class<T> clazz, String json, JsonTypeAdapter... adapters) {
		try {
			GsonBuilder builder = new GsonBuilder();
			if (adapters != null) {
				for (JsonTypeAdapter adapter : adapters) {
					builder.registerTypeAdapter(adapter.getAdapterType(), adapter);
				}
			}
			return builder.create().fromJson(json, clazz);
		} catch (Throwable e) {
			return null;
		}
	}
}