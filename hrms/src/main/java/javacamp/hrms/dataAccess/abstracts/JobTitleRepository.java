package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle,Integer> {

	
	
}
