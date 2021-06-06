package javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.dtos.EducationSaveDto;

@RestController
@RequestMapping("/api/education")
public class EducationController {
	
	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Education>> getAll() {
        return this.educationService.getAll();
    }

	@PostMapping("/save")
	public Result save(@Valid @RequestBody EducationSaveDto education){
	       
		return this.educationService.save(education);
	   
	}
	
	@GetMapping("/getbyschoolnameandendyeardesc")
	public DataResult<List<Education>> getByEducationSchoolNameAndEndYearDesc(){
		
		return this.educationService.getByEducationSchoolNameAndEndYearDesc();
	}
	
}
