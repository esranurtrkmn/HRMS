package javacamp.hrms.business.abstracts;



import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.City;

public interface CityService{

	Result add(City city);
	DataResult<List<City>> getAll();
}
