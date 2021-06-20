package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EmployeeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployeeRepository;
import javacamp.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
		
	@Autowired
	public EmployeeManager(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Result add(Employee employee) {
		this.employeeRepository.save(employee);
		return new SuccessResult("Employee successfully added.");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(this.employeeRepository.findAll(),"Employee listed.");
	}

}
