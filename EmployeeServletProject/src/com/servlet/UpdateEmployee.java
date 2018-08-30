package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;

/**
 * Servlet to update employee detail
 * 
 * @author User22
 *
 */
public class UpdateEmployee extends HttpServlet {
	EmployeeDAO dao;

	/**
	 * Class Constructor
	 */
	public UpdateEmployee() {
		super();
		dao = new EmployeeDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(req.getParameter("id")));
			employee.setFirstName(req.getParameter("firstName"));
			employee.setLastName(req.getParameter("lastName"));
			employee.setEmail(req.getParameter("email"));
			employee.setAge(Integer.parseInt(req.getParameter("age")));
			int result = dao.updateEmployee(employee);
			response.setContentType("text/html");
			if (result == 1) {
				response.getWriter().print("Details Updated Successfully");
				response.getWriter().print(
						"<br><br><a href=\"index.html\">Go To Home</a>");
			} else if (result == -1) {
				response.getWriter().print("Email Already Exist");
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