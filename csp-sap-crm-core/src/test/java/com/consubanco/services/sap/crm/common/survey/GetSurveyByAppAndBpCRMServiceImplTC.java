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
public class GetSurveyByAppAndBpCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetSurveyByAppAndBpCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetSurveyByAppAndBpCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetSurveyByAppAndBpCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		SurveyCRMServiceImpl processImpl = new SurveyCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ZTE_SURVEY_Model returnList = processImpl.getSurveyByAppAndBp("70000836", "ZCAP", "0000578020");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
