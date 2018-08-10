package com.pele.pmms.bo;

import com.pele.pmms.BasicsPojo;

/**
 * 封装分页参数
 * @author beili
 *
 */
public class PaginationParameterPojo extends BasicsPojo{
	
	public PaginationParameterPojo(){}
	
	public PaginationParameterPojo(int pageNum,int pageRowSize){
		this.pageNum = pageNum;
		this.pageRowSize = pageRowSize;
	}

	/**
	 * 分页查询参数：页码
	 */
	protected int pageNum;
	/**
	 * 分页查询参数：每页行数
	 */
	protected int pageRowSize;
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageRowSize() {
		return pageRowSize;
	}

	public void setPageRowSize(int pageRowSize) {
		this.pageRowSize = pageRowSize;
	}
	
}
