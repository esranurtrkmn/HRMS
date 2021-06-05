package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Language;
import javacamp.hrms.entities.dtos.LanguageSaveDto;

public interface LanguageService {

	Result save(LanguageSaveDto language);
	DataResult<List<Language>> getAll();
}
