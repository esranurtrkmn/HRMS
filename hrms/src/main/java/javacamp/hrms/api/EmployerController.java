package javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.EmployerForRequest;
import javacamp.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployerController {

	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getbyid")
    public DataResult<Employer> getById(@RequestParam int id) {
        return this.employerService.getById(id);
    }
	
    @GetMapping("/getall")
	
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody EmployerForRequest employer) throws Throwable{
		
		return this.employerService.add(employer);
		
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody Employer employer) {
		return this.employerService.update(employer);
	}
	
	
	
}
