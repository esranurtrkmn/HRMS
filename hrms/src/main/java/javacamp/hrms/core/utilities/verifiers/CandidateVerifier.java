package javacamp.hrms.core.utilities.verifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javacamp.hrms.core.adapters.concretes.EmailVerifierAdapter;
import javacamp.hrms.core.adapters.concretes.MernisAdapter;
import javacamp.hrms.dataAccess.abstracts.CandidateRepository;
import javacamp.hrms.dataAccess.abstracts.UserRepository;
import javacamp.hrms.entities.concretes.Candidate;


public class CandidateVerifier extends UserVerifier{

	private Candidate candidate;
	private CandidateRepository candidateRepository;
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
    public CandidateVerifier(Candidate candidate, CandidateRepository candidateRepository, 
    		UserRepository userRepository) {
        super(candidate, userRepository);
        this.candidate = candidate;
        this.candidateRepository = candidateRepository;
    }

    public boolean isIdentityNumberUsedBefore() {
        for(Candidate candidate : candidateRepository.findAll())
            if(candidate.getIdentityNumber().equals(this.candidate.getIdentityNumber()))
                return true;
       return false;
    }

    public boolean isIdentityNumberVerified(){
        return new MernisAdapter().CheckIfRealPerson(candidate);
    }

    public boolean isEmailVerified() {
        return new EmailVerifierAdapter().isEmailVerified();
    }

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
	}
        

    public boolean EmailCheck(String email) {
		
		if(validate(candidate.getEmail())) {
			return true;
		}
		
		else {
			return false;
		}
    }
}
