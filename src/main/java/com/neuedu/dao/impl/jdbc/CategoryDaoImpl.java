package com.neuedu.dao.impl.jdbc;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoryDaoImpl implements CategoryDao {
    
	//���
	@Override
	public boolean addCategory(Category category) {
		//temp1 ��������
				Connection coon = null;
				PreparedStatement st = null;
				
			
				try {
					System.out.println("�����������");
					coon = DBUtils.getConnection();
		
					String sql ="insert into category(parent_id,name,status,sort_order,create_time,update_time)values(?,?,?,?,now(),now())";
					System.out.println(sql);
					st = coon.prepareStatement(sql);
					st.setInt(1, category.getParent_id());
					st.setString(2, category.getName());
					st.setInt(3, category.getStatus());
					st.setInt(4, category.getSort_order());
					
							
					st.execute();
					System.out.println("Sql���ִ����ϣ�");
					return true;
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

			
		return false;
	}
	
	//�鿴
		@Override
	public List<Category> findAll() {
		 List<Category> categorys = new ArrayList<Category>();
			Connection coon = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			//temp1��������
			try {
				
				System.out.println("�����������");
				//temp2��ȡ����
				coon = DBUtils.getConnection();
				//temp3��ȡstatement
				String sql = "select * from category";
				st = coon.prepareStatement(sql);
				
				 rs = st.executeQuery();
				 System.out.println("sql���ִ�����");
				 while(rs.next()) {
					 	int   id = rs.getInt("id");
						int  parent_id = rs.getInt("parent_id");   
						String name = rs.getString("name");
						int status = rs.getInt("status"); 	//���״̬
						int sort_order = rs.getInt("sort_order");   //������
						String create_time = rs.getString("create_time");
						String update_time = rs.getString("update_time");
					
						Category category = new Category(id,parent_id,name,status,sort_order,create_time,update_time);
						categorys.add(category);
						
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
		
			return categorys;
		
	}
		//�޸�
		@Override
		public boolean updateCategory(Category category) {
			Connection coon = null;
			PreparedStatement st = null;
			try {
				coon = DBUtils.getConnection();
			
				
				String sql = "update category set parent_id=?,name=?,status=?,sort_order=?,create_time=now(),update_time=now() where id=? ";
				
				st = coon.prepareStatement(sql);
				st.setInt(1,category.getParent_id() );
				st.setString(2, category.getName());
				st.setInt(3,category.getStatus() );
				st.setInt(4,category.getSort_order());
				
				st.setInt(5, category.getId());
				
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

		
    //ɾ��
	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="delete from category where id=?";
			st=conn.prepareStatement(sql);
			//ռλ����ֵ
			
			st.setInt(1, id);
			System.out.println(sql);
			st.execute();
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

	
        //����id	
	   @Override
	   public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category=null;
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select id,name,status,sort_order,create_time,update_time from  category where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			
			if(rs.first()) {
				category=new Category();
				 int  _id= rs.getInt("id");	
				 String  name=rs.getString("name");
                 int status=rs.getInt("status");
                 int sort_order=rs.getInt("sort_order");
                 String  create_time=rs.getString("create_time");
                 String  update_time=rs.getString("update_time");
				 
				 category.setId(_id);
				 category.setName(name);
				 category.setStatus(status);
				 category.setSort_order(sort_order);
				 category.setCreate_time(create_time);
				 category.setUpdate_time(update_time);
			}
			
			
			
			return category;
			
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
		return null;
	}
	   
	   
     //��ҳ
	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageModel<Category> pageModel=new PageModel<Category>();
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select id,parent_id,name,status,sort_order,create_time,update_time from  Category limit ?,?";
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			List<Category> categorys=new ArrayList<Category>();
			while(rs.next()) {
				
			
				Category category=new Category();
				 int  _id= rs.getInt("id");	
				 int  parent_id= rs.getInt("parent_id");	
				 String  name=rs.getString("name");
				 int  status= rs.getInt("status");
				 int  sort_order= rs.getInt("sort_order");
				 String  create_time=rs.getString("create_time");
				 String  update_time=rs.getString("update_time");
				 
				 
				 category.setId(_id);
				 category.setParent_id(parent_id);
				 category.setName(name);
				 category.setStatus(status);
				 category.setSort_order(sort_order);
				 category.setCreate_time(create_time);
				 category.setUpdate_time(update_time);
                 
                 categorys.add(category) ;
                 pageModel.setData(categorys);
			}
			
			
			pageModel.setCurrentPage(pageNo);
			
			//��ȡ�ܼ�¼��
			String  totalcount_sql="select count(id) from product";
			st=conn.prepareStatement(totalcount_sql);
			 rs=st.executeQuery();
			if(rs.first()) {
				int totalCount=rs.getInt(1);
				int totalPage= ((totalCount%pageSize)==0)?totalCount/pageSize:(totalCount/pageSize)+1;
				pageModel.setTotalPage(totalPage);
			}
			
			
			return pageModel;
			
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
		return null;
	}

}
