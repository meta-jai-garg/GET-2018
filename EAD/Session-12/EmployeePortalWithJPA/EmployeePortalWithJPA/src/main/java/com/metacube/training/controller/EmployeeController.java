package com.metacube.training.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Address;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.Mail;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.model.UserToken;
import com.metacube.training.service.AddressService;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeSkillsService;
import com.metacube.training.service.JobDetailService;
import com.metacube.training.service.MailService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;
import com.metacube.training.service.UserTokenService;

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
	@Autowired
	private UserTokenService userTokenService;
	@Autowired
	private MailService mailService;

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
		System.out.println(employee);
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
		address.setEmpCode(empSession.getEmpCode());
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

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "employee/forgotPassword";
	}

	@PostMapping("/forgotPassword")
	public String processForgotPasswordForm(
			@RequestParam("email") String emailId, HttpServletRequest request) {
		System.out.println(emailId);
		if (employeeService.getEmployeeByEmail(emailId) != null) {
			UserToken userToken = new UserToken();
			userToken.setEmailId(emailId);
			userToken.setResetToken(UUID.randomUUID().toString());
			userTokenService.createUserToken(userToken);

			String appUrl = request.getScheme() + "://"
					+ request.getServerName() + ":8080/";
			Mail mail = new Mail();
			mail.setFrom("jai.garg@metacube.com");
			mail.setTo(emailId);
			mail.setSubject("Password Reset Link!!!");
			mail.setContent("To reset your password, click the link below:\n"
					+ appUrl
					+ "EmployeePortalWithJPA/employee/resetPassword?token="
					+ userToken.getResetToken());
			mailService.sendSimpleMessage(mail);
			return "redirect:login?resetLink";
		} else {
			return "redirect:forgotPassword?error";
		}
	}

	@GetMapping("/resetPassword")
	public ModelAndView displayResetPasswordPage(ModelAndView model,
			@RequestParam("token") String userToken) {
		UserToken token = userTokenService.getUserTokenByUserToken(userToken);
		if (token != null) {
			model.addObject("resetToken", userToken);
			model.setViewName("employee/resetPassword");
		} else {
			model.setViewName("redirect:login?errorMessage");
		}
		return model;
	}

	@PostMapping("/resetPassword")
	public ModelAndView setNewPassword(ModelAndView model,
			@RequestParam Map<String, String> requestParams) {

		UserToken userToken = userTokenService
				.getUserTokenByUserToken(requestParams.get("token"));
		Employee employee = employeeService.getEmployeeByEmail(userToken
				.getEmailId());
		String newPass = requestParams.get("newPass");
		String confirmPass = requestParams.get("confirmPass");
		if (newPass.equals(confirmPass)) {
			employee.setPassword(newPass);
			employeeService.resetPassword(employee);
			userTokenService.deleteUserToken(userToken);
			model.setViewName("redirect:login?success");
		} else {
			model.addObject("token", userToken.getResetToken());
			model.setViewName("redirect:resetPassword?invalidPass");
		}
		return model;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(
			MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:resetPassword?invalidPass");
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