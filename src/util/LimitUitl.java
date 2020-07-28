package util;

import java.util.List;

public class LimitUitl<T> {

	private int pageIndex;//页索引
	private int pageSize;//页大小
	private int pageCount;//总数量
	private int pageTotal;//总页数
	private List<T> list;//当前页信息
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		if(pageIndex<1){
			this.pageIndex=1;
		}else if(pageIndex>pageCount){
			this.pageIndex=pageCount;
		}else{
			this.pageIndex = pageIndex;
		}
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		if(pageTotal%pageSize==0){
			pageCount=pageTotal/pageSize;
		}else{
			pageCount=pageTotal/pageSize+1;
		}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
	
}
