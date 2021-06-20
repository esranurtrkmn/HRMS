package javacamp.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advert_activation")
public class JobAdvertActivation {

	@Id
	
	@Column(name = "job_act_id")
	private int jobActId;

	@Column(name = "employee_id")
	private Integer employeeId;
	
	@Column(name = "job_adv_id")
	private Integer jobAdvId;

	@Column(name = "confirm")
	private boolean confirm;

	@Column(name = "confirm_date")
	private LocalDate confirmDate;
	
	
}
