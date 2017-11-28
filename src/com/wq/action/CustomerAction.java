package com.wq.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wq.entity.Customer;
import com.wq.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//注入模型
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	//注入service
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	//到添加顾客页面
	public String toAddPage() {
		return "toAddSuccess";
	}
	
	
	/**
	 * 添加客户方法
	 * @return
	 */
	public String add() {
		customerService.add(customer);
		return "addSuccess";
	}
	
	/**
	 * 获取客户列表
	 * @return
	 */
	public String getCustomerList() {
		List<Customer> customerList = customerService.getCustomerList();
		
		//结果放入到域对象
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("customerList", customerList);
		
		return "getCustomerListSuccess";
	}
	
	/**
	 * 删除客户
	 */
	public String deleteCustomer() {
		//删除操作原则：先查询，再删除
		//查询操作
		int custId = customer.getCustId();
		Customer customer = customerService.findOneCustomer(custId);
		//判断查询结果后进行删除操作
		if(customer != null) {
			customerService.delete(customer);
		}else {
			return "deleteCustomerFail";
		}
		
		return "deleteCustomerSuccess";
	}

	/**
	 * 到修改客户页面
	 */
	public String toUpdateCustomerPage() {
		/*
		 * 先根据ID查询到要修改的那个客户
		 */
		int custId = customer.getCustId();
		Customer customer = customerService.findOneCustomer(custId);
		
		//把查询到的客户信息放到域对象中，在修改页面显示出来
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("customer", customer);
		
		return "toUpdateCustomerPageSuccess";
	}
	
	/**
	 * 修改某一个客户信息
	 */
	public String updateCustomer() {
		customerService.update(customer);
		return "updateCustomerSuccess";
	}
}
