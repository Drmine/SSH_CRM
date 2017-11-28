package com.wq.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wq.dao.CustomerDao;
import com.wq.entity.Customer;

@Transactional
public class CustomerService {

	//注入dao
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	/**
	 * 添加客户方法
	 * @param customer
	 */
	public void add(Customer customer) {

		customerDao.add(customer);
	}

	/**
	 * 获取客户列表
	 * @return 客户列表
	 */
	public List<Customer> getCustomerList() {
		
		return customerDao.getCustomerList();
	}

	/**
	 * 获取某一个客户
	 * @param custId
	 * @return
	 */
	public Customer findOneCustomer(int custId) {

		return customerDao.findOneCustomer(custId);
	}

	/**
	 * 删除客户方法
	 * @param customer
	 */
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	/**
	 * 修改客户
	 * @param customer
	 */
	public void update(Customer customer) {

		customerDao.update(customer);
	}

}
