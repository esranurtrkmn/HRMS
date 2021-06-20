package javacamp.hrms.business.abstracts;



import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.City;

public interface CityService{

	Result add(City city);
}
