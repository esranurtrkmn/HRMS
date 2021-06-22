package javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.DigitalSkillService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.DigitalSkill;
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
	public Result save(@Valid @RequestBody DigitalSkillSaveDto digitalSkill) {
		
		return this.digitalSkillService.save(digitalSkill);
	}
	
	@GetMapping("/getall")
    public DataResult<List<DigitalSkill>> getAll() {
        return this.digitalSkillService.getAll();
    }
	
}
