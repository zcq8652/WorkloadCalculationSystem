package com.rjxy.domain;

//��ҳ
public class PageBean {
	
	//��ʾ���ڵڼ�ҳ
	private int pageNow;
	//ÿҳ��ʾ������¼
    private int pageSize;
    //�ܹ��ж���ҳ  
    private int pageCount;
    //���ж�������¼ 
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

