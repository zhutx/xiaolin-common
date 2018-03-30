package com.xiaolin.fish.common.consts;

import com.xiaolin.fish.common.utils.EnumIntValue;


/**
 * Created by wuyb on 2016/9/18.
 */
public enum Sex implements EnumIntValue {
	
	UNKNOWN(0, "未知"),

	MALE(1, "男"),

	FEMALE(2, "女"), ;


	private int value;

	private String desc;

	Sex(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	@Override
	public int intValue() {
		return this.value;
	}

	@Override
	public String code() {
		return this.name();
	}

	@Override
	public String desc() {
		return this.desc;
	}

	@Override
	public EnumIntValue intValueOf(int value) {
		for (Sex type : values()) {
			if (value == type.intValue()) {
				return type;
			}
		}
		throw new IllegalArgumentException("No enum constant int value " + this.getClass().getName() + "." + value);
	}
}