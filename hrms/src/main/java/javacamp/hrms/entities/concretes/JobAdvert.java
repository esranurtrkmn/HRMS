package javacamp.hrms.entities.concretes;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import org.hibernate.annotations.Cascade;

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
	
	
	@Column(name="job_description")
	private String jobDescription;
				
	
	@Positive
	@Column(name="number_of_active_jobs")
	private int numberOfActiveJobs;	
		
	
	@Column(name="max_salary")
	private int maxSalary;
		
	
	@Column(name="min_salary")
	private int minSalary;
	
	
	
	@Column(name = "created_at")
	private LocalDate createdAt;
	
		
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	
	@Column(name = "is_active")
	private boolean status=true;

	
	@ManyToOne()	
	@JoinColumn(name="employer_id")
	
	private Employer employer;
	
	
	@ManyToOne()	
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
	
	
	@ManyToOne()	
	@JoinColumn(name="city_id")
	private City city;
	

	@ManyToOne()	
	@JoinColumn(name="work_place_id")
	private WorkPlace workPlace;
	
	
	@ManyToOne()	
	@JoinColumn(name="work_type_id")
	private WorkType workType;
	
	private boolean confirmed;
	
   
}


