package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dao.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet Class to search employee by name
 * 
 * @author User22
 *
 */
public class SearchEmployee extends HttpServlet {
	private EmployeeDAO dao;

	/**
	 * Class Constructor
	 */
	public SearchEmployee() {
		super();
		dao = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Employee> employeeData = dao.getEmployee(request
				.getParameter("name"));
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			if (employeeData.size() <= 0) {
				out.print("Employee Doesn't exist");
			} else {
				out.println("<html>");
				out.println("<head><title>Employees</title></head>");
				out.println("<body>");
				out.println("<center><h1>Employees</h1>");
				out.println("<table cellspacing=\"20px\"");
				out.println("<tr><th>ID</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Age</th></tr>");
				for (Employee employee : employeeData) {
					out.print("<tr>");
					out.println("<td>" + employee.getId() + "</td>");
					out.println("<td>" + employee.getFirstName() + "</td>");
					out.println("<td>" + employee.getLastName() + "</td>");
					out.println("<td>" + employee.getEmail() + "</td>");
					out.println("<td>" + employee.getAge() + "</td>");
					out.print("</tr>");
				}
				out.println("</table>");
				out.println("<br><br><a href=\"index.html\">Go To Home</a>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			response.getWriter().print("Please try after some time");
		}
	}
}