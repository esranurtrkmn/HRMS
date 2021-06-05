package javacamp.hrms.entities.concretes;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_titles")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotNull
	@NotEmpty
    @NotBlank(message = "Job Advert Title cannot be empty!")
	@Column(name="job_title")
	private String jobTitle;
	
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "is_active")
	private boolean status;

	
	
	
	
	
}
