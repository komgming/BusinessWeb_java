package com.neuedu.dao.impl.jdbc;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

	ProductDao productDao=new ProductDaoImpl();
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="insert into cart(productid,productnum) values ("+cart.getProductid().getId()+","+cart.getProductNum()+")";
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
		
		
		
		
		return false;
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="delete from cart where id="+id+"";
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
		
		
		
		return false;
	}
	
	@Override 
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="update cart set productnum="+cart.getProductNum()+"where id="+cart.getId()+"";
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
		
		
		return false;
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		
	List<Cart> carts=new ArrayList<Cart>();
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="select id,productid,productnum from  cart";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			
				int productid = rs.getInt("productid");
				Product product = productDao.findById(productid);
				Cart cart = new Cart();
				cart.setProductbyid(productid);
				cart.setId(rs.getInt("id"));
				cart.setProductid(product);
				cart.setProductNum(rs.getInt("productnum"));
			 
			 
			 
			 carts.add(cart);
			 
			 
			}
			
			
			
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
		
		return carts;
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart (int id, int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="update cart set productnum="+num+" where id="+id+"";
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
		
		
		return false;
	}

	@Override
	public void clearCart() {
		// TODO Auto-generated method stub
		Connection coon = null;
		Statement st = null;
		try {
			coon = DBUtils.getConnection();
			st = coon.createStatement();
			
			String sql = "delete from cart";
			st.execute(sql);
		
		} catch (SQLException e) {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		

	}

	@Override
	public Cart getCartById(int id) {
		Connection coon = null;
		Statement st = null;
		ResultSet rs = null;
		
		Cart cart = null;
		try {
			coon = DBUtils.getConnection();
			st = coon.createStatement();
			String sql = "select * from cart";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				if(id==rs.getInt("id")) {
					cart = new Cart();
					int _id = rs.getInt("id");
					int num = rs.getInt("num");
					cart.setId(_id);
					cart.setProductNum(num);
					
				}
			}
			
			
		} catch (SQLException e) {
			try {
				DBUtils.close(coon, st, rs);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
		
		return cart;
		
		
	}

	
}