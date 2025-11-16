package com.consubanco.services.sap.crm.dispersion;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.format.SAPFormatter;

/**
 * @author hsanchez
 *
 */
public class UpdateDispersionOnlineFlagServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateDispersionOnlineFlagServiceImplTC.class );
	
	/**
	 * 
	 */
	public UpdateDispersionOnlineFlagServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateDispersionOnlineFlagServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DispersionCRMService processImpl = new DispersionCRMServiceImpl();
		
		
		boolean updated = processImpl.updateDispersionOnlineFlag( "" );
		
		log.info( updated );
		
		assertTrue( updated );
	}

}
