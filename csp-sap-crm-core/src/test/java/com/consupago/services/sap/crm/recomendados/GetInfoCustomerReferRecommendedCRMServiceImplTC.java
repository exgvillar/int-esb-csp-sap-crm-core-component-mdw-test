package com.consupago.services.sap.crm.recomendados;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author omar.corona
 *
 */
public class GetInfoCustomerReferRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetInfoCustomerReferRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetInfoCustomerReferRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetInfoCustomerReferRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testGetInfoCustomerRefer( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getInfoCustomerRefer("578005");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	 
}
