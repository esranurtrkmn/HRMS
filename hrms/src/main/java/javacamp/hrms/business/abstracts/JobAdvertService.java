package javacamp.hrms.business.abstracts;

import java.util.List;


import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService{

	Result add(JobAdvert jobAdvert);
	
	Result updateIsConfirm(boolean isConfirm, int id);
	
	Result closeJobAdvert(int id); 
	
	DataResult<List<JobAdvert>> getAll();
	
	DataResult<List<JobAdvert>> getByStatus();
	
	DataResult<List<JobAdvert>> getByStatusJobAdvertAndEmployer(int id);
	
	DataResult<List<JobAdvert>> findAllByOrderByCreatedAtDesc();
	
	DataResult<List<JobAdvert>> getByIsConfirm(boolean isConfirm);

	DataResult<List<JobAdvert>> getByIsConfirmAndStatus(boolean isConfirm, boolean status);
	
	DataResult<JobAdvert> getById(int id);
}



