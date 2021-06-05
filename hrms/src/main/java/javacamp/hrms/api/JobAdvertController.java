package javacamp.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.JobAdvertService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadvert")
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	
	@PostMapping("/add")
	public Result addAnnouncement(@RequestBody JobAdvert jobAdvert)
	{
		return this.jobAdvertService.add(jobAdvert);
	}
	
	
	@PostMapping("/deletejobadvert")
	public Result closeJobAdvert(@RequestParam int id)
	{
		return this.jobAdvertService.closeJobAdvert(id);
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll()
	{
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getallsorted")
	public DataResult<List<JobAdvert>> getAllSorted()
	{
		return this.jobAdvertService.getByStatus();
	}
	
	@GetMapping("/getalljobadvertsandcompany")
	public DataResult<List<JobAdvert>> getAllByCompanyName(@RequestParam String companyName)
	{
		return this.jobAdvertService.getByCompanyName(companyName);
	}
}
