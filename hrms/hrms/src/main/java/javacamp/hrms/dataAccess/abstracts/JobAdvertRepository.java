package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertRepository extends JpaRepository<JobAdvert,Integer>{

}


