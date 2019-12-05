package cn.fzkj.service;

import cn.fzkj.pojo.User;


public interface UserService {

	//校验用户名是否存在
	public User checkUserName(String username);
	//保存注册的用户信息
	public void insertUserInfo(User user);

	//通过code查找用户
	public User findByCode(String code);
	//修改用户的状态
	public void update(User user);
	//用户登录判断
	public User checkLogin(User user);
}
