package com.consubanco.services.sap.crm.common.survey;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class GetSurveyCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetSurveyCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetSurveyCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetSurveyCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		SurveyCRMServiceImpl processImpl = new SurveyCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ZTE_SURVEY_Model returnList = processImpl.getSurvey("CUESTIONARIO CTC");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
