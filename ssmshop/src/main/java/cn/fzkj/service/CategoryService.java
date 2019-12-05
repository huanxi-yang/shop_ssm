package cn.fzkj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.fzkj.pojo.Category;

public interface CategoryService {

	//查询所有的一级分类
	public List<Category> findAll();

}
