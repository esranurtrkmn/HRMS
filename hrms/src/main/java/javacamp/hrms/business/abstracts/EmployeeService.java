package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	Result add(Employee employee);
	Result update(Employee employee);
	public DataResult<List<Employee>> getAll();

}
