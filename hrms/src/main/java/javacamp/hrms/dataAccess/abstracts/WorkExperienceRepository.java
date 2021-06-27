package javacamp.hrms.dataAccess.abstracts;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Integer>{

	@Query("FROM WorkExperience w ORDER BY w.endYear DESC ")
	List<WorkExperience> getByWorkExperienceCompanyNameAndEndYearDesc();
	
	WorkExperience getById(int id);
}
