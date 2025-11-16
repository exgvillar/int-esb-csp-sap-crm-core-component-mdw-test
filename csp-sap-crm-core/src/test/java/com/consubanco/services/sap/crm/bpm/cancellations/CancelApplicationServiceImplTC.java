package com.consubanco.services.sap.crm.bpm.cancellations;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationBOP;
import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationRequestBOP;
import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationResponseBOP;
import com.consubanco.services.sap.crm.bpm.cancellations.models.EmployeeBOP;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class CancelApplicationServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CancelApplicationServiceImplTC.class );
	
	/**
	 * 
	 */
	public CancelApplicationServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CancelApplicationServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		ICRMBPMCancellationsService processImpl = new CRMBPMCancellationsServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		CancelApplicationRequestBOP cancelApplicationRequestBOP = new CancelApplicationRequestBOP();
		cancelApplicationRequestBOP.setApplicationId("UNIT-TC");
		cancelApplicationRequestBOP.setProcessId("");
		
		EmployeeBOP user = new EmployeeBOP();
		user.setBusinessPartner("10000097");
		user.setUserName("omarin");
		cancelApplicationRequestBOP.setUser(user);
		
		ArrayList<CancelApplicationBOP> applications = new ArrayList<CancelApplicationBOP>();
		
		CancelApplicationBOP cancelApplicationBOP = new CancelApplicationBOP();
		cancelApplicationBOP.setFolioApplication("50385889");
		cancelApplicationBOP.setProcessId("41af0a3526b411e7b18f000000526c32");
		applications.add( cancelApplicationBOP );
		
		cancelApplicationBOP = new CancelApplicationBOP();
		cancelApplicationBOP.setFolioApplication("50385890");
		cancelApplicationBOP.setProcessId("f7ff67c926bc11e7958d000000526c32");
		applications.add( cancelApplicationBOP );
		
		cancelApplicationRequestBOP.setApplications(applications);
		
		CancelApplicationResponseBOP cancelApplicationResponseBOP = processImpl.cancellApplicationCxN( cancelApplicationRequestBOP );
		
		
		log.info( cancelApplicationResponseBOP.toString() );
		
		assertNotNull( cancelApplicationResponseBOP );
	}


}
