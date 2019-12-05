package cn.fzkj.pojo;
/**
 * 封装购物项的类
 * @author AnotherOne
 *
 */
public class CartItem {

	private product pro;	//商品
	private int count;	//商品数量
	private double subtotal;	//商品小计
	public product getPro() {
		return pro;
	}
	public void setPro(product pro) {
		this.pro = pro;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	//商品小计自动获得
	public double getSubtotal() {
		return count * pro.getShop_price();
	}
	
}
