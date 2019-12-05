package cn.fzkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.fzkj.mapper.OrderMapper;
import cn.fzkj.pojo.Order;
import cn.fzkj.service.OrderService;
import cn.fzkj.utils.PageBean;

@Transactional
@Service
public class OrderServiceimpl implements OrderService {

	@Resource
	private OrderMapper orderMapper;
	
	//保存订单
	public void saveOrder(Order order) {
		orderMapper.saveOrder(order);
	}

	//保存用户的订单项
	@Override
	public void saveOrderItems(Order order) {
		// TODO Auto-generated method stub
		orderMapper.saveOrderItems(order);
	}
	//查找我的订单
	@Override
	public PageBean<Order> findByUid(Integer uid, Integer page) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 5;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalcount = orderMapper.findCountByUid(uid);
		pageBean.setTotalcount(totalcount);
		//设置总页数
		int totalPage = 0;
		if(totalPage % limit ==0) {
			totalPage = totalcount / limit;
		}else {
			totalPage = totalcount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		//设置每页显示的数据集合
		int begin = (page-1)*limit;
		List<Order> list = orderMapper.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//查找订单
	@Override
	public Order findByOid(int oid) {
		// TODO Auto-generated method stub
		return orderMapper.findByOid(oid);
	}
	//修改用户的信息
	@Override
	public void updateOrder(Order currOrder) {
		// TODO Auto-generated method stub
		orderMapper.updateOrder(currOrder);
	}


}
