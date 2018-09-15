package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;

@Repository
@Transactional
@SuppressWarnings({ "unchecked", "deprecation" })
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	private Session session;

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		createSession();
		Employee employee = (Employee) session.createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employeeId)).uniqueResult();
		return employee;
	}

	@Override
	public boolean resetPassword(Employee employee) {
		createSession();
		Employee resetEmployeePassword = (Employee) session.createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employee.getEmpCode())).uniqueResult();
		resetEmployeePassword.setPassword(employee.getPassword());
		return true;
	}

	@Override
	public List<Employee> getAllEmployees() {
		createSession();
		Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq("isActive", true));
		return criteria.list();
	}

	@Override
	public List<Employee> getAllEmployeesForAdmin() {
		createSession();
		Criteria criteria = session.createCriteria(Employee.class);
		return criteria.list();
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		createSession();
		Employee disableEmployee = (Employee) session.createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employee.getEmpCode())).uniqueResult();
		disableEmployee.setIsActive(false);
		session.update(disableEmployee);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		createSession();
		Employee updateEmployee = (Employee) session.createCriteria(Employee.class)
				.add(Restrictions.eq("empCode", employee.getEmpCode())).uniqueResult();
		updateEmployee.setPrimaryContact(employee.getPrimaryContact());
		updateEmployee.setSecondaryContact(employee.getSecondaryContact());
		session.update(updateEmployee);
		return true;
	}

	@Override
	public Integer createEmployee(Employee employee) {
		createSession();
		session.save(employee);
		Employee employeeForLastId = (Employee) session.createCriteria(Employee.class).addOrder(Order.desc("empCode"))
				.setMaxResults(1).uniqueResult();
		System.out.println(employeeForLastId.toString());
		Integer empCode = employeeForLastId.getEmpCode();
		return empCode;
	}

	@Override
	public List<Employee> getEmployeeByName(String input) {
		createSession();
		Criteria criteria = session.createCriteria(Employee.class);
		Criterion firstname = Restrictions.ilike("firstName", "%"+input+"%");
		Criterion lastname = Restrictions.ilike("lastName", "%"+input+"%");

		LogicalExpression orExpression = Restrictions.or(firstname, lastname);
		criteria.add(orExpression);

		return criteria.add(Restrictions.eq("isActive", true)).list();
	}

	@Override
	public List<Employee> getEmployeeByProject(Integer projectId) {
		createSession();
		List<JobDetails> empcodes = session.createCriteria(JobDetails.class)
				.add(Restrictions.eq("currProjId", projectId)).list();
		System.out.println(empcodes.toString());
		List<Employee> employees = new ArrayList<Employee>();
		for (JobDetails jobDetail : empcodes) {
			Employee employee = (Employee) session.createCriteria(Employee.class)
					.add(Restrictions.eq("empCode", jobDetail.getEmpCode())).add(Restrictions.eq("isActive", true))
					.uniqueResult();
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeeByTotalExperience(Integer totalExp) {
		createSession();
		List<JobDetails> empcodes = session.createCriteria(JobDetails.class)
				.add(Restrictions.ge("totalExp", totalExp)).list();
		List<Employee> employees = new ArrayList<Employee>();
		for (JobDetails jobDetail : empcodes) {
			Employee employee = (Employee) session.createCriteria(Employee.class)
					.add(Restrictions.eq("empCode", jobDetail.getEmpCode()))
					.add(Restrictions.eq("isActive", true)).uniqueResult();
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public Employee getEmployeeByEmail(String emailId) {
		createSession();
		Employee employee = (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("emailId", emailId))
				.uniqueResult();
		return employee;
	}

	@Override
	public boolean enableEmployee(Integer id) {
		createSession();
		Employee disableEmployee = (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("empCode", id))
				.uniqueResult();
		disableEmployee.setIsActive(true);
		session.update(disableEmployee);
		return true;
	}

	void createSession() {
		this.session = entityManager.unwrap(Session.class);
	}
}