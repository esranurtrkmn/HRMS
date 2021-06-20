package javacamp.hrms.business.concretes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.business.abstracts.JobTitleService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobTitleRepository;
import javacamp.hrms.entities.concretes.JobTitle;

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

	
	
	



	

	

	

	
	

}
