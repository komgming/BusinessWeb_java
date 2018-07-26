package com.neuedu.filter;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("======����loginfilter������===");
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		String username=null;
		String password=null;
		Cookie[] cookis=_request.getCookies();
		if(cookis!=null) {
			//��ǿ��forѭ��
			for(Cookie c:cookis) {
				if(c.getName().equals("username")) {
					//�û���
					username=c.getValue();
					
					System.out.println("====cookie username="+username+c.getMaxAge());
				}
				if(c.getName().equals("password")) {
					//����
					password=c.getValue();
					System.out.println("====cookie password="+password);
					
				}
			}
		}
	
		
		if(username!=null&&password!=null&&!username.equals("")&&!password.equals("")) {
			ILoginService loginService=new LoginServiceImpl();
			
			Account acc= loginService.doLogin(username, password);
			if(acc!=null) {
				request.getRequestDispatcher("view/home.jsp").forward(request, response);
				
			}else {
				chain.doFilter(request, response);
			}
			
		}else {
			chain.doFilter(request, response);
		}
		
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
