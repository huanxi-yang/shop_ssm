package cn.fzkj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.fzkj.mapper.UserMapper;
import cn.fzkj.pojo.User;
import cn.fzkj.service.UserService;
import cn.fzkj.utils.MailUtils;
import cn.fzkj.utils.UUIDUtils;

@Service
public class UserServiceimpl implements UserService {

	@Resource
	private UserMapper userMapper ;
	
	//检验用户名是否存在
	@Override
	public User checkUserName(String username) {
		User user = userMapper.checkName(username);
		return user;
	}
	
	//保存用户的注册信息
	@Override
	public void insertUserInfo(User user) {
		user.setState(0);	//0：用户未激活  1:用户已经激活
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		userMapper.insertUserInfo(user);
		
		//发送邮件
		MailUtils.sendMail(user.getEmail(), code);
	}

	//通过code查找用户
	@Override
	public User findByCode(String code) {
		
		return userMapper.findByCode(code);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	//用户登录判断
	@Override
	public User checkLogin(User user) {
		User returnuser = userMapper.checkLogin(user);
		return returnuser;
	}
}
