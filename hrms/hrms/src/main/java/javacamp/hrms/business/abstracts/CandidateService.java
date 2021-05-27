package javacamp.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;


public interface CandidateService {

	public DataResult<List<Candidate>> getAll();
	public Result add(Candidate candidate) throws NumberFormatException, RemoteException, Exception;
}
