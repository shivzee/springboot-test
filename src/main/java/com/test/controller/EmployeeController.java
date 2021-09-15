package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/employee-details/{id}", produces = "application/json")
	public ResponseEntity<Employee> getEmployee(@PathVariable(name="id") long id) {
		log.info("Fetching employee details for employee ID {}", id);
		Employee emp = employeeService.getEmployee(id);
		
		if (emp == null) {
			log.info("Employee details not found for employee ID {}", id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		log.info("Employee details found for employee ID {}", id);
		return new ResponseEntity<>(emp,HttpStatus.OK);

	}
	@GetMapping(value = "/employee-details", produces = "application/json")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		log.info("Fetching employee details for all employees");
		List<Employee> empList = employeeService.getAllEmployees();
		
		if (empList == null || empList.isEmpty()) {
			log.info("Emaployees data is not available ");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		log.info("Employee details found.");
		return new ResponseEntity<>(empList,HttpStatus.OK);

	}
	@PostMapping("/employee")
	  public ResponseEntity<Employee> createTutorial(@RequestBody Employee employee) {
	    try {
	    	log.info("Saving details of Employee");
	    	Employee emp=employeeService.save(employee);
	    	log.info("Employeed details save with id {}", emp.getId());
	    	  return new ResponseEntity<>(emp, HttpStatus.CREATED);
	    } catch (Exception e) {
	    	log.error("Exception occurred while saving the employee {}",e.getMessage());
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
