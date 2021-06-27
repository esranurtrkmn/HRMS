package javacamp.hrms.dataAccess.abstracts;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.Resume;


public interface ResumeRepository extends JpaRepository<Resume, Integer>{

	Resume getById(int id);
	
	@Query("FROM Resume WHERE candidate_id =:id")
	Resume getByCandidateId(int id);
}
