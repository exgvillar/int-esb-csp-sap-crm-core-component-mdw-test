package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SearchAddressBPCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SearchAddressBPCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public SearchAddressBPCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SearchAddressBPCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	
	
	public void testAuthSearchAddress( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.searchAddress("543723");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
	
			 
}
