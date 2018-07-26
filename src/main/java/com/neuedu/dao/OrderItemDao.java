package com.neuedu.dao;

import com.neuedu.entity.UserOrderItem;

import java.util.List;

public interface OrderItemDao {

	/**
	 * �������µĶ�����ϸ��ӵ�������ϸ������
	 * */
	 boolean  addOrderItems(List<UserOrderItem> orederItems);
	
	 /**
	  * ���ɶ�����ϸid
	  * */
	 
	 int  generateOrderItemId();

	List<UserOrderItem> findOrderItem();
	 
	
}
