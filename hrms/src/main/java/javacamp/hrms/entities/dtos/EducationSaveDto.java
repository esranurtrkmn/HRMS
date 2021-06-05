package javacamp.hrms.entities.dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationSaveDto {

	private int resumeId;

    @NotEmpty
    @NotBlank
    private String school_name;

    @NotEmpty
    @NotBlank
    private String branch;

    @NotNull
    private int startYear;


    private int endYear;
    
   
	private String graduateStatus;
}
