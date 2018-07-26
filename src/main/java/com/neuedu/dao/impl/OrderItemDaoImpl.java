package com.neuedu.dao.impl;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrderItem;

import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public boolean addOrderItems(List<UserOrderItem> orederItems) {
		// TODO Auto-generated method stub
		return DataSource.orderItems.addAll(orederItems);
		
	}

	@Override
	public int generateOrderItemId() {
		// TODO Auto-generated method stub
		return DataSource.orderItems.size()+1;
	}

	@Override
	public List<UserOrderItem> findOrderItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
