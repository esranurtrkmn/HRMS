package javacamp.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.JobTitleService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitle")
@CrossOrigin
public class JobTitleController {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobTitleService.getAll();
	}
	
	
}
