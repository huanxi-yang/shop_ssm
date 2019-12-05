package cn.fzkj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.fzkj.pojo.product;
import cn.fzkj.service.ProductService;
import cn.fzkj.utils.PageBean;

@Controller
public class productContrller {

	@Resource
	private ProductService productService;
	
	@Resource
	private HttpServletRequest request;
	
	//查询具体的商品
	@RequestMapping("/findBypid.action")
	public ModelAndView findBypid(int pid) {
		//根据pid查询对应的商品
		product pro = productService.findBypid(pid);
		return new ModelAndView("product","product",pro);
	}
	
	//通过cid查询一级分类和所属的二级分类
	@RequestMapping("/findBycid.action")
	public String findBycid(int cid,int page) {
		//用于productList.jsp中页面跳转的cid获取
		request.getSession().setAttribute("cid", cid);
		//根据一级分类查询商品，带分页的查询
		PageBean<product> pageBean = productService.findByPageCid(cid,page);
		request.getSession().setAttribute("productList", pageBean);
		return "productList";
	}
	
	/**
	 * 点击左侧的二级分类要在右边显示对应的商品，
	 * 有一个问题就是之前通过一级分类查询商品的时候有过一个ModelAndView，现在不知道怎么显示在页面中
	 * 可以存到request域
	 * 两个方法的返回值不一样，所以会报错，List<product> 中没有list属性，但是在jsp页面中使用jstl表达式获取了
	 * 可以直接使用上面的findBycid方法查找出来，觉得可行
	 * 
	 * 解决的办法：
	 * 跟上面的通过cid查询商品相同，唯一不一样的就是参数传csid和page，返回值这些都一样
	 * @param csid
	 * @return
	 */
	//通过csid查询对应的商品
	@RequestMapping("/findProByCsid.action")
	public String findProByCsid(int csid,int page) {
		request.getSession().setAttribute("csid", csid);
		PageBean<product> proList = productService.findProByCsid(csid,page);
		request.setAttribute("productList", proList);
		return "productList";
	}
}
