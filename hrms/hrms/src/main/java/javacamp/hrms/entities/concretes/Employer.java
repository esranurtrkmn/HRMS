package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@PrimaryKeyJoinColumn(name="id")
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Employer extends User{
	
	
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

}
