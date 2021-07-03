package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.DigitalSkillService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.DigitalSkillRepository;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.concretes.Resume;
import javacamp.hrms.entities.dtos.DigitalSkillSaveDto;

@Service
public class DigitalSkillManager implements DigitalSkillService{

	private DigitalSkillRepository digitalSkillRepository;
	
	
	@Autowired
	public DigitalSkillManager(DigitalSkillRepository digitalSkillRepository) {
		
		this.digitalSkillRepository = digitalSkillRepository;
		
	}

	@Override
	public Result save(DigitalSkill digitalSkill) {
			
		this.digitalSkillRepository.save(digitalSkill);
		return new SuccessResult("DigitalSkill has been successfuly added.");
	}

	@Override
	public DataResult<List<DigitalSkill>> getAll() {
		return new SuccessDataResult<List<DigitalSkill>>(this.digitalSkillRepository.findAll(),
				"Digital skills has been listed.");
	}

	@Override
	public Result update(DigitalSkill digitalSkill) {
		DigitalSkill digitalSkillToUpdate = digitalSkillRepository.getById(digitalSkill.getId());
		digitalSkillToUpdate = digitalSkill;
		this.digitalSkillRepository.save(digitalSkillToUpdate);
		return new SuccessResult("DigitalSkill has been updated.");
	}

	@Override
	public DataResult<List<DigitalSkill>> getByResumeId(int id) {
		
		return new SuccessDataResult<List<DigitalSkill>>(this.digitalSkillRepository.getByResumeId(id),"skills has been ordered by resume");
	}

	
}
