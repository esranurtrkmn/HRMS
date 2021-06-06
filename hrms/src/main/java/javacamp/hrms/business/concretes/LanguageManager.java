package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.LanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.LanguageRepository;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.dtos.LanguageSaveDto;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	private ResumeRepository resumeRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository, ResumeRepository resumeRepository) {
	
		this.languageRepository = languageRepository;
		this.resumeRepository = resumeRepository;
	}

	@Override
	public Result save(LanguageSaveDto language) {
			
		Language informations=new Language();
		informations.setResume(this.resumeRepository.getById(language.getResumeId()));
		informations.setLanguageName(language.getLanguageName());
		informations.setLanguageLevel(language.getLanguageLevel());
		
		
		this.languageRepository.save(informations);
		return new SuccessResult("Foreign language skill has been added.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageRepository.findAll(),"Foreign languages has been listed.");
	}
	
	

}
