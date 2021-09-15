package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.Employee;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long>{

}
