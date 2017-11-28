package com.wq.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wq.entity.User;
import com.wq.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	/**
	 * 用户登录的方法
	 * @return 登录是否成功
	 */
	public String login() {
		User userExist = userService.login(user);
		//判断用户是否存在
		if(userExist != null) {
			//如果用户存在，则把用户放到 session中去，保持登录状态
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("loginUser", userExist);
			//返回登录成功
			return "loginSuccess";
		}else {
			//返回登录失败
			return "loginFail";
		}
		
	}


	
}
