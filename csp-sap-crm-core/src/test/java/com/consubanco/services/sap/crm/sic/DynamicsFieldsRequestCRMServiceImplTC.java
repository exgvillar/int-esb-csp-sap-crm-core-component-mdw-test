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
public class DynamicsFieldsRequestCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( DynamicsFieldsRequestCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public DynamicsFieldsRequestCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public DynamicsFieldsRequestCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		SICCRMServiceImpl processImpl = new SICCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getDynamicsFieldsRequest( "50029944" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
