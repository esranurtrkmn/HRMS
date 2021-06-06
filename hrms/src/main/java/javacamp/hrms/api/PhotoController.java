package javacamp.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photo")
public class PhotoController {
	
	private PhotoService photoService;
	private CandidateService candidateService;
	
	@Autowired
	public PhotoController(PhotoService photoService, CandidateService candidateService) {
		super();
		this.photoService = photoService;
		this.candidateService = candidateService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "photoFile") MultipartFile photoFile){
		Candidate candidate = this.candidateService.getById(id).getData();
		Photo photo = new Photo();
		photo.setCandidate(candidate);
		return this.photoService.save(photo, photoFile);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Photo>> getAll(){
		return this.photoService.getAll();
	}
	
}
