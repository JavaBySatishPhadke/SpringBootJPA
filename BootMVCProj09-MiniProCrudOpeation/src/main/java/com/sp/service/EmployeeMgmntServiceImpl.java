package com.sp.service;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.entity.Employee;
import com.sp.repository.IEmployeeRepository;

@Service
public class EmployeeMgmntServiceImpl implements IEmployeeMgmntService {

	@Autowired
	private IEmployeeRepository empRepository;

	@Override
	public List<Employee> showAllEmployee() {
		// return empRepository.findAll();

		List<Employee> list = StreamSupport.stream(empRepository.findAll().spliterator(), false).toList();
		// return list.stream().sorted().toList(); // perform the natural sorting
		return list.stream().sorted((emp1, emp2) -> emp1.getEname().compareTo(emp2.getEname())).toList(); // sorting based on ename
	}

}
