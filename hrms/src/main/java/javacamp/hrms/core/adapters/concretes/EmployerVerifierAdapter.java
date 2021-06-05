package javacamp.hrms.core.adapters.concretes;

import javacamp.hrms.core.adapters.abstracts.EmployerVerifierService;

public class EmployerVerifierAdapter implements EmployerVerifierService {

	@Override
	public boolean isEmployerVerified() {
		
		return true;
	}

}
