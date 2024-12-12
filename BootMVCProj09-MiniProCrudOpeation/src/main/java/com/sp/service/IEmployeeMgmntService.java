package com.sp.service;

import java.util.List;

import com.sp.entity.Employee;

public interface IEmployeeMgmntService {
	public List<Employee> showAllEmployee();
	public String registerEmployee(Employee emp);
	public Employee fetchEmployeeByID(int id);
	public String editEmployee(Employee emp);
	public String deleteEmployeeById(int id);
}
