package com.dabel.apirestwithhateoas.service;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.dabel.apirestwithhateoas.controller.EmployeeController;
import com.dabel.apirestwithhateoas.model.Employee;

@Service
public class EmployeeRepresentationModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

	@Override
	public EntityModel<Employee> toModel(Employee employee) {
		// TODO Auto-generated method stub
		
		EntityModel<Employee> entityModel = EntityModel.of(
				employee,
				linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getId())).withSelfRel().withTitle("reading"),
				linkTo(methodOn(EmployeeController.class).updateEmployee(employee.getId(), employee)).withSelfRel().withTitle("updating"),
				linkTo(methodOn(EmployeeController.class).deleteEmployee(employee.getId())).withSelfRel().withTitle("deleting"),
				linkTo(methodOn(EmployeeController.class).getAllEmployees()).withRel("employees")
		);
				
		return entityModel;
	}

}
