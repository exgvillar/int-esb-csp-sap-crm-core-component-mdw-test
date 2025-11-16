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
public class DependencesByAgreementCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( DependencesByAgreementCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public DependencesByAgreementCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public DependencesByAgreementCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		SICCRMServiceImpl processImpl = new SICCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getDependenceByAgreement( "10000124" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
