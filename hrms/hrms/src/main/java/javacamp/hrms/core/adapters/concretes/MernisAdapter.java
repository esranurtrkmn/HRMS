package javacamp.hrms.core.adapters.concretes;

import javacamp.hrms.core.adapters.abstracts.MernisService;
import javacamp.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter implements MernisService {

	@Override
	public boolean CheckIfRealPerson(Candidate candidate) {
        
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		
		try {
			if(client.TCKimlikNoDogrula(
					
					Long.parseLong(candidate.getIdentityNumber()), 
					candidate.getFirstName().toUpperCase(), 
					candidate.getLastName().toUpperCase(), 
					candidate.getDateOfBirth()
					
					)) {
				return true;
			}
			else {
				return false;
			}
				
		}
		
		catch (Exception e) {
            e.printStackTrace();
        }
		
		return false;
	}

}
