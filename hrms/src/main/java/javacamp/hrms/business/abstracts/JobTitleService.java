package javacamp.hrms.business.abstracts;


import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobTitle;

public interface JobTitleService{

	Result add(JobTitle jobTitle);

	DataResult<List<JobTitle>> getAll();
}
