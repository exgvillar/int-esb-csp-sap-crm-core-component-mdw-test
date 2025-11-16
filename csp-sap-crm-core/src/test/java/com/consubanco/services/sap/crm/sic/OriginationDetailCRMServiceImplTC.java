package com.consubanco.services.sap.crm.sic;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class OriginationDetailCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( OriginationDetailCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public OriginationDetailCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public OriginationDetailCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		SICCRMServiceImpl processImpl = new SICCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getOriginationDetail( "50096296" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
