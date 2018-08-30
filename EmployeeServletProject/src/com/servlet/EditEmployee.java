package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet class to edit employee to update
 * 
 * @author User22
 *
 */
public class EditEmployee extends HttpServlet {
	EmployeeDAO employeeDAO;

	/**
	 * Class Constructor
	 */
	public EditEmployee() {
		super();
		employeeDAO = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			int empId = Integer.parseInt(req.getParameter("id"));
			Employee employee = employeeDAO.getEmployeeById(empId);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Edit Employee Details</title>");
			out.println("<script src='validate.js'></script>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center><h1>Edit Employee Details!!</h1>");
			out.println("<form action='UpdateEmployee' onsubmit='return validateForm()' method='get'>");
			out.println("<input type='hidden' value='" + empId
					+ "' name='id'/>");
			out.println("<table cellspacing='20px'>");
			out.println("<tr>");
			out.println("<td><b>First Name</b></td>");
			out.println("<td><input type='text' value='"
					+ employee.getFirstName()
					+ "'id='firstName' name='firstName'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Last Name</b></td>");
			out.println("<td><input type='text' value='"
					+ employee.getLastName()
					+ "'id='lastName' name='lastName'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Email</b></td>");
			out.println("<td><input type='text' value='" + employee.getEmail()
					+ "'id='email' name='email'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><b>Age</b></td>");
			out.println("<td><input type='number' value='" + employee.getAge()
					+ "'id='age' name='age'/></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><input type='submit' value='Save Info'/></td>");
			out.println("</tr>");
			out.println("</form>");
			out.println("</center>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().print("Please try after some time");
		}
	}
}