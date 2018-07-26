package com.neuedu.controller;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/view/OrderServlet")
public class OrderController extends HttpServlet {
  
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4061267564791549138L;
	OrderService orderService=new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
		if(operation.equals("1")) {
			createOrder(request,response);
		}else if(operation.equals("2")) {
			findOrder(request,response);
			
		}else if(operation.equals("3")) {
			findOrderItem(request,response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
	
	
	
       //�µ�
	   public  void  createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(orderService.createOrder()) {
			System.out.println("�µ��ɹ�");
			findOrder(request,response);
		}else {
			System.out.println("�µ�ʧ��");
		}
			
		
	}
	    //����
		private void findOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<UserOrder> orders = orderService.findOrder();
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("ordershow.jsp").forward(request, response);
			
		}

		//������ϸ
		private void findOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<UserOrderItem> items = orderService.findOrderItem();
			request.setAttribute("items", items);
			request.getRequestDispatcher("orderitem.jsp").forward(request, response);
			
		}
	
	
}
