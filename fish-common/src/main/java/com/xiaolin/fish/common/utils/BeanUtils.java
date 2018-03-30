package com.xiaolin.fish.common.utils;

import org.apache.commons.lang.reflect.MethodUtils;
import org.dozer.DozerBeanMapper;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author erxiao 2015年12月30日
 */
public class BeanUtils {

	/**
	 * 通过Json数据格式将两个类型的对象进行相互转换
	 * 
	 * @param toClass
	 * @param srcObject
	 * @return
	 */
	public static <T> T to(Class<T> toClass, Object srcObject, JsonTypeAdapter... adapters) {
		String srcJson = JsonUtils.toJson(srcObject);
		return JsonUtils.fromJson(toClass, srcJson, adapters);
	}
	
	private static DozerBeanMapper mapp = new DozerBeanMapper();

	public static void copyProperties(Object toObject, Object srcObject) {
		try {
			mapp.map(srcObject, toObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 属性拷贝，如果属性数据类型不一样会拷贝失败。这种创建建议使用 {@link BeanUtils#to(Class, Object)}
	 * 
	 * @param toClass
	 * @param srcObject
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T copyProperties(Class<T> toClass, Object srcObject) {
		Object toObject = null;
		try {
			toObject = toClass.newInstance();
			copyProperties(toObject, srcObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) toObject;
	}
	
	public static <T> List<T> copyListProperties(Class<T> toClass, List<?> srcObjects) {
		if (srcObjects == null) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		for (Object srcObject : srcObjects) {
			list.add(copyProperties(toClass, srcObject));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static <T> T deepClone(Class<T> toClass, Object obj) {
		if (obj == null) {
			return null;
		}
		ByteArrayOutputStream byteOut = null;
		ObjectOutputStream objOut = null;
		ByteArrayInputStream byteIn = null;
		ObjectInputStream objIn = null;
		try {
			byteOut = new ByteArrayOutputStream();
			objOut = new ObjectOutputStream(byteOut);
			objOut.writeObject(obj);
			byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			objIn = new ObjectInputStream(byteIn);
			return (T) objIn.readObject();
		} catch (IOException e) {
			throw new RuntimeException("Clone Object failed in IO.", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found.", e);
		} finally {
			try {
				byteIn = null;
				byteOut = null;
				if (objOut != null)
					objOut.close();
				if (objIn != null)
					objIn.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 通过set***来设置对象属性值，如果set方法不存在或其他异常会导致属性设置识别（不会抛异常）
	 * @param target
	 * @param fieldName
	 * @param value
	 */
	public static void setProperty(Object target, String fieldName, Object value) {
		try {
			MethodUtils.invokeExactMethod(target, "set" + StringUtil.capitalize(fieldName), value);
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			
		}
	}

}