package cn.fzkj.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//订单实体类
public class Order implements Serializable{
	
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
				+ name + ", addr=" + addr + ", phone=" + phone + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3141273302150190106L;
	
	private Integer oid;    //订单id
	private double total;//总金额
	private Date ordertime;//订单时间
	private Integer state;	//订单状态
	private String name;//收货人
	private String addr;//收货地址
	private String phone;//联系电话
	
	private User user;//订单所属用户
	
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();//订单项

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
