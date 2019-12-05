package cn.fzkj.mapper;

import java.util.List;

import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.CategorySecond;

//一级分类
public interface CategoryMapper {

	//查询所有一级分类
	public List<Category> findAll();
	
}
