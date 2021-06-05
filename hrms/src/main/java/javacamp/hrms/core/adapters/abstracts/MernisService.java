package javacamp.hrms.core.adapters.abstracts;



import javacamp.hrms.entities.concretes.Candidate;

public interface MernisService {

	boolean CheckIfRealPerson(Candidate candidate);
}
