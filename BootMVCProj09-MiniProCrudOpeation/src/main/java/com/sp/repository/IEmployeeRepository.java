package com.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
