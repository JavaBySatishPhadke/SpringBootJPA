package com.sp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sp.entity.Employee;
import com.sp.service.IEmployeeMgmntService;

@Controller
public class EmployeeOperationController {

	@Autowired
	private IEmployeeMgmntService empService;

	@GetMapping("/")
	public String showHomepage() {

		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(Map<String, Object> map) {
		try {
			List<Employee> list = empService.showAllEmployee();
			System.out.println("Employee List : " + list);
			map.put("empList", list);
			return "show_report";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	@GetMapping("/register") // form loauchining for add employee operation
	public String showEmployeeRegistrationPage(@ModelAttribute("emp") Employee emp) {
		// return from page LVN
		return "employee_register";

	}

	/*
	 * @PostMapping("/register") // form Submission for add Employee Operation
	 * public String registerEmployee(Map<String, Object>
	 * map, @ModelAttribute("emp") Employee emp) {
	 * 
	 * try { // use Service String msg = empService.registerEmployee(emp);
	 * List<Employee> list = empService.showAllEmployee();
	 * 
	 * map.put("resultMsg", msg); map.put("empList", list);
	 * 
	 * // return logical view name return "show_result"; } catch (Exception e) {
	 * e.printStackTrace(); return "error"; } }
	 */

	/*
	 * @PostMapping("/register") // form Submission for add Employee Operation
	 * public String registerEmployee(Map<String, Object>
	 * map, @ModelAttribute("emp") Employee emp) {
	 * 
	 * try { // use Service String resisterData = empService.registerEmployee(emp);
	 * System.out.println("Employee adding the elemennt : " + resisterData);
	 * map.put("resultMsg", resisterData);
	 * 
	 * // return logical view name return "redirect:report"; // Post Redirect Get
	 * and reposting problem (PRG) Redirection -R } catch (Exception e) {
	 * e.printStackTrace(); return "error"; } }
	 */
	
	@PostMapping("/register") // form Submission for add Employee Operation
	public String registerEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp) {

		try {
			// use Service
			String resisterData = empService.registerEmployee(emp);
			System.out.println("Employee adding the elemennt : " + resisterData);
			attrs.addFlashAttribute("resultMsg", resisterData); //  Redirect scope attribute

			// return logical view name
			return "redirect:report"; // Post Redirect Get  and reposting problem  (PRG) Redirection -R
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/*
	 *  Edit Request Details
	 *
	 *
	 */
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no,
									@ModelAttribute("emp") Employee emp) {
		//use Service
		Employee emp1 = empService.fetchEmployeeByID(no);
		// copy emp1 object data to emp Object.
		BeanUtils.copyProperties(emp1, emp);
		
		// Logical view name - LVN
		return "employee_edit";
	}
	
	@PostMapping("/edit")
	public String updateEmployeeDetails(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {
		// use Service
		try {
			String msg = empService.editEmployee(emp);
			attrs.addFlashAttribute("resultMsg", msg);
			// retun LVN
			return "redirect:report";
		} catch (Exception e) {
			e.printStackTrace();
			attrs.addAttribute("ErrorMsg", e.getMessage());
			return "error";
		}
	}
	/*
	 * 
	 * 
	 * Delete Request Details from Employee details
	 * 
	 * 
	 * 
	 */
	
	@GetMapping("/delete")
	public String removeEmployee(@RequestParam("no") int no, Map<String, Object> map) {

		try {
			String msg = empService.deleteEmployeeById(no);

			map.put("resultMsg", msg);

			return "forward:report";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	
	
	
	
	
}
