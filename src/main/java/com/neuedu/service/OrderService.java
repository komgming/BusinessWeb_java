package com.neuedu.service;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;

import java.util.List;

public interface OrderService {

	/**
	 * �û��µ�
	 * */
	boolean  createOrder();
	
	List<UserOrder> findOrder();

	List<UserOrderItem> findOrderItem();
	
	/**
	 * 
	 * ���ɶ������order_no
	 * */
  long  generateOrderNo();
}
