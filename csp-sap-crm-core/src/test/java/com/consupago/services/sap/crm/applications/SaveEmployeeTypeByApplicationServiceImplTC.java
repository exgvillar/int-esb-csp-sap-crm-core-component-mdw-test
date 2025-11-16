package com.consupago.services.sap.crm.applications;


import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SaveEmployeeTypeByApplicationServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveEmployeeTypeByApplicationServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveEmployeeTypeByApplicationServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveEmployeeTypeByApplicationServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		ApplicationsImpl processImpl = new ApplicationsImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		boolean result = processImpl.saveEmployeeTypeByApplication("50004855", "CONFIANZA");
		
		log.info( result );
		
		assertEquals(true, result);
	}


	 
}
