package cn.fzkj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.product;
import cn.fzkj.service.CategoryService;
import cn.fzkj.service.ProductService;

@Controller
public class IndexController {

	@Resource
	private CategoryService categoryService;
	@Resource
	private HttpServletRequest request;
	@Resource
	private ProductService productService;
	
	//首页访问
	@RequestMapping("/toIndex.action")
	public String toIndex() {
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
	
	//跳转到注册页面
	@RequestMapping("/toRegistPage.action")
	public String toRegistPage() {
		return "regist";
	}
	
	//跳转到登录页面
	@RequestMapping("/toLoginPage.action")
	public String toLoginPage() {
		return "login";
	}
}
