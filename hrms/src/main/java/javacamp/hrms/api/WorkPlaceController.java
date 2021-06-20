package javacamp.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.WorkPlaceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkPlace;

@RestController
@RequestMapping("/api/workplace")
@CrossOrigin
public class WorkPlaceController {

	private WorkPlaceService workPlaceService;

	@Autowired
	public WorkPlaceController(WorkPlaceService workPlaceService) {
		super();
		this.workPlaceService = workPlaceService;
	}
	
	@GetMapping("/getAll")
    public DataResult<List<WorkPlace>> getAll(){
      
		return this.workPlaceService.getAll();
    }
	
}
