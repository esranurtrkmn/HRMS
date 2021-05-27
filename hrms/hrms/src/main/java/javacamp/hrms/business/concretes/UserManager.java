package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.dataAccess.abstracts.UserRepository;

@Service
public class UserManager implements UserService{

	public UserRepository userRepository;

	@Autowired
	public UserManager(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	
}
