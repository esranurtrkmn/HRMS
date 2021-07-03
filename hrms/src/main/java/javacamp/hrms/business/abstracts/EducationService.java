package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.dtos.EducationSaveDto;

public interface EducationService {

	DataResult<List<Education>> getByEducationSchoolNameAndEndYearDesc();
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> getByResumeId(int id);
	Result save(Education education);
	Result update(Education education);
}
