package com.consubanco.services.sap.crm.common.survey;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class CreatePDFsSurveysCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CreatePDFsSurveysCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public CreatePDFsSurveysCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CreatePDFsSurveysCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		SurveyCRMServiceImpl processImpl = new SurveyCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList<String> customerIdList = new ArrayList<String>();
		customerIdList.add("0010002444");
		
		processImpl.createPDFsSurvey("0070000063", "ZCAP", customerIdList);
		
		
	}


	 
}
