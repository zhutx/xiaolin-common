package com.xiaolin.fish.common.utils;

import java.io.Serializable;

/**
 * 默认格式为： left,top,width,height
 * 
 * @author erxiao 2016年2月24日
 */
public class Rect implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5758575512394319060L;

	public static final Rect EMPTY = new Rect();

	private int left;

	private int top;

	private int width;

	private int height;

	public Rect() {

	}

	public Rect(String rect) {
		if (rect != null) {
			String[] val = rect.split(",");
			if (val.length != 4) {
				throw new IllegalArgumentException(rect + " not macth rect format.");
			}
			this.left = Integer.parseInt(val[0]);
			this.top = Integer.parseInt(val[1]);
			this.width = Integer.parseInt(val[2]);
			this.height = Integer.parseInt(val[3]);
		} else {
			throw new IllegalArgumentException(rect + " not macth rect format.");
		}
	}

	/**
	 * @return the left
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	/**
	 * @return the top
	 */
	public int getTop() {
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(int top) {
		this.top = top;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public int hashCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTop()).append(getLeft()).append(getWidth()).append(getHeight());
		return sb.toString().hashCode();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Rect)) {
			return false;
		}
		Rect temp = (Rect) obj;
		return temp.getLeft() == getLeft() && temp.getTop() == getTop() && temp.getHeight() == getHeight() && temp.getWidth() == getWidth();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getLeft()).append(",").append(getTop()).append(",").append(getWidth()).append(",").append(getHeight());
		return sb.toString();
	}
}