package com.consupago.services.sap.crm.ivr;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class IVRServiceGetCreditRequestsImplTC extends TestCase {

	private static Log log = LogFactory.getLog( IVRServiceGetCreditRequestsImplTC.class );
	
	/**
	 * 
	 */
	public IVRServiceGetCreditRequestsImplTC() {
		
	}

	/**
	 * @param name
	 */
	public IVRServiceGetCreditRequestsImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		IVRServiceImpl processImpl = new IVRServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		//ArrayList returnList = processImpl.getCreditRequests(12345, 1, 50095471);
		//ArrayList returnList = processImpl.getCreditRequests(17105587, 2, 0);
		ArrayList returnList = processImpl.getCreditRequests(12345, 1, 0);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
