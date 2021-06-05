package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;

import javacamp.hrms.core.utilities.verifiers.EmployerVerifier;
import javacamp.hrms.dataAccess.abstracts.EmployerRepository;
import javacamp.hrms.dataAccess.abstracts.UserRepository;

import javacamp.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager implements EmployerService{

	private EmployerRepository employerRepository;
	private EmployerVerifier employerVerifier;
	
	
	@Autowired
	public EmployerManager(EmployerRepository employerRepository,UserRepository userRepository) {
		super(userRepository);
		this.employerRepository = employerRepository;
		
	}
	
	
	@Override
	public DataResult<List<Employer>> getAll() {
		final List<Employer> employers = employerRepository.findAll();
		return new SuccessDataResult<List<Employer>>(employers);
	}

		

	@Override
	public Result add(Employer employer) {
		employerVerifier = new EmployerVerifier(employer, employerRepository,userRepository);

		
        if(employerVerifier.isEmailUsedBefore())
            return new ErrorResult("Email is already used.");
        if(!employerVerifier.isEmailVerified())
            return new ErrorResult("Please validate your email: "+ employer.getEmail());
        if(!employerVerifier.isEmployerVerified())
            return new ErrorResult("Your registration need to be verified by the employee first.");
        if(!employerVerifier.EmailCheck(employer.getEmail())){
        	return new ErrorDataResult<Employer>("Email is not in the correct format");
        }
        if(!employerVerifier.getUrl(employer.getWebAddress())) {
        	return new ErrorDataResult<Employer>("URL is not in the correct format.");
        }

        this.employerRepository.save(employer);
        return new SuccessResult(" Employer successfully added.");
	}


	@Override
	public DataResult<Employer> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
