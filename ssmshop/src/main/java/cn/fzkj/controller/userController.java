package cn.fzkj.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.User;
import cn.fzkj.pojo.product;
import cn.fzkj.service.CategoryService;
import cn.fzkj.service.ProductService;
import cn.fzkj.service.UserService;

@Controller
public class userController {
	
	private User user;
	@Resource	
	private UserService userService ;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ProductService productService;
	
	@Resource
	private HttpServletResponse response;
	
	@Resource
	private HttpServletRequest request;

	//用户注册时的用户名是否存在检测
	@ResponseBody
	@RequestMapping("/checkUserName.action")
	public void checkUserName(String username) throws IOException {
		User user = userService.checkUserName(username);
		response.setContentType("text/html;charset=utf-8");
		if(user != null) {
			response.getWriter().println("用户名已经存在");
		}else {
			response.getWriter().println("用户名可以使用");
		}
	}
	
	//保存用户的注册信息
	@RequestMapping("/regist.action")
	public String regist(User user) throws IOException {
		//保存用户信息
		/**
		 * 把注册页面填的用户信息保存一份赋值给我申明的对象中，其它方法中就可以调用了（不专业）
		 */
		this.user=user;
		//判断验证码是否正确
		//1.获取输入的验证码
		String checkcode = request.getParameter("checkcode");
		//获取session中的验证码
		String checkcode1 = (String)request.getSession().getAttribute("checkcode");
		//2.与生成的验证码比较
		if(checkcode1.equalsIgnoreCase(checkcode)) {
			//允许注册
			userService.insertUserInfo(user);
			request.setAttribute("successinfo", "注册成功，去邮箱激活");
			return "msg";
		}else {
			//注册失败的提示信息
			/**
			 * 这句话导致跳转到regist页面中文乱码，而且这句话输出不出来
			 */
//			response.getWriter().println("alert('验证码错误');");
			request.setAttribute("codeerror", "验证码错误。直接在regist页面显示不出来，能力有限，出此下策。将在2秒后自动跳转");
			return "msg";
		}
		
	}
	
	//激活操作
	@RequestMapping("/user_Active.action")
	public String userActive(String code) {
		System.out.println("userActive:"+user);
		//通过code找到用户，若存在，说明可以激活，则修改state的值
		
		//这一句也能获取url中的参数
//		String code=request.getParameter("code");
		
		User user1=userService.findByCode(code);
		if(user1!=null) {
			//修改用户的state状态
			user1.setState(1);
			userService.update(user1);
			request.setAttribute("successinfo", "激活成功,前往登录");
		}
		else {
			request.setAttribute("failinfo", "激活失败");
		}
		return "msg";
	}
	
	//用户登录
	@RequestMapping("/login.action")
	public String login(User user){
		
		//判断用户账号密码以及状态码
		User returnuser = userService.checkLogin(user);
		if(returnuser!=null) {
			//允许登录
			if(returnuser.getState()==0) {
				request.setAttribute("loginerror", "去激活去!");
				return "msg";
			}else {
				System.out.println("登陆成功");
				//把用户信息保存到session中
				request.getSession().setAttribute("user", returnuser);
				return "index";
			}
		}else {
			//回显错误信息
			request.setAttribute("loginerror2", "账号或密码错误,请重试!");
			System.out.println("登陆失败");
			return "msg";
		}
	}
	
	//退出登录
	@RequestMapping("/toexit.action")
	public String toexit() {
		//销毁session
		request.getSession().invalidate();
		
		/**
		 * 销毁session之后，index.jsp中的商品没有了
		 * 重新查一下
		 */
		//初始化一级分类菜单
		List<Category> cList = categoryService.findAll();
		request.getSession().setAttribute("cList", cList);
		
		//查询热门商品
		List<product> hotList = productService.findHot();
		request.getSession().setAttribute("hotList", hotList);
		
		//查询最新商品
		List<product> newList = productService.findNew();
		request.getSession().setAttribute("newList", newList);
		
		return "index";
	}
	
	@RequestMapping("/findPassWord.action")
	public String findPassWord() {
		return "findPassWord";
	}
	
}
