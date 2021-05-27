package javacamp.hrms.core.utilities.verifiers;

import javacamp.hrms.dataAccess.abstracts.UserRepository;
import javacamp.hrms.entities.concretes.User;

public class UserVerifier {

	private User user;
	private UserRepository userRepository;
	
	public UserVerifier(User user) {
		this.user=user;
	}

	public UserVerifier(User user, UserRepository userRepository) {
		
		this(user);
		this.userRepository = userRepository;
	}
	
	
	public boolean isEmailUsedBefore() {
        for(User user : userRepository.findAll()){
            if( user.getEmail().equals(this.user.getEmail())){
                return true;
            }
        }
        return false;
    }
}
