package com.java.curdOperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.curdOperations.entity.Employee;
import com.java.curdOperations.exception.ResourceNotFoundException;
import com.java.curdOperations.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	// get all Employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return this.employeeRepository.findAll();
	}

	// get Employee by Id
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") int empId) {
		return this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + empId));

	}

	// Create Employee
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}

	// Update Employee
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") int empId) {
		Employee existing = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + empId));
		existing.setEmpFirstName(employee.getEmpFirstName());
		existing.setEmpLastName(employee.getEmpLastName());
		existing.setJob(employee.getJob());
		existing.setManager(employee.getManager());
		existing.setHireDate(employee.getHireDate());
		existing.setSalary(employee.getSalary());
		existing.setCommission(employee.getCommission());
		existing.setDeptCode(employee.getDeptCode());
		return this.employeeRepository.save(existing);

	}

	// Delete Employee by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") int empId) {
		Employee existing = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id :" + empId));
		this.employeeRepository.delete(existing);
		return ResponseEntity.ok().build();
	}
}
