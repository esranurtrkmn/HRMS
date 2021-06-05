package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Photo;



public interface PhotoRepository extends JpaRepository<Photo, Integer>{

	List<Photo> findByOrderById();
}
