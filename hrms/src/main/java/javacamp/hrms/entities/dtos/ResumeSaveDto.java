package javacamp.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSaveDto {
	
	    private int candidateId;
	    private String cvName;
	    private String aboutMe;
	    private String githubUrl;
	    private String linkedinUrl;

	    private List<Integer> digitalSkills;
	    private List<Integer> photos;
	    private List<Integer> educations;
	    private List<Integer> workExperiences;
	    private List<Integer> languages;

}
