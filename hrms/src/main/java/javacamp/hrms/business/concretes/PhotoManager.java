package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.core.adapters.abstracts.PhotoUploadService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.PhotoRepository;
import javacamp.hrms.entities.concretes.Photo;


@Service
public class PhotoManager implements PhotoService{

	private PhotoRepository photoRepository;
	private PhotoUploadService photoUploadService;
	
	@Autowired
	public PhotoManager(PhotoRepository photoRepository,PhotoUploadService photoUploadService) {
		super();
		this.photoRepository = photoRepository;		
		this.photoUploadService = photoUploadService;
	}

	@Override
	public Result save(Photo photo,MultipartFile photoFile) {
		        
		Map<String,String> uploadImage = this.photoUploadService.uploadPhotoFile(photoFile).getData();
		photo.setPhotoUrl(uploadImage.get("url"));
				
		this.photoRepository.save(photo);
		return new SuccessResult("Photo has been added.");
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		
		return new SuccessDataResult<List<Photo>>(this.photoRepository.findAll(),"Photos has been listed.");
	}

	@Override
	public DataResult<List<Photo>> getByResumeId(int id) {
		
		return new SuccessDataResult<List<Photo>>(this.photoRepository.getByResumeId(id),"photos ordered by resume.");
	}

	
	

}
