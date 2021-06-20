package javacamp.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertService;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployeeRepository;
import javacamp.hrms.dataAccess.abstracts.JobAdvertActivationRepository;
import javacamp.hrms.dataAccess.abstracts.JobAdvertRepository;
import javacamp.hrms.entities.concretes.JobAdvert;
import javacamp.hrms.entities.concretes.JobAdvertActivation;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertRepository jobAdvertRepository;
	private EmployeeRepository employeeRepository;
	private JobAdvertActivationRepository jobAdvertActivationRepository;

	@Autowired
	public JobAdvertManager(JobAdvertRepository jobAdvertRepository, EmployeeRepository employeeRepository,
			JobAdvertActivationRepository jobAdvertActivationRepository) {
		super();
		this.jobAdvertRepository = jobAdvertRepository;
		this.employeeRepository = employeeRepository;
		this.jobAdvertActivationRepository = jobAdvertActivationRepository;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertRepository.save(jobAdvert);
		return new SuccessResult("Job advert successfully added.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.findAll(), "All job adverts listed.");
	}

	@Override
	public Result closeJobAdvert(int id) {

		if (this.jobAdvertRepository.getById(id).isStatus()) {
			this.jobAdvertRepository.getById(id).setStatus(false);
			this.jobAdvertRepository.save(this.jobAdvertRepository.getById(id));
			return new SuccessResult("Job advert was inactivated");
		} else
			return new ErrorResult("Job advert is already inactive.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatus() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.findByStatus(),
				"All active advertisement listed !");
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatusJobAdvertAndEmployer(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.getByStatusJobAdvertAndEmployer(id));
	}

	@Override
	public DataResult<List<JobAdvert>> findAllByOrderByCreatedAtDesc() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertRepository.findAllByOrderByCreatedAtDesc());
	}

	@Override
	public Result setActiveAndConfirm(int jobAdvId, int employeeId) {
		try {
			if (!this.employeeRepository.existsById(employeeId)) {
				return new ErrorResult("Böyle bir personel yok");
			}
			JobAdvertActivation jobAdActivation = this.jobAdvertActivationRepository.getByJobActId(jobAdvId);
			jobAdActivation.setConfirmDate(LocalDate.now());
			jobAdActivation.setConfirm(true);
			jobAdActivation.setEmployeeId(employeeId);
			this.jobAdvertActivationRepository.save(jobAdActivation);

			JobAdvert jobAd = this.jobAdvertRepository.getById(jobAdvId);
			jobAd.setStatus(true);
			jobAd.setConfirmed(true);
			this.jobAdvertRepository.save(jobAd);
			return new SuccessResult("İş ilanı aktifleştirildi");
		} catch (EntityNotFoundException exception) {
			return new ErrorResult("İş ilanı bulunamadı");
		}
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult(this.jobAdvertRepository.getById(id),"job advert has found");
	}

	

}
