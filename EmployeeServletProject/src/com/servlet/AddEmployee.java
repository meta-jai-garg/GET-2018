package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet Class to add employee
 *
 */
public class AddEmployee extends HttpServlet {
	private EmployeeDAO employeeDAO;

	/**
	 * Class Constructor
	 */
	public AddEmployee() {
		super();
		employeeDAO = new EmployeeDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Employee Object
		Employee employee = new Employee();
		try {
			employee.setFirstName(request.getParameter("firstName"));
			employee.setLastName(request.getParameter("lastName"));
			employee.setEmail(request.getParameter("email"));
			employee.setAge(Integer.parseInt(request.getParameter("age")));
			int result = employeeDAO.addEmployee(employee);
			response.setContentType("text/html");
			if (result == 1) {
				response.getWriter().print("Details Added Successfully");
				response.getWriter().print(
						"<br><br><a href=\"index.html\">Go To Home</a>");
			} else if (result == -1) {
				response.getWriter().print("Email Already Exist.");
				response.getWriter().print(
						"<br><br><a href=\"index.html\">Go To Home</a>");
			} else {
				response.getWriter().print("Error!!!");
				response.getWriter().print(
						"<br><br><a href=\"index.html\">Go To Home</a>");
			}
		} catch (Exception e) {
			response.getWriter().print("Please try after some time!!!");
		}
	}
}