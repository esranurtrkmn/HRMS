package javacamp.hrms.business.concretes;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertService;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
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
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertRepository.save(jobAdvert);
		return new SuccessResult("Job advert successfully added.");
	}


	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.findAll(),
				"All job adverts listed.");
	}
	
	@Override
	public Result closeJobAdvert(int id) {
		
		if(this.jobAdvertRepository.getById(id).isStatus())
		{
			this.jobAdvertRepository.getById(id).setStatus(false);
			this.jobAdvertRepository.save(this.jobAdvertRepository.getById(id));
			return new SuccessResult("Job advert was inactivated");
		}
		else
			return new ErrorResult("Job advert is already inactive.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatus() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.findByStatus(),"All active advertisement listed !");
	}


	@Override
	public DataResult<List<JobAdvert>> getByStatusJobAdvertAndEmployer(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.getByStatusJobAdvertAndEmployer(id));
	}


	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByCreatedAtDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.findAllByOrderByCreatedAtDesc());
	}


	
	}






	


	

