package javacamp.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobAdvert;
import org.springframework.data.domain.Sort;

public interface JobAdvertRepository extends JpaRepository<JobAdvert,Integer>{

	List<JobAdvert> findByStatus(boolean status, Sort sort);
	
	List<JobAdvert> getByEmployerCompanyNameAndStatus(String companyName,boolean status);
	
	JobAdvert getById(int id);
	
	
}


