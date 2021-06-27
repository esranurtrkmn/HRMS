package javacamp.hrms.business.abstracts;



import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;


public interface EmployerService{

	 Result add(Employer employer);
	 Result update(Employer employer);
	 DataResult<List<Employer>> getAll();	 
	 DataResult<Employer> getById(int id);
	
}
