package javacamp.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.business.abstracts.CityService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CityController {

	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
	}
	
	
	
}
