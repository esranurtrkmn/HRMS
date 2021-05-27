package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Integer>{

	
}
