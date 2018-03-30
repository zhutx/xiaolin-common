package com.xiaolin.fish.common.utils;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable {

	private static final long serialVersionUID = 7982947800346393466L;
	
	//总记录数
    private int totalCount = 0;
    
    //每页显示数目
    private int pageSize = 20;
    
    //当前页数
    private int pageNo = 1;
    
    private List<T> data;
   

	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
