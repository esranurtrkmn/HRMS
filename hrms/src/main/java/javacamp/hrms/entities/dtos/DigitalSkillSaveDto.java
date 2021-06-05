package javacamp.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DigitalSkillSaveDto {

    private int resumeId;

    @NotEmpty
    @NotBlank
    private String skillName;
}
