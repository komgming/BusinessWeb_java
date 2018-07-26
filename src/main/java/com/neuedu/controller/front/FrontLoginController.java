package com.neuedu.controller.front;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FrontLoginController
 */
@WebServlet("/front/login.do")
public class FrontLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  username=request.getParameter("username");
		String password=request.getParameter("password");
		ILoginService loginService=new LoginServiceImpl();
		Account acc= loginService.doLogin(username, MD5Utils.GetMD5Code(password));
		
		if(acc!=null) {
			
			//�û���
			StringBuffer sbuffer=new StringBuffer("{") ;
			sbuffer.append("\"");
			sbuffer.append("username");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getUsername());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//����
			sbuffer.append("\"");
			sbuffer.append("password");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getPassword());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//ip
			sbuffer.append("\"");
			sbuffer.append("ip");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getIp());
			sbuffer.append("\"");
			sbuffer.append(",");
			
			//sex
			sbuffer.append("\"");
			sbuffer.append("sex");
			sbuffer.append("\"");
			sbuffer.append(":");
			sbuffer.append("\"");
			sbuffer.append(acc.getSex());
			sbuffer.append("\"");
			sbuffer.append("}");
			
			System.out.println(sbuffer.toString());
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
