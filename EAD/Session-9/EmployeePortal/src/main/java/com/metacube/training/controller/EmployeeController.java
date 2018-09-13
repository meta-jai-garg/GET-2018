package com.metacube.training.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.metacube.training.model.Address;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.AddressService;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeSkillsService;
import com.metacube.training.service.JobDetailService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	HttpSession session;

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private EmployeeSkillsService employeeSkillService;
	@Autowired
	private JobDetailService jobDetailService;
	@Autowired
	private ProjectService projectService;

	@GetMapping("/login")
	public String login() {
		return "employee/login";
	}

	@PostMapping("/profile")
	public String profile(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, Model model) {
		Employee employee = employeeService.getEmployeeByEmail(username);
		if (employee != null) {
			if (employee.getPassword().equals(password)) {
				employeeProfileView(employee, model);
				return "/employee/profile";
			} else {
				return "redirect:login?error";
			}
		} else {
			return "redirect:login?error";
		}
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		Employee employee = (Employee) session.getAttribute("employee");
		employeeProfileView(employee, model);
		return "employee/profile";
	}

	@GetMapping("/editDetails")
	public String editDetails(Model model) {
		Employee employee = (Employee) session.getAttribute("employee");
		model.addAttribute("employee", employee);
		model.addAttribute("address",
				addressService.getByEmployeeId(employee.getEmpCode()));
		model.addAttribute("skills",
				skillService.getSkillByNameForEmployee(employee.getEmpCode()));
		return "/employee/editDetails";
	}

	@PostMapping("/editDetails")
	public String saveDetails(@ModelAttribute("employee") Employee employee,
			@ModelAttribute("address") Address address,
			@RequestParam("skillName") List<Integer> skills, Model model) {
		Employee empSession = (Employee) session.getAttribute("employee");
		employee.setEmpCode(empSession.getEmpCode());
		address.setAddressId(addressService.getByEmployeeId(
				empSession.getEmpCode()).getAddressId());
		employeeService.updateEmployee(employee);
		addressService.update(address);
		for (Integer skillCode : skills) {
			EmployeeSkills employeeSkills = new EmployeeSkills();
			employeeSkills.setSkillCode(skillCode);
			employeeSkills.setEmpCode(empSession.getEmpCode());
			employeeSkillService.createEmployeeSkills(employeeSkills);
		}
		Employee updatedEmployee = employeeService.getEmployeeById(empSession
				.getEmpCode());
		employeeProfileView(updatedEmployee, model);
		return "employee/profile";
	}

	/**
	 * helper method to create view for employee profile
	 * 
	 * @param employee
	 * @param model
	 */
	private void employeeProfileView(Employee employee, Model model) {
		List<EmployeeSkills> employeeSkills = employeeSkillService
				.getSkillsOfEmployee(employee.getEmpCode());
		List<Skill> skills = new ArrayList<Skill>();
		for (EmployeeSkills emplSkillls : employeeSkills) {
			skills.add(skillService.getSkillById(emplSkillls.getSkillCode()));
		}
		JobDetails jobDetails = jobDetailService.getByEmployeeId(employee
				.getEmpCode());
		Employee reportingManager = employeeService.getEmployeeById(jobDetails
				.getReportingManager());
		Employee teamLead = employeeService.getEmployeeById(jobDetails
				.getTeamLead());
		Project project = projectService.getProjectById(jobDetails
				.getCurrProjId());
		session.setAttribute("employee", employee);
		model.addAttribute("skills", skills);
		model.addAttribute("employee", employee);
		model.addAttribute("project", project);
		model.addAttribute("reportingManager", reportingManager.getFirstName()
				+ " " + reportingManager.getLastName());
		model.addAttribute("teamLead",
				teamLead.getFirstName() + " " + teamLead.getLastName());
		model.addAttribute("address",
				addressService.getByEmployeeId(employee.getEmpCode()));
	}

}