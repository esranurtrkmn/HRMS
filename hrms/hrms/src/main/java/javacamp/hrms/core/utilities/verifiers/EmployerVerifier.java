package javacamp.hrms.core.utilities.verifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javacamp.hrms.core.adapters.concretes.EmailVerifierAdapter;
import javacamp.hrms.core.adapters.concretes.EmployerVerifierAdapter;
import javacamp.hrms.dataAccess.abstracts.EmployerRepository;
import javacamp.hrms.dataAccess.abstracts.UserRepository;
import javacamp.hrms.entities.concretes.Employer;

public class EmployerVerifier extends UserVerifier{

	private Employer employer;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public EmployerVerifier(Employer employer, EmployerRepository employerRepository,UserRepository userRepository) {
		super(employer,userRepository);
		this.employer = employer;
	}
	
	public boolean isEmailVerified() {
        return new EmailVerifierAdapter().isEmailVerified();
    }

    public boolean isEmployerVerified() {
        return new EmployerVerifierAdapter().isEmployerVerified();
    }
	
    public boolean getUrl(String webAddress) {
    	if(webAddress.startsWith("http://") || webAddress.startsWith("https://")) {
    		if(webAddress.endsWith(".com")) {
    			return true;
    		}
    	}
		return false;
    }
    
	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
	}
        

    public boolean EmailCheck(String email) {
		
		if(validate(employer.getEmail())) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}
    
   

    
}
