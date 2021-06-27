package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="resumes")
@AllArgsConstructor
@NoArgsConstructor

public class Resume {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="cv_name")
	private String cvName;
	
	@Column(name="github_url")
	private String githubUrl;
	
	@Column(name="linkedin_url")
	private String linkedinUrl;
	
	@Column(name="about_me")
	private String aboutMe;
	
	
	@ManyToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
		
	@OneToMany(mappedBy="resume")
	
	private List<DigitalSkill> digitalSkills;
	
	@OneToMany(mappedBy="resume")
	
	private List<Education> educations;
	
	@OneToMany(mappedBy="resume")
	
	private List<Language> languages;
	
	@OneToMany(mappedBy="resume")
	
	private List<Photo> photos;
	
	@OneToMany(mappedBy="resume")
	
	private List<WorkExperience> workExperiences;
	
}
