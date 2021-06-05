package javacamp.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Photo;
import javacamp.hrms.entities.dtos.PhotoSaveDto;


public interface PhotoService {

	Result save(PhotoSaveDto photo);
	Result uploadPhoto(Photo photo,MultipartFile file);
	DataResult<List<Photo>> getAll();
}
