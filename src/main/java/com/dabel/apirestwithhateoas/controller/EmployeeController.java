package com.dabel.apirestwithhateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dabel.apirestwithhateoas.model.Employee;
import com.dabel.apirestwithhateoas.service.EmployeeRepresentationModelAssembler;
import com.dabel.apirestwithhateoas.service.EmployeeService;

/**
 * Rest controller class to map HTTP verbs
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	EmployeeRepresentationModelAssembler empModelAssembler;
	

	@GetMapping("/")
	public ResponseEntity<CollectionModel<EntityModel<Employee>>> getAllEmployees() {
		
		List<Employee> employees = employeeService.findAll();
		
		if(!employees.iterator().hasNext())
			return ResponseEntity.noContent().build();
		
		List<EntityModel<Employee>> listEntityModel = employees.stream()
				.map(empModelAssembler::toModel)
				.collect(Collectors.toList());
		
		CollectionModel<EntityModel<Employee>> collectionModel = CollectionModel.of(
				listEntityModel,
				linkTo(methodOn(getClass()).getAllEmployees()).withSelfRel()
		);
		
		return ResponseEntity.ok(collectionModel);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Employee>> getEmployeeById(@PathVariable int id) {
		
		Optional<Employee> checkEmployee = employeeService.findById(id);
		
		if(checkEmployee.isEmpty()) return ResponseEntity.notFound().build();
		
		Employee currentEmployee = checkEmployee.get();
		
		EntityModel<Employee> entityModel = empModelAssembler.toModel(currentEmployee);
		
		return ResponseEntity.ok(entityModel);
	}
	
	@PostMapping("/")
	public ResponseEntity<EntityModel<Employee>> saveEmployee(@RequestBody Employee employee) {
		
		Employee savedEmployee = employeeService.save(employee);
		EntityModel<Employee> entityModel = empModelAssembler.toModel(savedEmployee);
		return new ResponseEntity<EntityModel<Employee>>(entityModel, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
		Optional<Employee> checkEmployee = employeeService.findById(id);
		
		if(checkEmployee.isEmpty()) return ResponseEntity.notFound().build();
				
		//update employee id to be replaced content
		employee.setId(checkEmployee.get().getId());
		employeeService.save(employee);
		
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		
		Optional<Employee> checkEmployee = employeeService.findById(id);
		
		if(checkEmployee.isEmpty()) return ResponseEntity.notFound().build();
				
		employeeService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
