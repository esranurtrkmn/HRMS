package javacamp.hrms.business.concretes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CityService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CityRepository;
import javacamp.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityRepository cityRepository;

	@Autowired
	public CityManager(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public Result add(City city) {
		cityRepository.save(city);
		
		return new SuccessResult("City successfully added.");
	}



	

}
