package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@PrimaryKeyJoinColumn(name="id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
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
	
	@OneToMany(mappedBy="candidate")
	private List<Resume> resumes;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<DigitalSkill> digitalSkills;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Education> educations;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Language> languages;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Photo> photos;
	
	@OneToMany(mappedBy="candidate",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<WorkExperience> workExperiences;
}
