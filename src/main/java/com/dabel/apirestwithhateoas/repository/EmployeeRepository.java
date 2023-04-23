package com.dabel.apirestwithhateoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dabel.apirestwithhateoas.model.Employee;

/**
 * Class to make the link between the 
 * application and the database 
 * 
 * @author ABDEL-NASSER BEN ALI
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
