package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeServiceInterface employeeServiceInterface;
	
	@GetMapping
	public List<Employee> getEmployee(){
		
		System.out.println("Returning the employee");
		return employeeRepository.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
	
		List<Employee> listOfEmployee = employeeServiceInterface.getAllEmployee();
		return new ResponseEntity<List<Employee>>(listOfEmployee,HttpStatus.OK);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") Long empId){
		Employee emplRetrived = employeeServiceInterface.getEmployeeById(empId);
		return new ResponseEntity<Employee>(emplRetrived,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("empId") Long empId){
		
		employeeServiceInterface.deleteEmployeeById(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployeeById(Employee employee){
		Employee updatedEmployee = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
	}
}
