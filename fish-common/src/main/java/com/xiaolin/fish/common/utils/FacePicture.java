/**
 * 
 */
package com.xiaolin.fish.common.utils;

/**
 * @author erxiao 2016年12月5日
 */
public interface FacePicture extends Picture {

	/**
	 * 获取面部在照片中的位置
	 * 
	 * @return
	 */
	public Rect getRect();
}
