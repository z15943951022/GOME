package util;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageSurpport<T> {
	/**
	 * 页大小
	 */
	private int pageSize;
	/**
	 * 页索引
	 */
	private int pageIndex;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 总页数
	 */
	private int pageCount;
	private List<T> dataList=new ArrayList<T>();
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		if(totalCount%pageSize==0){
			pageCount=totalCount/pageSize;
		}else{
			pageCount=totalCount/pageSize+1;
		}
		return pageCount;
	}
	
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
}
