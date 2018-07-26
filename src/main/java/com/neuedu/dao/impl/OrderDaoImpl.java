package com.neuedu.dao.impl;

import com.neuedu.dao.OrderDao;
import com.neuedu.data.DataSource;
import com.neuedu.entity.UserOrder;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

	
	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		return DataSource.orders.add(userOrder);
		
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return DataSource.orders.size()+1;
	}

	@Override
	public List<UserOrder> findOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
