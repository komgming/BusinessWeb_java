package com.neuedu.dao.impl.jdbc;

import com.neuedu.dao.OrderDao;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		
		
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			
			st=conn.createStatement();
		
			String  sql="insert into userorder(order_no,user_id,create_time,payment)"
					+ " values ("+userOrder.getOrder_no()+","+userOrder.getUser_id()+",now(),"+userOrder.getPayment()+")";
			System.out.println(sql);
			st.execute(sql);
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		return true;
	}
	
	
	
	public List<UserOrder> findOrder() {
		 List<UserOrder> orders = new ArrayList<UserOrder>();
			Connection coon = null;
			Statement st = null;
			ResultSet rs = null;
			//temp1��������
			try {
				
				System.out.println("�����������");
				//temp2��ȡ����
				coon = DBUtils.getConnection();
				//temp3��ȡstatement
				st = coon.createStatement();
				String sql = "select * from userorder";
				 rs = st.executeQuery(sql);
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
					
					int id = rs.getInt("id");
					long order_no = rs.getLong("order_no");
					int user_id = rs.getInt("user_id");
					long create_time = rs.getLong("create_time");
					double payment = rs.getDouble("payment");
					UserOrder order = new UserOrder(id,order_no,user_id,create_time,payment);
					orders.add(order);
					
					
				 }
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				
				try {
					DBUtils.close(coon, st, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		
			return orders;
	}

	@Override
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
