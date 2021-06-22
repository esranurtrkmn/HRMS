package javacamp.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.JobTitleService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobTitleRepository;
import javacamp.hrms.entities.concretes.JobTitle;
import javacamp.hrms.entities.concretes.Language;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleRepository jobTitleRepository;
	
	@Autowired
	public JobTitleManager(JobTitleRepository jobTitleRepository) {
		super();
		this.jobTitleRepository = jobTitleRepository;
	}

	@Override
	public Result add(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
		
		return new SuccessResult("Job Title successfully added.");
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleRepository.findAll(),"Foreign languages has been listed.");
	}
		

	

	
	

}
