package javacamp.hrms.entities.concretes;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class EmployerForRequest extends Employer{

	@NotEmpty
	@NotBlank(message = "Please re-enter the password!")
    private String confirmPassword;
}
