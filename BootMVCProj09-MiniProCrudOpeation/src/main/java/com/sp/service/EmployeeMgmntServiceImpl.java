package com.sp.service;

import java.util.List;
import java.util.Optional;
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
		return list.stream().sorted((emp1, emp2) -> emp1.getEname().compareTo(emp2.getEname())).toList(); // sorting
																											// based on
																											// ename
	}

	@Override
	public String registerEmployee(Employee emp) {
		// Use Service
		int idVal = empRepository.save(emp).getEmpno();
		return "Employee is registered with id Value" + idVal;
	}

	@Override
	public Employee fetchEmployeeByID(int id) {
		return empRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
	}

	@Override
	public String editEmployee(Employee emp) {
		
		
		Optional<Employee> opt = empRepository.findById(emp.getEmpno());
		
		if(opt.isPresent()){
			empRepository.save(emp);
			return emp.getEmpno()+"Employee is updated";
		}
		return emp.getEmpno()+" Employee is not found for updation";
	}

	@Override
	public String deleteEmployeeById(int id) {
		
		// Delete Employee ID
		Optional<Employee> opt = empRepository.findById(id);
		if(opt.isPresent()) {
			empRepository.deleteById(id);
			return id +"EMployee is deleted";
		}
		return id +"Employee is not for deleation ";
	}

}
