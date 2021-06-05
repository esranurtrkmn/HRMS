package javacamp.hrms.entities.concretes;

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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="education")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name="school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Column(name="branch")
	private String branch;
		
	@NotNull
	@Column(name="start_year")
	private int startYear;
	
	@Column(name="end_year")
	private int endYear;
	
	@Column(name="graduate_status")
	private String graduateStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
}
