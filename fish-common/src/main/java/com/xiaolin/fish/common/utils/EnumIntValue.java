/**
 * 
 */
package com.xiaolin.fish.common.utils;


/**
 * int类型的枚举对象接口，主要用于存储
 * 
 * @author erxiao 2016年3月30日
 */
public interface EnumIntValue {

	/**
	 * 返回枚举int值
	 * 
	 * @return
	 */
	public int intValue();

	/**
	 * 返回枚举code
	 * 
	 * @return
	 */
	public String code();

	/**
	 * 返回枚举描述
	 * 
	 * @return
	 */
	public String desc();

	/**
	 * 根据int类型的值获取枚举类
	 * 
	 * @param value
	 * @return
	 */
	public EnumIntValue intValueOf(int value);
	
}
