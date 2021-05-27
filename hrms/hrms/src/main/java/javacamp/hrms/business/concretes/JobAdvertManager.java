package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertService;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobAdvertRepository;
import javacamp.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertRepository jobAdvertRepository;
	
	
	@Autowired
	public JobAdvertManager(JobAdvertRepository jobAdvertRepository) {
		super();
		this.jobAdvertRepository = jobAdvertRepository;
	}



	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>
		(this.jobAdvertRepository.findAll(),"JobAdverts listed.");
		
		//return this.jobAdvertRepository.findAll();
	}



	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertRepository.save(jobAdvert);
		return new SuccessResult("iş ilanı eklendi.");
	}


	
}
