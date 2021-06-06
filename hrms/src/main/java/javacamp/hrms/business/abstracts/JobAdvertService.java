package javacamp.hrms.business.abstracts;

import java.util.List;


import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService{

	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAll();
	
	DataResult<List<JobAdvert>> getByStatus();
	
	DataResult<List<JobAdvert>> getByStatusJobAdvertAndEmployer(int id);
	
	DataResult<List<JobAdvert>> findAllByOrderByCreatedAtDesc();
	
	Result closeJobAdvert(int id); 
}



