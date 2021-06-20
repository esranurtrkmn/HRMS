package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceRepository extends JpaRepository<WorkPlace,Integer>{

}
