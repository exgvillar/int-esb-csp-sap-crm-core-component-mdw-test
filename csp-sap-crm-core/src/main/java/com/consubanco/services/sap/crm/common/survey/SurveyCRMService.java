package com.consubanco.services.sap.crm.common.survey;


import java.util.ArrayList;

import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.exceptions.ComponentException;
import com.consubanco.sap.interfaces.exceptions.RFCExecutionException;
import com.consubanco.sap.interfaces.exceptions.RFCNotFoundException;




public interface SurveyCRMService {

	public ZTE_SURVEY_Model getSurvey( String surveyId ) throws Exception;
	
	public void saveSurvey( String folioApplication, String documentType, String customerId, ZTE_SURVEY_Model surveyInputParams ) throws Exception;
	
	public void createPDFsSurvey( String folioApplication, String documentType, ArrayList<String> customersIds ) throws Exception;
	
	public ZTE_SURVEY_Model getSurveyBRMSParams( String folioApplication, String documentType, String customerId, boolean brmsOnly ) throws Exception;
	
	public ZTE_SURVEY_Model getSurveyByAppAndBp( String folioApplication, String documentType, String customerId ) throws Exception;
	
	public void saveSurveyByBp( String customerBp, ZTE_SURVEY_Model surveyInputParams ) throws RFCNotFoundException, RFCExecutionException, ComponentException;

	public ZTE_SURVEY_Model getSurveyByBp( String customerBp, String surveyId, boolean isOnlyBrms ) throws RFCNotFoundException, RFCExecutionException, ComponentException;

	
}
