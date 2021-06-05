package javacamp.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.core.utilities.verifiers.CandidateVerifier;
import javacamp.hrms.dataAccess.abstracts.CandidateRepository;
import javacamp.hrms.dataAccess.abstracts.UserRepository;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.Employer;


@Service
public class CandidateManager extends UserManager implements CandidateService {

	private CandidateRepository candidateRepository;
    private CandidateVerifier candidateVerifier;
	
	@Autowired
	public CandidateManager(CandidateRepository candidateRepository,UserRepository userRepository) {
		super(userRepository);
		this.candidateRepository = candidateRepository;
		
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateRepository.findAll(),"Candidates listed.");
	}

	

	@Override
	public Result add(Candidate candidate) {
		candidateVerifier = new CandidateVerifier(candidate, candidateRepository,userRepository);

	        if(candidateVerifier.isEmailUsedBefore())
	            return new ErrorResult("Email is already used.");
	        if(candidateVerifier.isIdentityNumberUsedBefore())
	            return new ErrorResult("Identity Number(TC) is already used.");
	        if(!candidateVerifier.isIdentityNumberVerified())
	            return new ErrorResult("Please enter a valid Identity Number(TC) ");
	        if(!candidateVerifier.isEmailVerified())
	            return new ErrorResult("Please validate your email: " + candidate.getEmail());
	        if(!candidateVerifier.EmailCheck(candidate.getEmail())){
	        	return new ErrorDataResult<Employer>("Email is not in the correct format.");
	        }
	        
	        this.candidateRepository.save(candidate);
	        return new SuccessResult("Candidate successfully added.");
		
		
	}

}
