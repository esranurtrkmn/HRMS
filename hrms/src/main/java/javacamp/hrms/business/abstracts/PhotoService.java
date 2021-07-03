package javacamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Education;
import javacamp.hrms.entities.concretes.Photo;



public interface PhotoService {

	Result save(Photo photo, MultipartFile photofile);
	
	DataResult<List<Photo>> getAll();
	
	DataResult<List<Photo>> getByResumeId(int id);
}
