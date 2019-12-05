package cn.fzkj.mapper;

import java.util.List;

import cn.fzkj.pojo.Order;
import cn.fzkj.pojo.OrderItem;
import cn.fzkj.utils.PageBean;

public interface OrderMapper {
	//保存订单
	public void saveOrder(Order order);
	//保存订单项
	public void saveOrderItems(Order order);
	//查找我的订单
	public PageBean<Order> findByUid(Integer uid, Integer page);
	//查找用户的订单数量
	public int findCountByUid(Integer uid);
	//查找用户的订单
	public List<Order> findPageByUid(Integer uid, int begin, int limit);
	//查找订单
	public Order findByOid(int oid);
	//修改用户订单信息
	public void updateOrder(Order currOrder);
	
}
