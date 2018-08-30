package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet class to see all employee details
 * 
 * @author User22
 *
 */
public class ShowEmployees extends HttpServlet {
	private EmployeeDAO employeeDAO;

	/**
	 * Class Constructor
	 */
	public ShowEmployees() {
		super();
		employeeDAO = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> employeeData = employeeDAO.getEmployee();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (employeeData.size() == 0) {
				out.print("No employee exist");
			} else {
				out.println("<html>");
				out.println("<head><title>All Employees</title></head>");
				out.println("<body>");
				out.println("<center><h1>All Employees</h1>");
				out.println("<table align=\"center\"cellspacing=\"20px\"");
				out.println("<tr><th>ID</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Age</th></tr>");
				for (Employee employee : employeeData) {
					out.print("<tr>");
					out.println("<td>" + employee.getId() + "</td>");
					out.println("<td>" + employee.getFirstName() + "</td>");
					out.println("<td>" + employee.getLastName() + "</td>");
					out.println("<td>" + employee.getEmail() + "</td>");
					out.println("<td>" + employee.getAge() + "</td>");
					out.println("<td><a href='EditEmployee?id="
							+ employee.getId() + "'>Edit</a></td>");
					out.print("</tr>");
				}
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			response.getWriter().print("Please try after some time");
		}
	}
}
