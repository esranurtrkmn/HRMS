package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
