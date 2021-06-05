package javacamp.hrms.core.adapters.concretes;

import javacamp.hrms.core.adapters.abstracts.EmailVerifierService;

public class EmailVerifierAdapter implements EmailVerifierService{

	@Override
	public boolean isEmailVerified() {
		
		return true;
	}

}
