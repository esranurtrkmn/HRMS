package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ResumeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateRepository;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.entities.concretes.Resume;
import javacamp.hrms.entities.dtos.ResumeSaveDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeRepository resumeRepository;
	private CandidateRepository candidateRepository;
	
	@Autowired
	public ResumeManager(ResumeRepository resumeRepository, CandidateRepository candidateRepository) {
		super();
		this.resumeRepository = resumeRepository;
		this.candidateRepository = candidateRepository;
	}


	@Override
	public DataResult<Resume> findById(int id) {
		if(!this.resumeRepository.existsById(id)){
            return new ErrorDataResult<Resume>("There is not CV like that.");
        }
        return new SuccessDataResult<Resume>(this.resumeRepository.getById(id),"The resume has found.");
	}
	
	@Override
	public DataResult<List<Resume>> getAll() {
		
		return new SuccessDataResult<List<Resume>>(this.resumeRepository.findAll(),"Resumes has been listed.");
	}

	@Override
	public Result save(ResumeSaveDto resume) {
				
		Resume informations=new Resume();
		informations.setCandidate(this.candidateRepository.getById(resume.getCandidateId()));
	    informations.setCvName(resume.getCvName());
	    informations.setAboutMe(resume.getAboutMe());
	    informations.setGithubUrl(resume.getGithubUrl());
	    informations.setLinkedinUrl(resume.getLinkedinUrl());
		
	    this.resumeRepository.save(informations);
	    return new SuccessResult("Resume has been added.");
		
	}


	@Override
	public Result update(Resume resume) {
		
		Resume resumeToUpdate = resumeRepository.getById(resume.getId());
		resumeToUpdate = resume;
		this.resumeRepository.save(resumeToUpdate);
		return new SuccessResult("Resume has been updated.");
	}


	@Override
	public DataResult<Resume> getByCandidateId(int id) {
		
		return new SuccessDataResult<Resume>(this.resumeRepository.getByCandidateId(id),"resumes has been ordered by candidate");
	}



}
