package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Photo;



public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	List<Photo> findByOrderById();
	
	@Query("FROM Photo WHERE resume_id =:id")
	List<Photo> getByResumeId(int id);
}
