package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.dtos.LanguageSaveDto;

public interface LanguageService {

	Result save(Language language);
	Result update(Language language);
	DataResult<List<Language>> getAll();
	DataResult<List<Language>> getByResumeId(int id);
}
