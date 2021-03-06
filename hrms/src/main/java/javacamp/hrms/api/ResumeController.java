package javacamp.hrms.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.ResumeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.Resume;
import javacamp.hrms.entities.dtos.ResumeSaveDto;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }
	
	@GetMapping("/getbyid")
    public DataResult<Resume> findById(@RequestParam int id) {
        return this.resumeService.findById(id);
    }
	
	@GetMapping("/getByCandidateId")
	
	public DataResult<Resume> getByCandidateId(int id){
		return this.resumeService.getByCandidateId(id);
	}
	 	 
	 
	@PostMapping("/save")
	public Result save(@Valid @RequestBody ResumeSaveDto resume){
	       
		return this.resumeService.save(resume);
	   
	}
	
	@PutMapping("/update")
	public Result update(@Valid @RequestBody Resume resume) {
		return this.resumeService.update(resume);
	}
	
	@DeleteMapping(value = "/deleteById")
	public DataResult<Boolean> deleteById(@RequestParam int id) {
		
	   return resumeService.deleteById(id);
	}
}
