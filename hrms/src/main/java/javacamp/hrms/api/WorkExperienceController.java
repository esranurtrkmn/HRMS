package javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.WorkExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.WorkExperience;
import javacamp.hrms.entities.dtos.WorkExperienceSaveDto;

@RestController
@RequestMapping("/api/workexperience")
public class WorkExperienceController {
	
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	
	@PostMapping("/save")
	public Result save(@Valid @RequestBody WorkExperienceSaveDto workExperience) {
		
		return this.workExperienceService.save(workExperience);
	}
	
	@GetMapping("/getall")
    public DataResult<List<WorkExperience>> getAll() {
        return this.workExperienceService.getAll();
    }
	
	@GetMapping("/getbyworkexperiencenameandendyeardesc")
	public DataResult<List<WorkExperience>> getByWorkExperienceCompanyNameAndEndYearDesc(){
		
		return this.workExperienceService.getByWorkExperienceCompanyNameAndEndYearDesc();
	}

}