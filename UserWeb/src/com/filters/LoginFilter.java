package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enums.Status;
import com.facade.EmployeeFacade;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login")
public class LoginFilter implements Filter{

	private ServletContext context;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		EmployeeFacade facade = EmployeeFacade.getInstance();
		Status status = facade.authenticateEmployee(email, password);
		if (status.equals(Status.OK)) {
			chain.doFilter(request, response);
		} else if (status.equals(Status.ERROR)) {
			RequestDispatcher rd = context.getRequestDispatcher("/login.html");
			out.println("<font color=red>Password is invalid.</font>");
			rd.include(request, response);
		} else if (status.equals(Status.NOT_FOUND)) {
			RequestDispatcher rd = context.getRequestDispatcher("/login.html");
			out.println("<font color=red align='center'>Employee Not Exist!  Please Register First</font>");
			rd.include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		context = fConfig.getServletContext();
	}

	public void destroy() {
	}

}
