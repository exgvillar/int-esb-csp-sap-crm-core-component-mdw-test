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
public class DependenceDetailCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( DependenceDetailCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public DependenceDetailCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public DependenceDetailCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		SICCRMServiceImpl processImpl = new SICCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getDependenceDetail( "17500133" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
