package cn.fzkj.pojo;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车的封装
 * @author AnotherOne
 *
 */
public class Cart {

	//购物项的集合
	/**
	 * LinkedHashMap:有序
	 * HashMap：无序
	 */
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	//总计
	private double total;	
	
	public double getTotal() {
		return total;
	}
	
	//功能
	/**
	 * 1.添加至购物车
	 * 2.从购物车移除
	 * 3.清空购物车
	 */
	
	//添加至购物车
	public void addCart(CartItem cartItem) {
		//判断购物车中是否存在该购物项
		/**
		 * eg:存在
		 * 		数量加1
		 * 		总计 = 总计 + 小计
		 * eg:不存在
		 * 		向map中添加该购物项
		 * 		总计 = 总计 + 小计
		 */
		//获得商品的pid
		int pid = cartItem.getPro().getPid();
		//判断map中是否存在该商品
		if(map.containsKey(pid)) {
			//存在
			//获得购物车中原来的购物项
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else {
			//不存在
			map.put(pid, cartItem);
		}
		//设置总计
		total += cartItem.getSubtotal();
	}
	
	//从购物车移除商品
	public void removeCart(int pid) {
		CartItem cartItem = map.remove(pid);
		//总计减去移除的商品的小计
		total -= cartItem.getSubtotal();
	}
	
	//清空购物车
	public void clearCart() {
		map.clear();
		//总计设为0
		total = 0;
	}
	
	
}
