package com.metacube.training.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeSkillsService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

/**
 * Welcome page controller
 */
@Controller
public class WelcomeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SkillService skillService;
	@Autowired
	private EmployeeSkillsService employeeSkillService;

	@GetMapping("/")
	public String welcome(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "login";
	}
	
	@GetMapping("/login")
	public String login(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "login";
	}

	@GetMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "search";
	}

	/*@GetMapping("/dashboard")
	public String dashboard(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin/dashboard";
		} else if (request.isUserInRole("ROLE_EMPLOYEE")) {
			return "redirect:/employee/profile";
		} else {
			return "redirect:/employee/profile";
		}
	}*/

	@PostMapping("/searchResult")
	public String searchResult(@RequestParam("type") String type, @RequestParam("input") String input, Model model) {
		if ("name".equals(type)) {
			model.addAttribute("employees", employeeService.getEmployeeByName(input));
		} else if ("skill".equals(type)) {
			Skill skill = skillService.getSkillByName(input);
			if (skill != null) {
				List<EmployeeSkills> employeeSkills = employeeSkillService.getEmployeeSkills(skill.getSkillId());
				List<Employee> employees = new ArrayList<Employee>();
				for (EmployeeSkills skills : employeeSkills) {
					employees.add(employeeService.getEmployeeById(skills.getEmpCode()));
				}
				model.addAttribute("employees", employees);
			}
		} else if ("project".equals(type)) {
			Project project = projectService.getProjectByName(input);
			if (project != null) {
				model.addAttribute("employees", employeeService.getEmployeeByProject(project.getId()));
			}
		} else {
			try {
				System.out.println(input);
				Integer totalExp = Integer.parseInt(input);
				System.out.println(totalExp);
				model.addAttribute("employees", employeeService.getEmployeeByTotalExperience(totalExp));
			} catch (NumberFormatException e) {
				return "redirect:search?error";
			}
		}
		return "searchResult";
	}
}