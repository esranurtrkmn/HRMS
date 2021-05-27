package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;


public interface EmployerService{

	public DataResult<List<Employer>> getAll();
	public Result add(Employer employer);
}
