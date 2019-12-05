package cn.fzkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import cn.fzkj.mapper.ProductMapper;
import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.CategorySecond;
import cn.fzkj.pojo.product;
import cn.fzkj.service.ProductService;
import cn.fzkj.utils.PageBean;

@Service
public class ProductServiceimpl implements ProductService {

	@Resource
	private ProductMapper productMapper;
	
	//首页热门商品查询
	@Override
	public List<product> findHot() {
		return productMapper.findHot();
	}

	//首页最新商品查询
	@Override
	public List<product> findNew() {
		return productMapper.findNew();
	}

	//通过pid查找商品
	@Override
	public product findBypid(int pid) {
		return productMapper.findBypid(pid);
	}

	//通过cid查询一级分类对应的二级分类
	@Override
	public Category findBycid(int cid) {
		return productMapper.findBycid(cid);
	}

	//根据一级分类带分页的查询商品
	@Override
	public PageBean<product> findByPageCid(int cid, int page) {
		PageBean<product> pageBean = new PageBean<product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		totalCount = productMapper.findCountCid(cid);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit ==0) {
			totalPage = totalCount / limit	;
		}else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		//每页显示的数据集合
		//开始位置
		int begin = (page-1)*limit;
		List<product> list = productMapper.findByPageCid(cid,begin,limit); 
		pageBean.setList(list);
		return pageBean;
	}

	//通过csid查询对应的商品
	@Override
	public PageBean<product> findProByCsid(int csid,int page) {
		PageBean<product> pageBean = new PageBean<product>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 12;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		totalCount = productMapper.findCountCsid(csid);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit ==0) {
			totalPage = totalCount / limit	;
		}else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalpage(totalPage);
		//每页显示的数据集合
		//开始位置
		int begin = (page-1)*limit;
		List<product> list = productMapper.findByPageCsid(csid,begin,limit); 
		pageBean.setList(list);
		return pageBean;
	}

}
