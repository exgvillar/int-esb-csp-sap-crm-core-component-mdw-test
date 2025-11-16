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
public class GetSurveyBRMSParamsCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetSurveyBRMSParamsCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetSurveyBRMSParamsCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetSurveyBRMSParamsCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		SurveyCRMServiceImpl processImpl = new SurveyCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		String folioApplication = "70000517"; 
		String documentType = "ZCAP";
		String customerId = "2610153";
		boolean brmsOnly = false;
		
		
		ZTE_SURVEY_Model returnList = processImpl.getSurveyBRMSParams(folioApplication, documentType, customerId, brmsOnly);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
