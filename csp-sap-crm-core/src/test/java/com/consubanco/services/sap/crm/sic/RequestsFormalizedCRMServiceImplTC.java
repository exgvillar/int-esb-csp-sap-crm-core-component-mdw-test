package com.consubanco.services.sap.crm.sic;

import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class RequestsFormalizedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( RequestsFormalizedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public RequestsFormalizedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public RequestsFormalizedCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		SICCRMServiceImpl processImpl = new SICCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		Calendar start = Calendar.getInstance();
		start.set(Calendar.YEAR, 2013);
		start.set(Calendar.MONTH, 6);
		start.set(Calendar.DAY_OF_MONTH, 19);

		Calendar end = Calendar.getInstance();
		end.set(Calendar.YEAR, 2013);
		end.set(Calendar.MONTH, 6);
		end.set(Calendar.DAY_OF_MONTH, 20);
		
		ArrayList returnList = processImpl.getRequestsFormalized( start.getTime(), end.getTime() );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
