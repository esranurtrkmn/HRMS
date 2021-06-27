package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.dtos.DigitalSkillSaveDto;


public interface DigitalSkillService {

	Result save(DigitalSkill digitalSkill);
	Result update(DigitalSkill digitalSkill);
	DataResult<List<DigitalSkill>> getAll();
}
