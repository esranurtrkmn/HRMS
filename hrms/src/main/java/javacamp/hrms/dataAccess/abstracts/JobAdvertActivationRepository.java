package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobAdvertActivation;

public interface JobAdvertActivationRepository extends JpaRepository<JobAdvertActivation,Integer>{

	
	JobAdvertActivation getByJobActId(int jobActId);
}
