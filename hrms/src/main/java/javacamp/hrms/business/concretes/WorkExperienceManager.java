package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.WorkExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.dataAccess.abstracts.WorkExperienceRepository;
import javacamp.hrms.entities.concretes.WorkExperience;
import javacamp.hrms.entities.dtos.WorkExperienceSaveDto;

@Service
public class WorkExperienceManager implements WorkExperienceService{

	private WorkExperienceRepository workExperienceRepository;
	private ResumeRepository resumeRepository;
	
	@Autowired
	public WorkExperienceManager(WorkExperienceRepository workExperienceRepository, ResumeRepository resumeRepository) {
		
		this.workExperienceRepository = workExperienceRepository;
		this.resumeRepository = resumeRepository;
	}

	@Override
	public DataResult<List<WorkExperience>> getByWorkExperienceCompanyNameAndEndYearDesc() {
		
		WorkExperience workExperience=new WorkExperience();
		
		if(workExperience.getEndYear()==0){
			workExperience.setWorkStatus(" Continues.");
		}
		
		return new SuccessDataResult<List<WorkExperience>>
		(this.workExperienceRepository.getByWorkExperienceCompanyNameAndEndYearDesc(),
				"The company names has been listed by end year.");
	}

	@Override
	public Result save(WorkExperience workExperience) {
		
		this.workExperienceRepository.save(workExperience);
		return new SuccessResult("Work experience information has been added.");
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceRepository.findAll(),
				"Work experiences has been listed.");
	}

	@Override
	public Result update(WorkExperience workExperience) {
		WorkExperience workExperienceToUpdate=workExperienceRepository.getById(workExperience.getId());
		workExperienceToUpdate=workExperience;
		this.workExperienceRepository.save(workExperienceToUpdate);
		return new SuccessResult("Work experience has been updated.");
	}

}
