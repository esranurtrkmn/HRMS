package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.PhotoRepository;
import javacamp.hrms.dataAccess.abstracts.ResumeRepository;
import javacamp.hrms.entities.concretes.Photo;
import javacamp.hrms.entities.dtos.PhotoSaveDto;

@Service
public class PhotoManager implements PhotoService{

	private PhotoRepository photoRepository;
	private ResumeRepository resumeRepository;
	
	
	@Autowired
	public PhotoManager(PhotoRepository photoRepository, ResumeRepository resumeRepository) {
		super();
		this.photoRepository = photoRepository;
		this.resumeRepository = resumeRepository;
	}

	@Override
	public Result save(PhotoSaveDto photo) {
		/*if(!this.photoRepository.existsById(photo.getResumeId())) {
			return new ErrorResult("Böyle bir cv yok.");
		}*/
		
			
		Photo informations=new Photo();
		informations.setResume(this.resumeRepository.getById(photo.getResumeId()));
		informations.setPhotoUrl(photo.getPhotoUrl());
        
		
		this.photoRepository.save(informations);
		return new SuccessResult("Fotoğraf eklendi.");
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		
		return new SuccessDataResult<List<Photo>>(this.photoRepository.findAll(),"Fotoğraflar listelendi.");
	}

	
	@Override
	public Result uploadPhoto(Photo photo, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

}
