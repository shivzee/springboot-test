package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Employee;
import com.test.repository.EmployeesRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeesRepository employeeRepository;

	public Employee getEmployee(long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
	if(employee.isPresent()) {
		return employee.get();
	}
		return null;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> empList=new ArrayList<>();
		employeeRepository.findAll().forEach(empList::add);
		if(empList.isEmpty()) {
			return null;
		}
		return empList;
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
}
