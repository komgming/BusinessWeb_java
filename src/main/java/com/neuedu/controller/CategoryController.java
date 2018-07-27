package com.neuedu.controller;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CategoryService;
import com.neuedu.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/category")
public class CategoryController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1888592765797676905L;
        
	CategoryService  cs=new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		String operation=request.getParameter("operation");
		
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				//���
				addCategory(request,response);
				jump(request,response);
			}else if(operation.equals("2")) {
				//��ѯ
				findAll(request,response);
				jump(request,response);
			}else if(operation.equals("3")) {
				//�޸�
				updateCategory(request,response);
				jump(request,response);
			}else if(operation.equals("4")) {
				//ɾ��
				deleteCategory(request,response);
				jump(request,response);
			}else if(operation.equals("5")) {
				//��ѯ������Ʒ
				findCategoryById(request,response);
			}
		}else {
						
		} 
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	
	 
	
	 
	
	 /*
		 * ������
		 * */
	public  boolean addCategory(Category category) {
    	return cs.addCategory(category);
    }	
		
	 private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int parent_id = Integer.parseInt(request.getParameter("parent_id"));
			System.out.println(parent_id);
			String name = request.getParameter("name");
			int status = Integer.parseInt(request.getParameter("status"));
			int sort_order = Integer.parseInt(request.getParameter("sort_order"));
			
			
			
			Category category = new Category(parent_id,name,status,sort_order);
			boolean result = addCategory(category);
			if(result) {
				System.out.println("������ɹ�");
				
			}else {
				System.out.println("������ʧ��");
			}
		}
	
	 
	 
	 
	//�鿴
	 public void findAll(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
			System.out.println("=================");
			List<Category> categorys = cs.findAll();
			request.setAttribute("categorys", categorys);
			request.getRequestDispatcher("findCategory.jsp").forward(request, respose);
			
		}

	 
	 
	 
	 
	 boolean updateCategory(Category category) {
			return cs.updateCategory(category);
			
		}
		
		private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int id = Integer.parseInt(request.getParameter("id"));
			int parent_id = Integer.parseInt(request.getParameter("parent_id"));
			
			String name = request.getParameter("name");
			int status = Integer.parseInt(request.getParameter("status"));
			int sort_order = Integer.parseInt(request.getParameter("sort_order"));
			
			
			Category category = findCategoryById(id);
			 category = new Category(id,parent_id,name,status,sort_order);
			boolean result = updateCategory(category);
			if(result) {
				System.out.println("�޸����ɹ�");
				
			}else {
				System.out.println("�޸����ʧ��");
			}
		}

	
	public Category findCategoryById(int id) {
			return cs.findCategoryById(id);
			
	}
	private void findCategoryById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category category =findCategoryById(id);
		
		request.setAttribute("category", category);
		request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
		
	}

	boolean deleteCategory(int id) {
		return cs.deleteCategory(id);
		
	}
	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id = 0;
	double price = 0.0;
	boolean result = false;
	try {
		id = Integer.parseInt(request.getParameter("id"));
				
		result = deleteCategory(id);
	}catch(NumberFormatException e) {
		e.printStackTrace();
	}
	if(result) {
		System.out.println("ɾ�����ɹ�");
		
		
	}else {
		System.out.println("ɾ�����ʧ��");
	}
	
}
	  
	public void jump(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cgs = new CategoryServiceImpl();
		
		PageModel<Category> pageModel = cgs.findCategoryByPage(1, 4);	
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("findCategory.jsp").forward(request, response);
		
		
	}
	  
	  
	  
}
