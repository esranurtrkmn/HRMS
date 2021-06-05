package javacamp.hrms.business.abstracts;


import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobTitle;

public interface JobTitleService{

	Result add(JobTitle jobTitle);
}
