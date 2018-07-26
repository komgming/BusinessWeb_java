package com.neuedu.dao.impl.jdbc;

import com.neuedu.dao.OrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public boolean addOrderItems(List<UserOrderItem> orederItems) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			
			st=conn.createStatement();
		
		
			String sql="insert into userorderitem(order_no,user_id,productid,product_name,product_image,current_unit_price,quantity,total_price,create_time) values";
			 StringBuffer sbuffer=new StringBuffer(sql);
			 
			 for(int i=0;i<orederItems.size();i++) {
				
				 UserOrderItem userOrderItem=orederItems.get(i);
				 sbuffer.append("(");
				 
				 sbuffer.append(userOrderItem.getOrder_no()+",");
				 sbuffer.append(userOrderItem.getUser_id()+",");
				 sbuffer.append(userOrderItem.getProduct_id()+",");
				 sbuffer.append("'"+userOrderItem.getProduct_name()+"',");
				 sbuffer.append("'"+userOrderItem.getProduct_image()+"',");
				 sbuffer.append(userOrderItem.getCurrent_unit_price()+",");
				 sbuffer.append(userOrderItem.getQuantity()+",");
				 sbuffer.append(userOrderItem.getTotal_price()+",");
				 sbuffer.append("now()");
				 sbuffer.append(")");
				 
				 if(i!=orederItems.size()-1) {
					 sbuffer.append(",");
				 }
				
				 
			 }
			 
			
			
			
			System.out.println(sbuffer);
			st.execute(sbuffer.toString());
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
		
		
		
		
		
		
		
		
		return false;
	}
	public List<UserOrderItem> findOrderItem() {
		 List<UserOrderItem> items = new ArrayList<UserOrderItem>();
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
				String sql = "select * from userorderitem";
				 rs = st.executeQuery(sql);
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
	
					     int id = rs.getInt("id"); // ������ϸID
						 long order_no = rs.getLong("order_no");// �Ͷ������һ��
						 int user_id = rs.getInt("user_id");// �û�id
						 int product_id = rs.getInt("productid");// ��Ʒid
						 String product_name = rs.getString("product_name");// ��Ʒ����
						 String product_image = rs.getString("product_image");// ��ƷͼƬ
						 double current_unit_price = rs.getDouble("current_unit_price");// ���ɶ���ʱ�ļ۸�
						 int quantity = rs.getInt("quantity");// ��Ʒ����
						 double total_price = rs.getDouble("total_price"); // �ܼ�
						 long create_time = rs.getLong("create_time");// ����ʱ��
						 long update_time = rs.getLong("update_time");// ����ʱ��
					UserOrderItem item = new UserOrderItem(id,order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity,total_price,create_time,update_time);
					items.add(item);
								
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
		
			return items;

		
	}
	

	@Override
	public int generateOrderItemId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
