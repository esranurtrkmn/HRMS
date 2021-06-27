package javacamp.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.Language;


public interface LanguageRepository extends JpaRepository<Language, Integer> {

	Language getById(int id);
}
