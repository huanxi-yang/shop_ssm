package cn.fzkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import cn.fzkj.mapper.CategoryMapper;
import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.CategorySecond;
import cn.fzkj.service.CategoryService;

@Service
public class CategoryServiceimpl implements CategoryService {

	@Resource
	private CategoryMapper categoryMapper;
	
	//查询所有一级分类
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}

}
