package com.dabel.apirestwithhateoas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Simple POJO to represent an employee in the 
 * employees entity of the database
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
@Data
@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName, lastName, salary;
}
