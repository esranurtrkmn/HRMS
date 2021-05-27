package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Candidate extends User{

	@NotEmpty
    @NotBlank(message = "First name cannot be empty!")
	@Column(name="first_name")
	private String firstName;
	
	@NotEmpty
    @NotBlank(message = "Last name cannot be empty!")
	@Column(name="last_name")
	private String lastName;
	
	@NotEmpty
    @NotBlank(message = "Identity number cannot be empty!")
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotEmpty
    @NotBlank(message = "Date of birth cannot be empty!")
	@Column(name="date_of_birth")
	private int dateOfBirth;
}
