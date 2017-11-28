package com.wq.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wq.dao.UserDao;
import com.wq.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@SuppressWarnings("all")
	@Override
	public User login(User user) {
		//获取 hibernateTemplate 对象
		/*HibernateTemplate hibernateTemplate = this.getHibernateTemplate();*/
		List<User> userList = (List<User>) this.getHibernateTemplate().
		find("from User where username=? and password=?", 
				user.getUsername(),user.getPassword());
		
		if(userList != null && userList.size() > 0) {
			return userList.get(0);
		}else {
			return null;
		}
	}
	
	
	
	
	
	/*private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/

}
