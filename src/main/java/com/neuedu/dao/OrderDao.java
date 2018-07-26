package com.neuedu.dao;

import com.neuedu.entity.UserOrder;

import java.util.List;

public interface OrderDao {

	/**
	 * ��������
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * ���ɶ���id
    * */
   int  generateOrderId();

List<UserOrder> findOrder();
   
	
}
