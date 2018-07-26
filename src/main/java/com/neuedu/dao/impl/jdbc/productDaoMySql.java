package com.neuedu.dao.impl.jdbc;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productDaoMySql implements ProductDao {

	
	
	public boolean addProduct(Product product) {
		//temp1 ��������
		Connection coon = null;
		PreparedStatement st = null;
		
	
		try {
			System.out.println("�����������");
			coon = DBUtils.getConnection();
			
			String name = product.getName();
			String detail = product.getDesc();
			double price = product.getPrice();
			String image = product.getImage();
			String sql ="insert into product(name,desc,price,image,stock)values(?,?,?,?,?)";
			st = coon.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, detail);
			st.setDouble(3, price);
			st.setString(4,image);
			st.setInt(5, product.getStock());
			st.execute();
			System.out.println("Sql���ִ����ϣ�");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(coon, st);
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	//temp3��ȡstatement �������ִ�з���

		return true;
	}

	
	
	/*
	 * �鿴����=============
	 * 
	 * */
	
	
	public List<Product> findAll() {
		 List<Product> products = new ArrayList<Product>();
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1��������
			try {
				
				System.out.println("�����������");
				//temp2��ȡ����
				coon = DBUtils.getConnection();
				//temp3��ȡstatement
				String sql = "select * from product";
				st = coon.prepareStatement(sql);
				
				 rs = st.executeQuery();
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
					int id =  rs.getInt("id");
					String name = rs.getString("name");
					String detail = rs.getString("desc");
					double price = rs.getDouble("price");
					String image = rs.getString("image");
					int stock = rs.getInt("stock");
					Product product = new Product();
					product.setId(id);
					product.setName(name);
					product.setDesc(detail);
					product.setPrice(price);
					product.setImage(image);
					product.setStock(stock);
					
					products.add(product);
					
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
		
			return products;
		
	}
	
	
	
	

	/*
	 * �޸�����
	 * */
	public boolean updateProduct(Product product) {
		
		Connection coon = null;
		PreparedStatement st = null;
		try {
			coon = DBUtils.getConnection();
			
			
			String name = product.getName();
			String desc = product.getDesc();
			double price = product.getPrice();
			String image = product.getImage();
			
			
			String sql = "update product set name=?,desc=?,price=?,image=?,stock=? where id=? ";
			st = coon.prepareStatement(sql);
			st.setString(1,name );
			st.setString(2, desc);
			st.setDouble(3, price);
			st.setString(4,image);
			st.setInt(5, product.getStock());
			st.setInt(6, product.getId());
			st.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		return false;
	}

	/*
	 * ɾ������
	 * */
	public boolean deleteProduct(int id) {
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("�����������");
			coon = DBUtils.getConnection();
			
			
			String sql ="delete from product where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return false;
		
		
	}

	//ͨ��ID����
	public Product findProductById(int id) {
		
		Product product =new Product();
		Connection coon = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		//temp1��������
		try {
			
			System.out.println("�����������");
			//temp2��ȡ����
			coon = DBUtils.getConnection();
			//temp3��ȡstatement
			String sql = "select * from product where id=?";
			st = coon.prepareStatement(sql);
			st.setInt(1, id);
			
			 rs = st.executeQuery();
			 System.out.println("sql���ִ�����");
			 if(rs.first()) {
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setDesc(rs.getString("desc"));
					product.setPrice(rs.getDouble("price"));
					product.setImage(rs.getString("image"));	
					product.setStock(rs.getInt("stock"));
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
	
		return product;
	}
	//ɾ�����
	public void deletestock(Product product) {
		
		Connection coon = null;
		PreparedStatement st = null;
		try {
			System.out.println("�����������");
			coon = DBUtils.getConnection();
			String sql ="update product set stock= ? where id=? ";
			st = coon.prepareStatement(sql);
			st.setInt(1, product.getStock());
			st.setInt(2, product.getId());
			
			st.execute();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(coon, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}



	//��ҳ��ѯ
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		PageModel<Product> pageModel = new PageModel<Product>();
		
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1��������
			try {
				coon = DBUtils.getConnection();
				String sqlcount = "select count(id) from product";
				st = coon.prepareStatement(sqlcount);
				rs = st.executeQuery();
				if(rs.next()) {
					int count = rs.getInt(1);//�ܵ����ݼ�¼��
					//�����м�ҳ
					
					int totalPage = (count%pageSize)==0?count/pageSize:(count/pageSize+1);
					pageModel.setTotalPage(totalPage);
				}
				
				
				
				System.out.println("�����������");
				//temp2��ȡ����
				
				//temp3��ȡstatement
				String sql = "select * from product limit ?,? ";
				
				st = coon.prepareStatement(sql);
				st.setInt(1, (pageNo-1)*pageSize);
				st.setInt(2, pageSize); 
				rs = st.executeQuery();
				List<Product> products = new ArrayList<Product>(); 
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
					int id =  rs.getInt("id");
					String name = rs.getString("name");
					String desc = rs.getString("desc");
					double price = rs.getDouble("price");
					String image = rs.getString("image");
					int stock = rs.getInt("stock");
					Product product = new Product();
					product.setId(id);
					product.setName(name);
					product.setDesc(desc);
					product.setPrice(price);
					product.setImage(image);
					product.setStock(stock);
					
					products.add(product);
					
				 }
				pageModel.setData(products);
				pageModel.setCurrentPage(pageNo);
				
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
		
			return pageModel;
		
		
	}



	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
