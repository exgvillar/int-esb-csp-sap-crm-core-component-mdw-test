package com.consupago.services.sap.crm.recomendados;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author omar.corona
 *
 */
public class UpdateServiceOrderByReferenceRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( UpdateServiceOrderByReferenceRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public UpdateServiceOrderByReferenceRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public UpdateServiceOrderByReferenceRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testUpdateServiceOrderByReference( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();

		ArrayList returnList = processImpl.updateServiceOrderByReference("201506091525000108", "E0010", Date.valueOf("2015-06-09"));
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

}
