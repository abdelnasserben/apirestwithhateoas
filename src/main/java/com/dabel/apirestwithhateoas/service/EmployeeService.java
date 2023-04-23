package com.dabel.apirestwithhateoas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dabel.apirestwithhateoas.model.Employee;
import com.dabel.apirestwithhateoas.repository.EmployeeRepository;

/**
 * Class to apply the business and management 
 * rules of the application
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}
	
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
