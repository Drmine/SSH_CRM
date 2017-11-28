package com.wq.dao;

import java.util.List;

import com.wq.entity.Customer;

public interface CustomerDao {

	//添加客户方法
	void add(Customer customer);

	//获取客户列表
	List<Customer> getCustomerList();

	//获取某一个用户
	Customer findOneCustomer(int custId);

	//删除一个用户
	void delete(Customer customer);

	//修改一个客户
	void update(Customer customer);

}
