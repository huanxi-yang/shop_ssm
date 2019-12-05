package cn.fzkj.service;

import cn.fzkj.pojo.Order;
import cn.fzkj.pojo.OrderItem;
import cn.fzkj.utils.PageBean;

public interface OrderService {

	//保存用户订单
	public void saveOrder(Order order);
	//保存用户的订单项
	public void saveOrderItems(Order order);
	//查找我的订单
	public PageBean<Order> findByUid(Integer uid, Integer page);
	//查找具体的订单
	public Order findByOid(int oid);
	//修改用户的订单信息
	public void updateOrder(Order currOrder);
}
