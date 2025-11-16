package com.consubanco.services.sap.crm.common.survey;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_ANSWER_Model;
import com.consubanco.sap.interfaces.common.survey.models.ZTL_QUESTION_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SaveSurveyCRMServiceImplTC extends TestCase {

	
	/**
	 * 
	 */
	public SaveSurveyCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveSurveyCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		SurveyCRMServiceImpl processImpl = new SurveyCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ZTE_SURVEY_Model surveyInputParams = new ZTE_SURVEY_Model();
        
        ArrayList<ZTL_QUESTION_Model> questionsList = new ArrayList<ZTL_QUESTION_Model>();
        ZTL_QUESTION_Model _question = new ZTL_QUESTION_Model();
        _question.setId("id_0050568032c41ee38abd357432c03c6e");
        _question.setNumberQuestion("0001");
        _question.setDescription("Depósitos en efectivo m.n");
        _question.setComponentType("FT");
        
        ArrayList<ZTL_ANSWER_Model> answersList = new ArrayList<ZTL_ANSWER_Model>();
        ZTL_ANSWER_Model _answer = new ZTL_ANSWER_Model();
        _answer.setDescription("Al mes ( mencionar número de depósitos aproximados)");
        _answer.setSelection(true);
        _answer.setFreeText("1");
        _answer.setId("id_0050568032c41ee38abd428b88fadc6e");
        _answer.setValueId("");
        answersList.add( _answer );
        
        _question.setAnswers( answersList );
        
        questionsList.add( _question );
        
        surveyInputParams.setQuestions( questionsList );
        
        surveyInputParams.setId("CUESTIONARIO CTC");
        surveyInputParams.setTextInfo("");
        surveyInputParams.setVersion("0000000017");
        surveyInputParams.setMasterLenguage("");
        surveyInputParams.setLanguage("S");
        surveyInputParams.setApplicationId("CRM_SURVEY_ACTIVITY");
        surveyInputParams.setValueGuid("");
        surveyInputParams.setValueVersion("0000000001");
        surveyInputParams.setValueVersionInfoText("");
        surveyInputParams.setValueXml("");
        surveyInputParams.setMust("");
        surveyInputParams.setNotChangeable("");
        surveyInputParams.setCreatedAt("0");
        surveyInputParams.setCreatedBy("");
        surveyInputParams.setModifiedAt("0");
        surveyInputParams.setModifiedBy("");
        surveyInputParams.setProcessMode("");
        surveyInputParams.setProcessText("");
        
		processImpl.saveSurvey("0070000063", "ZCAP","0010002444", surveyInputParams);
		
	}


	 
}
