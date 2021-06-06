package javacamp.hrms.core.adapters.abstracts;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;

import java.util.Map;

public interface PhotoUploadService {

	DataResult<Map<String, String>> uploadPhotoFile(MultipartFile photoFile);
}
