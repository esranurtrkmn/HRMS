package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Resume;
import javacamp.hrms.entities.dtos.ResumeSaveDto;

public interface ResumeService {

	DataResult<Resume> findById(int id);
	DataResult<List<Resume>> getAll();
	Result save(ResumeSaveDto resume);
}
