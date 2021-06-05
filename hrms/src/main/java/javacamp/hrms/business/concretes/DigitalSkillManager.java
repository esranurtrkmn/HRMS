package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.DigitalSkillService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.DigitalSkillRepository;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.entities.concretes.DigitalSkill;
import javacamp.hrms.entities.dtos.DigitalSkillSaveDto;

@Service
public class DigitalSkillManager implements DigitalSkillService{

	private DigitalSkillRepository digitalSkillRepository;
	private ResumeRepository resumeRepository;
	
	@Autowired
	public DigitalSkillManager(DigitalSkillRepository digitalSkillRepository, ResumeRepository resumeRepository) {
		
		this.digitalSkillRepository = digitalSkillRepository;
		this.resumeRepository = resumeRepository;
	}

	@Override
	public Result save(DigitalSkillSaveDto digitalSkill) {
	/*	if(!this.digitalSkillRepository.existsById(digitalSkill.getResumeId())) {
			return new ErrorResult("Böyle bir cv yok.");
		}*/
		
		
		DigitalSkill informations=new DigitalSkill();
		informations.setResume(this.resumeRepository.getById(digitalSkill.getResumeId()));
		informations.setSkillName(digitalSkill.getSkillName());
		
		
		this.digitalSkillRepository.save(informations);
		return new SuccessResult("Teknoloji bilgisi eklendi.");
	}

	@Override
	public DataResult<List<DigitalSkill>> getAll() {
		return new SuccessDataResult<List<DigitalSkill>>(this.digitalSkillRepository.findAll(),
				"Teknoloji bilgileri listelendi.");
	}

	
}
