package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {

	public DataResult<List<JobAdvert>> getAll();
	public Result add(JobAdvert jobAdvert);
}



