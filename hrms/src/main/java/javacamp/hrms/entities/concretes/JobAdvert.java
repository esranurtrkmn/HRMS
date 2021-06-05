package javacamp.hrms.entities.concretes;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Positive;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="job_adverts")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotEmpty
    @NotBlank(message = "Job Description cannot be empty!")
	@Column(name="job_description")
	private String jobDescription;
	
	@NotNull
	@NotEmpty
    @NotBlank(message = "Job Location cannot be empty!")
	@Column(name="job_location")
	private String jobLocation;	
	
	@NotNull
	@NotEmpty
    @NotBlank(message = "Number of active jobs cannot be empty!")
	@Positive
	@Column(name="number_of_active_jobs")
	private int numberOfActiveJobs;	
		
	
	@Column(name="max_salary")
	private int maxSalary;
		
	
	@Column(name="min_salary")
	private int minSalary;
	
	
	@NotNull
	@Column(name = "created_at")
	private Date createdAt;
	
		
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	
	@Column(name = "is_active")
	private boolean status;

	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employer.class, cascade = {CascadeType.ALL})	
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = JobTitle.class, cascade = {CascadeType.ALL})	
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = City.class, cascade = {CascadeType.ALL})	
	@JoinColumn(name="city_id")
	private City city;
	
	
   
}


