package cn.fzkj.pojo;

import java.io.Serializable;
import java.util.List;

//一级分类
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7832204551385196726L;
	
	private Integer cid;
	private String cname;
	
	//二级分类集合
	private List<CategorySecond> categorySecondList;
	
	public List<CategorySecond> getCategorySecondList() {
		return categorySecondList;
	}
	public void setCategorySecondList(List<CategorySecond> categorySecondList) {
		this.categorySecondList = categorySecondList;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", categorySecondList=" + categorySecondList + "]";
	}
	
}
