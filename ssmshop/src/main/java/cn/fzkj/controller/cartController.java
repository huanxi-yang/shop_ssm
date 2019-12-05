package cn.fzkj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fzkj.pojo.Cart;
import cn.fzkj.pojo.CartItem;
import cn.fzkj.pojo.User;
import cn.fzkj.pojo.product;
import cn.fzkj.service.ProductService;

/***
 * 购物车的控制层
 * @author AnotherOne
 *
 */
@Controller
public class cartController {
	
	@Resource
	private ProductService proService;
	@Resource
	private HttpServletRequest request;
	
	@RequestMapping("/addCart.action")
	public String addCart(int pid,int count) {
		
		//首先应该判断用户是否登录了，如果没有登录应先跳转到登录页面
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			return "login";
		}
		/**
		 * 封装一个CartItem对象
		 * 		1.设置count
		 * 		2.查询商品，通过pid
		 * 		3.设置商品
		 */
		CartItem cartItem = new CartItem();
		cartItem.setCount(count);
		//查询商品
		product pro = proService.findBypid(pid);
		cartItem.setPro(pro);
		//将购物项添加到购物车
		//购物车应该从session中获得
		Cart cart = getCart();
		cart.addCart(cartItem);
		
		return "cart";
	}
	
	//清空购物车
	@RequestMapping("/clearCart.action")
	public String clearCart() {
		Cart cart = getCart();
		cart.clearCart();
		return "cart";
	}
	
	//移除商品
	@RequestMapping("/removeCart.action")
	public String removeCart(int pid) {
		Cart cart = getCart();
		cart.removeCart(pid);
		return "cart";
	}

	//跳转到购物车页面
	@RequestMapping("/myCart.action")
	public String myCart() {
		return "cart";
	}
	
	/**
	 * 从session中获得购物车对象
	 * @return
	 */
	private Cart getCart() {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			//cart不存在，new一个存到session中
			cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		return cart;
	}
}
