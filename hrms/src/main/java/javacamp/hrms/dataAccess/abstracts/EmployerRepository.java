package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Employer;

public interface EmployerRepository extends JpaRepository<Employer,Integer>{

	Employer getById(int id);
}
