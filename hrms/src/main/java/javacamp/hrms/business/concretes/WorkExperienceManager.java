package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.WorkExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
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
			workExperience.setWorkStatus(" Devam ediyor.");
		}
		
		return new SuccessDataResult<List<WorkExperience>>
		(this.workExperienceRepository.getByWorkExperienceCompanyNameAndEndYearDesc(),
				"Şirket adları tarihe göre listelendi.");
	}

	@Override
	public Result save(WorkExperienceSaveDto workExperience) {
		
		/*if(!this.workExperienceRepository.existsById(workExperience.getResumeId())) {
			return new ErrorResult("Böyle bir cv yok.");
		}
		else if(workExperience.getStartYear()==0) {
			return new ErrorResult("Başlangıç tarihi giriniz.");
		}
		*/
		WorkExperience informations=new WorkExperience();
		informations.setResume(this.resumeRepository.getById(workExperience.getResumeId()));
		informations.setCompanyName(workExperience.getCompanyName());
		informations.setJobTitle(workExperience.getJobTitle());
		informations.setStartYear(workExperience.getStartYear());
		informations.setEndYear(workExperience.getEndYear());
		
		this.workExperienceRepository.save(informations);
		return new SuccessResult("Tecrübe bilgisi eklendi.");
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceRepository.findAll(),
				"İş tecrübeleri listelendi.");
	}

}
