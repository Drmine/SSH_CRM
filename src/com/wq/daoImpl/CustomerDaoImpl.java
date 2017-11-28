package com.wq.daoImpl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.wq.dao.CustomerDao;
import com.wq.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	/**
	 * 添加客户方法
	 */
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	/**
	 * 获取客户列表
	 */
	@SuppressWarnings("all")
	public List<Customer> getCustomerList() {
		
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}


	/**
	 * 根据ID获取某一个客户
	 */
	public Customer findOneCustomer(int custId) {

		return this.getHibernateTemplate().get(Customer.class, custId);
	}


	/**
	 * 删除一个客户
	 */
	public void delete(Customer customer) {

		this.getHibernateTemplate().delete(customer);
	}

	/**
	 * 修改一个客户
	 */
	public void update(Customer customer) {

		this.getHibernateTemplate().update(customer);
	}

}
