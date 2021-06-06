package javacamp.hrms.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="candidate_for_request")
@PrimaryKeyJoinColumn(name="id")
public class CandidateForRequest extends Candidate {

	@NotEmpty
    @NotBlank(message = "Please re-enter the password!")
    private String confirmPassword;
	
	
}
