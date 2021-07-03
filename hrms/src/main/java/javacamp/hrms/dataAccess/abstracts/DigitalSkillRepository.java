package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.DigitalSkill;

public interface DigitalSkillRepository extends JpaRepository<DigitalSkill,Integer>{

	@Query("FROM DigitalSkill d ORDER BY d.skillName ")
	List<DigitalSkill> getAll();
	
	@Query("FROM DigitalSkill WHERE resume_id =:id")
	List<DigitalSkill> getByResumeId(int id);
	
	DigitalSkill getById(int id);
	
}
