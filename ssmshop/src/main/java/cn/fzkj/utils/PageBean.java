package cn.fzkj.utils;

import java.util.List;

//分页类的封装
public class PageBean<T> {

	private int page;//当前页数
	private int totalcount;//总的记录数
	private int totalpage;//总的页数
	private int limit	;//每页显示的记录数
	private List<T> list	;//每页显示的数据的集合
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
