package cn.fzkj.service;

import java.util.List;

import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.product;
import cn.fzkj.utils.PageBean;

public interface ProductService {

	//热门商品查询
	List<product> findHot();
	
	//首页上最新商品查询
	List<product> findNew();

	//通过pid查找商品
	product findBypid(int pid);

	//通过cid查找一级分类对应的二级分类
	Category findBycid(int cid);

	//根据一级分类查询商品，带分页
	PageBean<product> findByPageCid(int cid, int page);

	//通过csid查询对应的商品
	PageBean<product> findProByCsid(int csid,int page);
	
	
}
