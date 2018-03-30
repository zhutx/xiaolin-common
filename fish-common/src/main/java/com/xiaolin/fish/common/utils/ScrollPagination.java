/**
 * 
 */
package com.xiaolin.fish.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 滑动分页对象，用于移动端下拉查看更多列表的情况
 * 
 * @author erxiao 2017年3月1日
 */
public class ScrollPagination<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2004219573526753363L;

	/*** 默认每页显示数目 */
	public static final int DEF_COUNT = 20;

	/*** 开始查询的时间挫时间点，查询时建议:create > timestamp */
	private long timestamp;

	/** 每次拉取的个数 */
	private int pageSize = DEF_COUNT;

	/** 是否已经结束，简单的根据data.size < pageSize来判断 */
	private boolean isEnd;

	private List<T> data;

	public ScrollPagination() {
	}

	public ScrollPagination(List<T> data) {
		this.data = data;
		refreshIsEnd();
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isEnd() {
		return isEnd;
	}

	private void refreshIsEnd() {
		if (this.data == null || this.data.size() < pageSize) {
			this.isEnd = true;
		} else {
			this.isEnd = false;
		}
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
		refreshIsEnd();
	}

}
