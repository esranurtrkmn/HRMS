package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkPlace;

public interface WorkPlaceService {

	 public DataResult<List<WorkPlace>> getAll();
}
