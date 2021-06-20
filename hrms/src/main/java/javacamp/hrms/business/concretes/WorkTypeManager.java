package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.WorkTypeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.WorkTypeRepository;
import javacamp.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService {

	private WorkTypeRepository workTypeRepository;
	
	@Autowired	
	public WorkTypeManager(WorkTypeRepository workTypeRepository) {
		super();
		this.workTypeRepository = workTypeRepository;
	}


	@Override
	public DataResult<List<WorkType>> getAll() {
		
		return new SuccessDataResult<List<WorkType>>(this.workTypeRepository.findAll(),"WorkTypes listed.");
	}

}
