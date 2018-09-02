package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enums.Status;
import com.facade.EmployeeFacade;
import com.model.Employee;

/**
 * Servlet implementation class AddUseServlet
 */
@WebServlet("/add_employee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeFacade facade;

	public AddEmployee() {
		super();
		facade = EmployeeFacade.getInstance();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		employee.setFirstName(request.getParameter("firstName"));
		employee.setLastName(request.getParameter("lastName"));
		employee.setMobile(request.getParameter("mobile"));
		employee.setDob(Date.valueOf(request.getParameter("dob")));
		employee.setEmail(request.getParameter("email"));
		employee.setPassword(request.getParameter("password"));
		employee.setOrganization(request.getParameter("organization"));
		Status status = facade.addEmployee(employee);
		if (status.equals(Status.CREATED)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", employee.getEmail());
			response.sendRedirect("Profile");
		} else if (status.equals(Status.DUPLICATE)) {
			System.out.println("duplicate");
		} else if (status.equals(Status.ERROR)) {
			System.out.println("error");
		}
	}
}