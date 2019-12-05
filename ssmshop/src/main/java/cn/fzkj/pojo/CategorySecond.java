package cn.fzkj.pojo;

import java.io.Serializable;
import java.util.List;

//二级分类实体
public class CategorySecond implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2717634187797571433L;
	private Integer csid;
	private String csname;
	private Integer cid;	//一级分类id
	
	private Category category;//一级分类对象
	
	private List<product> productList;//商品的集合列表

	public List<product> getProductList() {
		return productList;
	}


	public void setProductList(List<product> productList) {
		this.productList = productList;
	}


	public Integer getCsid() {
		return csid;
	}


	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", cid=" + cid + "]";
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
}
