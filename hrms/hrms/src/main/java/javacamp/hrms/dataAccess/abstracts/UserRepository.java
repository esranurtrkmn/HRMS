package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
