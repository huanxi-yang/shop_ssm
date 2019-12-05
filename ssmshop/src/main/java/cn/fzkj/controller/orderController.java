package cn.fzkj.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fzkj.pojo.Cart;
import cn.fzkj.pojo.CartItem;
import cn.fzkj.pojo.Order;
import cn.fzkj.pojo.OrderItem;
import cn.fzkj.pojo.User;
import cn.fzkj.service.OrderService;
import cn.fzkj.utils.PageBean;
import cn.fzkj.utils.PaymentUtil;

@Controller
public class orderController {
	
	@Resource
	private OrderService orderService;
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private HttpServletResponse response;

	Order order = new Order();
	
	//提交订单
	@RequestMapping("/toOrder.action")
	public String toOrder() {
		//1.保存数据到数据库
		//完善订单信息
		order.setOrdertime(new Date());
		order.setState(1);//1:未付款	2：待发货	3：待确认收货	4：交易完成
		//获取购物车中的信息
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart==null) {
			//返回错误信息
			
			return "msg";
		}
		order.setTotal(cart.getTotal());
		//设置订单中的订单项
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setPro(cartItem.getPro());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
			
		}
		//设置订单所属用户
		User user = (User)request.getSession().getAttribute("user");
		if(user == null) {
			//没有用户的信息，前去登录
			return "login";
		}
		order.setUser(user);
		//保存订单
		orderService.saveOrder(order);
		//保存订单项,实现不了级联保存,出此下策
		orderService.saveOrderItems(order);
		request.setAttribute("order", order);
		//提交订单之后清空购物车
		cart.clearCart();
		//重定向到findByUid.action
		return "redirect:/findByUid.action?page=1";
	}
	//查询用户的所有订单
	@RequestMapping("/findByUid.action")
	public String findByUid(Integer page) {
		User user = (User)request.getSession().getAttribute("user");
		PageBean<Order> pageBean = orderService.findByUid(user.getUid(),page);
		request.setAttribute("pageBean", pageBean);
		return "orderList";
	}
	//通过订单id查询订单，用于确认订单功能
	@RequestMapping("/findByOid.action")
	public String findByOid(int oid) {
		Order order = orderService.findByOid(oid);
		request.setAttribute("order", order);
		return "order";
	}
	//支付
	@ResponseBody
	@RequestMapping("/payOrder.action")
	public String payOrder(int oid,String addr,String phone,String name,String pd_FrpId) throws IOException {
		//修改订单
		Order currOrder = orderService.findByOid(oid);
		currOrder.setAddr(addr);
		currOrder.setName(name);
		currOrder.setPhone(phone);
		orderService.updateOrder(currOrder);
		//付款
		// 付款需要的参数:
				String p0_Cmd = "Buy"; // 业务类型:
				String p1_MerId = "10001126856";// 商户编号:
				String p2_Order = String.valueOf(oid);// 订单编号:
				String p3_Amt = "0.01"; // 付款金额:
				String p4_Cur = "CNY"; // 交易币种:
				String p5_Pid = ""; // 商品名称:
				String p6_Pcat = ""; // 商品种类:
				String p7_Pdesc = ""; // 商品描述:
				String p8_Url = "http://localhost:8080/ssmshop/callBack.action"; // 商户接收支付成功数据的地址:
				String p9_SAF = ""; // 送货地址:
				String pa_MP = ""; // 商户扩展信息:
				String pr_NeedResponse = "1"; // 应答机制:
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue); // hmac
				// 向易宝发送请求:
				StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
				sb.append("p0_Cmd=").append(p0_Cmd).append("&");
				sb.append("p1_MerId=").append(p1_MerId).append("&");
				sb.append("p2_Order=").append(p2_Order).append("&");
				sb.append("p3_Amt=").append(p3_Amt).append("&");
				sb.append("p4_Cur=").append(p4_Cur).append("&");
				sb.append("p5_Pid=").append(p5_Pid).append("&");
				sb.append("p6_Pcat=").append(p6_Pcat).append("&");
				sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				sb.append("p8_Url=").append(p8_Url).append("&");
				sb.append("p9_SAF=").append(p9_SAF).append("&");
				sb.append("pa_MP=").append(pa_MP).append("&");
				sb.append("pd_FrpId=").append(pd_FrpId).append("&");
				sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				sb.append("hmac=").append(hmac);
				
				// 重定向:向易宝出发:
				response.sendRedirect(sb.toString());
		
		return null;
	}
	
	//支付的回调函数
	// 付款成功后跳转回来的路径:
	@RequestMapping("/callBack.action")
	public String callBack(String r6_Order,String r3_Amt){
		// 修改订单的状态:
		Order currOrder = orderService.findByOid(Integer.parseInt(r6_Order));
		// 修改订单状态为2:已经付款:
		currOrder.setState(2);
		orderService.updateOrder(currOrder);
		request.setAttribute("successinfo", "成功支付编号为"+r6_Order+"的订单"+r3_Amt+"元！！");
		return "msg";
	}
	
	//跳转到微信支付
	@RequestMapping("/toWeChatPay.action")
	public String toWeChatPay() {
		return "WeChatPay";
	}
}
