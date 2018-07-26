package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status.do")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�����Ự
		HttpSession session=request.getSession();
		String seesionid=session.getId();
		session.setMaxInactiveInterval(20);
		System.out.println("�ỰʧЧʱ�䣺"+session.getMaxInactiveInterval()); 
		System.out.println("�Ự="+seesionid);
		
		Object o=session.getAttribute("com/neuedu/data");
		if(o==null) {
			session.setAttribute("data", System.currentTimeMillis());
		}
		System.out.println("data="+session.getAttribute("data"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
