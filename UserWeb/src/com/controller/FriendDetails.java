package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facade.EmployeeFacade;
import com.model.Employee;

/**
 * Servlet implementation class FriendDetails
 */
@WebServlet("/friend_details")
public class FriendDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeFacade facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FriendDetails() {
		super();
		facade = EmployeeFacade.getInstance();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loggerName = (String) session.getAttribute("loggerName");
		Employee employee = facade.getEmployee(request.getParameter("email"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Profile</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p align='right' style='font-family: verdana;'>Welcome, <img src='default.png' align='center' height='5%' style='border-radius:50%;border: 1px solid black;margin-left:10px; margin-right:20px;'>"
				+ loggerName
				+ "<span><a href='logout' style='margin-left: 20px; text-decoration: none;'>Log Out</a></span></p>");
		out.print("<hr>");
		out.println("<center><h2>Employee Details!!</h2>");
		out.println("<table cellspacing='20px'>");
		out.println("<tr>");
		out.println("<td><b>First Name</b></td>");
		out.println("<td><span>" + employee.getFirstName() + "</span></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Last Name</b></td>");
		out.println("<td><span>" + employee.getLastName() + "</span></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><b>Date of Birth</b></td>");
		out.println("<td><span>" + employee.getDob() + "</span></td>");
		out.println("</tr>");
		out.println("<td><b>Age</b></td>");
		out.println("<td><span>" + employee.getAge() + "</span></td>");
		out.println("</tr>");
		out.println("<td><b>Email</b></td>");
		out.println("<td><span>" + employee.getEmail() + "</span></td>");
		out.println("</tr>");
		out.println("</tr>");
		out.println("<td><b>Organization</b></td>");
		out.println("<td><span>" + employee.getOrganization() + "</span></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
