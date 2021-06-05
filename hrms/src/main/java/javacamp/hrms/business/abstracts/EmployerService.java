package javacamp.hrms.business.abstracts;



import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;


public interface EmployerService{

	 DataResult<List<Employer>> getAll();
	 Result add(Employer employer);
	 DataResult<Employer> getById(int id);
	
}
