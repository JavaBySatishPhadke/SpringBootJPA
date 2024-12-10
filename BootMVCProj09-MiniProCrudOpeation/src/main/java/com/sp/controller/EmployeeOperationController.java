package com.sp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		List<Employee> list = empService.showAllEmployee();
		System.out.println("Employee List : " + list);
		map.put("empList", list);
		return "show_report";
	}

}
