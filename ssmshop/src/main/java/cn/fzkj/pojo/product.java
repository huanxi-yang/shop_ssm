package cn.fzkj.pojo;

import java.io.Serializable;
import java.util.Date;

//商品
public class product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6796923399095542460L;

	private Integer pid;
	private String pname;
	private double market_price;	//商场价格
	private double shop_price;	//商城价格
	private String image;	//图片路径
	private String pdesc;	//描述
	private String is_hot;	//是否热门 0:不是热门 1是热门
	private Date pdate;
	
	private Integer csid;
	private CategorySecond categorySecond;//二级分类的对象

	public CategorySecond getcategorySecond() {
		return categorySecond;
	}

	public void setcategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(double market_price) {
		this.market_price = market_price;
	}

	public double getShop_price() {
		return shop_price;
	}

	public void setShop_price(double shop_price) {
		this.shop_price = shop_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(String is_hot) {
		this.is_hot = is_hot;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", image=" + image + ", pdesc=" + pdesc + ", is_hot=" + is_hot + ", pdate=" + pdate
				+ ", csid=" + csid + "]";
	}
	
}
