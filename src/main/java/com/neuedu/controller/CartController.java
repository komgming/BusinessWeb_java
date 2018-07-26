package com.neuedu.controller;

import com.neuedu.entity.Cart;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/cart")
public class CartController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8574912870396136419L;
    
	  CartService cartService=new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String operation = request.getParameter("operation");
		if(operation.equals("1")) {
			//����
			addCart(request,response);
		}else if(operation.equals("2")) {
			//�鿴
			findAllCart(request,response);
		}else if(operation.equals("3")) {
			//ɾ��
			deleteCart(request,response);
		}else if(operation.equals("4")) {
			//�޸�
			updataeCart(request,response);
		}else if(operation.equals("5")) {
			//����id
			getCartById(request,response);
		}
	
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	/**
	 * ��ӹ��ﳵ
	 **/
	
	

	

	/*
	 * �޸Ĺ��ﳵ����Ʒ����
	 * */
	public boolean updataeCart(Cart cart) {

		return cartService.updataeCart(cart);
	}
	private void updataeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = 0;
		int id =0;
		try {
			
			num = Integer.parseInt(request.getParameter("num"));
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = getCartById(id);
			cart.setProductNum(num);;
			boolean result = updataeCart(cart);
			System.out.println("==============");
			if(result) {
				System.out.println("�޸ĳɹ�");
				findAllCart(request, response);
			}else {
				System.out.println("�޸�ʧ��");
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}



	/*
	 * ͨ��idѰ�ҹ��ﳵ
	 * */
	public Cart getCartById(int id) {
		
		return cartService.getCartById(id);

	}
	private void getCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			Cart cart = getCartById(id);
			if(cart!=null) {
				request.setAttribute("cart", cart);
				request.getRequestDispatcher("findByid.jsp").forward(request, response);
			}else {
				System.out.println("Fail");
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		
	}



	/*ɾ�����ﳵ*/
	public boolean deleteCart(int id) {

		return cartService.deleteCart(id);
	}
	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			result = deleteCart(id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result){
			System.out.println("ɾ�����ﳵ�ɹ�");
			findAllCart(request, response);
		}else {
			System.out.println("ʧ��");
		}

		
	}

	
	
	/*
	 * ���빺�ﳵ
	 * */
	public boolean addCart(Cart cart) {

		return cartService.addCart(cart);
	}
	private void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		int num = 0;
		boolean result = false;
		Cart cart = new Cart();
		ProductServiceImpl p = new ProductServiceImpl();
		try {
			id = Integer.parseInt(request.getParameter("id"));
			num = Integer.parseInt(request.getParameter("num"));
			Product product = p.findProductById(id);
			cart.setProductNum(num);
			cart.setProductid(product);
			result = addCart(cart);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("���빺�ﳵ�ɹ�");
			ProductServiceImpl pservlet = new ProductServiceImpl();
			findAllCart(request, response);
		}else{
			System.out.println("���빺�ﳵʧ��");
		}
		
	}
	/*
	 * JSPҳ��鿴���ﳵ��Ϣ
	 * */
	public void findAllCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=================");
		List<Cart> carts = cartService.findAllCart();
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("findcart.jsp").forward(request, response);
		
	}

	

	

	
	

}
