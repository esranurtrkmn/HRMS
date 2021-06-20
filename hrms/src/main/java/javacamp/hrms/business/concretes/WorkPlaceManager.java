package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.WorkPlaceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.WorkPlaceRepository;
import javacamp.hrms.entities.concretes.WorkPlace;


@Service
public class WorkPlaceManager implements WorkPlaceService{

	private WorkPlaceRepository workPlaceRepository;
	
	@Autowired	
	public WorkPlaceManager(WorkPlaceRepository workPlaceRepository) {
		super();
		this.workPlaceRepository = workPlaceRepository;
	}


	@Override
	public DataResult<List<WorkPlace>> getAll() {
		
		return new SuccessDataResult<List<WorkPlace>>(this.workPlaceRepository.findAll(),"Work places listed.");
	}

}
