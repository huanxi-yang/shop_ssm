package cn.fzkj.mapper;

import cn.fzkj.pojo.User;

public interface UserMapper {

	/**
	 * 检验用户名是否存在
	 * @param username
	 * @return
	 */
	public User checkName(String username);

	//保存注册的用户信息到数据库
	public void insertUserInfo(User user);

	//通过code查找用户
	public User findByCode(String code);

	//修改用户状态
	public void update(User user);

	//判断用户登录
	public User checkLogin(User user);
}
