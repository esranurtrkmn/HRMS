package javacamp.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EducationRepository;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.dtos.EducationSaveDto;

@Service
public class EducationManager implements EducationService{

	private EducationRepository educationRepository;
	private ResumeRepository resumeRepository;
	
	
	@Autowired
	public EducationManager(EducationRepository educationRepository, ResumeRepository resumeRepository) {
		
		this.educationRepository = educationRepository;
		this.resumeRepository = resumeRepository;
	}

	@Override
	public DataResult<List<Education>> getByEducationSchoolNameAndEndYearDesc() {
		Education education=new Education();
		
		if(education.getEndYear()==0){
			education.setGraduateStatus("Continues");
		}
		
		return new SuccessDataResult<List<Education>>(
				this.educationRepository.getByEducationSchoolNameAndEndYearDesc(),
				"School names has been listed by graduation year.");
		
	}

	@Override
	public DataResult<List<Education>> getAll() {
		
		return new SuccessDataResult<List<Education>>(this.educationRepository.findAll(), 
				"Education informations has been listed.");
	}

	@Override
	public Result save(Education education) {
				
		
		this.educationRepository.save(education);
		return new SuccessResult("Education information has been added.");
		
	}

	@Override
	public Result update(Education education) {
		Education educationToUpdate=educationRepository.getById(education.getId());
		educationToUpdate=education;
		this.educationRepository.save(educationToUpdate);
		
		return new SuccessResult("Education has been updated.");
	}

	@Override
	public DataResult<List<Education>> getByResumeId(int id) {
		
		return new SuccessDataResult<List<Education>>(this.educationRepository.getByResumeId(id),"educations ordered by resume.");
	}

}
