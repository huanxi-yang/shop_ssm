package cn.fzkj.pojo;

import java.io.Serializable;

//订单项实体类
public class OrderItem implements Serializable{
	
	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", count=" + count + ", subtotal=" + subtotal + ", pro=" + pro
				+ ", order=" + order + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -1477132261184425342L;
	
	private Integer itemId;//订单项id
	private Integer count;//数量
	private double subtotal;//小计
	
	private product pro;
	private Order order;
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public product getPro() {
		return pro;
	}
	public void setPro(product pro) {
		this.pro = pro;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
