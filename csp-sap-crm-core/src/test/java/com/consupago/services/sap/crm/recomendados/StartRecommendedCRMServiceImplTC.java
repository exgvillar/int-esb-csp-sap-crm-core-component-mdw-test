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
public class StartRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( StartRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public StartRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public StartRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testStartRecommended( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.startRecommended("50449687");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	 
}
