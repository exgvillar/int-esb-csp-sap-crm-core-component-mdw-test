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
public class GetAttributesMktBPCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetAttributesMktBPCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetAttributesMktBPCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetAttributesMktBPCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	
	
	public void testAuth( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getAttributesMarketingBP("543723");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
	
			 
}
