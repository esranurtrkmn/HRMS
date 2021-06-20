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
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
	
	@NotEmpty
    @NotBlank()
	@Column(name="first_name",nullable=false)
	private String firstName;
	
	@NotEmpty
    @NotBlank()
	@Column(name="last_name",nullable=false)
	private String lastName;
	
	
	

}
