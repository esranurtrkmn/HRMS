package javacamp.hrms.core.adapters.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javacamp.hrms.core.adapters.abstracts.PhotoUploadService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;

@Service
public class PhotoUploadManager implements PhotoUploadService{

	private Cloudinary cloudinary;
	
	public PhotoUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dtewzgzgk",
				"api_key", "158227181658343",
				"api_secret", "9nu9Qjw_tVxuQAq91l0laKF2d9k"));
	}
		
	
	@Override
	public DataResult<Map<String, String>> uploadPhotoFile(MultipartFile photoFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(photoFile.getBytes(), 
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map<String, String>>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map<String, String>>();
	}

}
