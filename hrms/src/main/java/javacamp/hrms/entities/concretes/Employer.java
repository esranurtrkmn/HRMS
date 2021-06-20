package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class Employer extends User{
		
	@Id
	@Column(name = "id")
	@PrimaryKeyJoinColumn
	private int id;
	
	@NotEmpty
    @NotBlank()
	@Column(name="company_name",nullable=false)
	private String companyName;
	
	@NotEmpty
    @NotBlank()
	@Column(name="web_address",nullable=false)
	private String webAddress;
	
	@NotEmpty
    @NotBlank()
	@Column(name="phone_number",nullable=false)
	private String phoneNumber;

	
	@OneToMany(mappedBy="employer")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
}
