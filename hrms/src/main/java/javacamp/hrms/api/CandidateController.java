package javacamp.hrms.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.CandidateForRequest;


@RestController
@RequestMapping("/api/candidate")
@CrossOrigin
public class CandidateController {

	private CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
    @GetMapping("/getall")
	
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody CandidateForRequest candidate) throws Throwable{
		
		return this.candidateService.add(candidate);
		
	}
}
