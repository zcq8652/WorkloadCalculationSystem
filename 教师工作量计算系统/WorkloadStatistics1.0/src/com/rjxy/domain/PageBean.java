package com.rjxy.domain;

//分页
public class PageBean {
	
	//表示现在第几页
	private int pageNow;
	//每页显示几条记录
    private int pageSize;
    //总共有多少页  
    private int pageCount;
    //共有多少条记录 
    private int rowCount;
    
    public PageBean() {
    	pageNow = 1;
    }
    
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	@Override
	public String toString() {
		return "PageBean [pageNow=" + pageNow + ", pageSize=" + pageSize + ", pageCount=" + pageCount + ", rowCount="
				+ rowCount + "]";
	}
    
    
}

