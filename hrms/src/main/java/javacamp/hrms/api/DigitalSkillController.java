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

import javacamp.hrms.business.abstracts.DigitalSkillService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.concretes.Resume;
import javacamp.hrms.entities.dtos.DigitalSkillSaveDto;

@RestController
@RequestMapping("/api/digitalskill")
@CrossOrigin
public class DigitalSkillController {

	private DigitalSkillService digitalSkillService;

	@Autowired
	public DigitalSkillController(DigitalSkillService digitalSkillService) {
		super();
		this.digitalSkillService = digitalSkillService;
	}
	
	@PostMapping("/save")
	public Result save(@Valid @RequestBody DigitalSkill digitalSkill) {
		
		return this.digitalSkillService.save(digitalSkill);
	}
	
	@PutMapping("/update")
	public Result update(@Valid @RequestBody DigitalSkill digitalSkill) {
		return this.digitalSkillService.update(digitalSkill);
	}
	
	@GetMapping("/getall")
    public DataResult<List<DigitalSkill>> getAll() {
        return this.digitalSkillService.getAll();
    }
	
    @GetMapping("/getByResumeId")	
	public DataResult<List<DigitalSkill>> getByResumeId(int id){
		return this.digitalSkillService.getByResumeId(id);
	}
	 	
	
}
