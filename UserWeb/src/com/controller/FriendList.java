package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.EmployeeFacade;
import com.model.Employee;

/**
 * Servlet implementation class FriendList
 */
@WebServlet("/friend_list")
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeFacade facade;

	public FriendList() {
		super();
		facade = EmployeeFacade.getInstance();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String organization = (String) session.getAttribute("organization");
		List<Employee> employee = facade.getEmployee(organization, email);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head><title>Friend List</title></head><body><center><table cellspacing='20px' align='center'>");
		for (Employee emp : employee) {
			out.println("<tr><td><a href='friend_details?email="
					+ emp.getEmail() + "' style='text-decoration:none;'>"
					+ emp.getFirstName() + "</a></td></tr>");
		}
		out.println("</table></center></body></html>");
	}
}
