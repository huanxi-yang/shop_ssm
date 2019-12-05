package cn.fzkj.mapper;

import java.util.List;

import cn.fzkj.pojo.Category;
import cn.fzkj.pojo.product;

public interface ProductMapper {

	//首页热门商品查询
	List<product> findHot();
	
	//首页最新商品查询
	List<product> findNew();

	//通过pid查找商品
	product findBypid(int pid);

	//通过cid查找一级分类对应的二级分类
	Category findBycid(int cid);

	//查询总的商品数量，每个一级分类下
	int findCountCid(int cid);
	
	//查询总的数量，二级分类下
	int findCountCsid(int csid);

	//每一页显示的数据集合通过cid
	List<product> findByPageCid(int cid, int begin, int limit);

	//每一页显示的数据经济和通过csid
	List<product> findByPageCsid(int csid,int begin,int limit);
	
	

}
