package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.concretes.Education;


public interface EducationRepository extends JpaRepository<Education,Integer>{
	
	Education getById(int id);
	
	@Query("FROM Education e ORDER BY e.endYear DESC")
	List<Education> getByEducationSchoolNameAndEndYearDesc();
	
	@Query("FROM Education WHERE resume_id =:id")
	List<Education> getByResumeId(int id);
	
}
