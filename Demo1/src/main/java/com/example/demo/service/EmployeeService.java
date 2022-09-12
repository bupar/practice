package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository emplRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
	 Employee savedEmployee=emplRepository.save(employee);
	 return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// Get all employee
		return emplRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		// getting the employee by id
		return emplRepository.findById(empId).get();
	}
	
	@Override
	public void deleteEmployeeById(Long empId) {
		//Deleting the employee by id
		emplRepository.deleteById(empId);
	}
	
}
