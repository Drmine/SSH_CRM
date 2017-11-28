package com.wq.service;

import org.springframework.transaction.annotation.Transactional;

import com.wq.dao.UserDao;
import com.wq.entity.User;

@Transactional
public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//用户登录的方法
	public User login(User user) {
		
		return userDao.login(user);
	}
	

}
