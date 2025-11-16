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
public class GetServiceOrderByStatusRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetServiceOrderByStatusRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetServiceOrderByStatusRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetServiceOrderByStatusRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}

	public void testGetServiceOrderByStatus( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();

		ArrayList<String> statusList = new ArrayList<String>();
		statusList.add("E0001");
		statusList.add("E0011");

		ArrayList returnList = processImpl.getServiceOrderByStatus(statusList);
 
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	 
}
