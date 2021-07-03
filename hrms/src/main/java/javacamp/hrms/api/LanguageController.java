package javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.LanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.dtos.LanguageSaveDto;

@RestController
@RequestMapping("/api/language")
@CrossOrigin
public class LanguageController {
	
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/save")
	public Result save(@Valid @RequestBody Language language) {
		
		return this.languageService.save(language);
	}
	
	@PutMapping("/update")
	public Result update(@Valid @RequestBody Language language) {
		return this.languageService.update(language);
	}
	
	@GetMapping("/getall")
    public DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }
	
    @GetMapping("/getByResumeId")	
	public DataResult<List<Language>> getByResumeId(int id){
			
    	return this.languageService.getByResumeId(id);

    }
	

}
