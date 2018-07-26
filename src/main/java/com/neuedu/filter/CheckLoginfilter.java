package com.neuedu.filter;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class CheckLoginfilter
 */
@WebFilter("/view/*")
public class CheckLoginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLoginfilter() {
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
        
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		HttpSession session=_request.getSession();
		Object o=session.getAttribute("token");
		Object accoj=session.getAttribute("acc");
		if(o!=null&&accoj!=null) {
			String token=(String)o;
			
			ILoginService loginService=new LoginServiceImpl();
			Account acc=(Account)accoj;
			String resultToken= loginService.findTokenAccountId(acc.getAccountId());
			if(resultToken!=null) {
				if(token.equals(resultToken)) {
					
					chain.doFilter(request, response);
					System.out.println("addads");
					return;
				}
			}
		}
		
		//ҳ����ת���ض���
		_response.sendRedirect("http://localhost:8080/dianshang/login.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
