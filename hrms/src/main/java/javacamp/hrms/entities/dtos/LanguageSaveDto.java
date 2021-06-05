package javacamp.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageSaveDto {

	private int resumeId;

    @NotEmpty
    @NotBlank
    private String languageName;

    @NotNull
    private int languageLevel;
}
