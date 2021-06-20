package javacamp.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.JobAdvert;


public interface JobAdvertRepository extends JpaRepository<JobAdvert,Integer>{

	@Query("FROM JobAdvert WHERE status=true")
	List<JobAdvert> findByStatus();
	
	@Query("FROM JobAdvert WHERE status = true AND employer_id =:id")
	List<JobAdvert> getByStatusJobAdvertAndEmployer(int id);
	
	@Query("FROM JobAdvert WHERE status = true ORDER BY createdAt Desc")
	List<JobAdvert> findAllByOrderByCreatedAtDesc();
	
	JobAdvert getById(int id);
	
	
}


