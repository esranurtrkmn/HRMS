package javacamp.hrms.dataAccess.abstracts;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.JobAdvert;


public interface JobAdvertRepository extends JpaRepository<JobAdvert,Integer>{

	@Query("FROM JobAdvert WHERE status=true")
	List<JobAdvert> findByStatus();
	
	@Query("FROM JobAdvert WHERE status = true AND employer_id =:id")
	List<JobAdvert> getByStatusJobAdvertAndEmployer(int id);
	
	@Query("FROM JobAdvert WHERE status = true ORDER BY createdAt Desc")
	List<JobAdvert> findAllByOrderByCreatedAtDesc();
	
	List<JobAdvert> getByIsConfirm(boolean isConfirm);
	
	List<JobAdvert> getByIsConfirmAndStatus(boolean isConfirm, boolean status);
	
	JobAdvert getById(int id);
	
	@Modifying
	@Transactional
	@Query("update JobAdvert u set u.isConfirm=:isConfirm where u.id=:id ")
	void updateIsConfirm(boolean isConfirm, int id);
	
	
}


