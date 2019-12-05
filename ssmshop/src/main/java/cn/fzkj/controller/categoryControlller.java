package cn.fzkj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.fzkj.pojo.Category;
import cn.fzkj.service.CategoryService;

@Controller
public class categoryControlller {

	@Resource
	private CategoryService categoryService;
	@Resource
	private HttpServletRequest request;

}
