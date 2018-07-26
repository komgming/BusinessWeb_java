package com.neuedu.controller;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


/**
 * ��������û��û���������
 * ע��
 * */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2127867611341493332L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ILoginService  loginService=new LoginServiceImpl();
		 
	
		
		
		String  username=request.getParameter("username");
		String password=request.getParameter("password");
		Account acc= loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		if(acc!=null) {
			//��¼�ɹ�
			Cookie cookie=new Cookie("username",username);
			cookie.setMaxAge(7*24*3600);
			response.addCookie(cookie);
			Cookie pwd_cookie=new Cookie("password", MD5Utils.GetMD5Code(password));
			pwd_cookie.setMaxAge(7*24*3600);
			response.addCookie(pwd_cookie);
			
			//����token����ŵ����ݿ���
		    long time=System.currentTimeMillis();
		    String token=MD5Utils.GetMD5Code(username+password+time);
		     //��ŵ����ݿ���
			loginService.addToken(token, acc);
			//�ŵ��Ự��
			HttpSession session=request.getSession();
			session.setAttribute("token", token);
			session.setAttribute("acc", acc);
		
			request.getRequestDispatcher("view/home.jsp").forward(request, response);
		}else {
			//��¼ʧ��
			request.getRequestDispatcher("fail.jsp").forward(request, response);
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}


}
