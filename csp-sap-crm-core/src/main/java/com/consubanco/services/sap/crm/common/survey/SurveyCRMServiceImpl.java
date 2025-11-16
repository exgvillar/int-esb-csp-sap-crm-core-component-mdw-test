/**
 * 
 */
package com.consubanco.services.sap.crm.common.survey;


import java.util.ArrayList;
import java.util.Iterator;

import com.consubanco.esb.validator.utils.Formatter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.ZCRMORI_E103_READ_PBRMS1_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.ZCRMORI_E103_READ_PBRMS_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P100_CREA_PDFS_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P102_GET_QUEST_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P103_PUT_QUEST_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P103_PUT_QUEST1_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consubanco.sap.interfaces.exceptions.ComponentException;
import com.consubanco.sap.interfaces.exceptions.RFCExecutionException;
import com.consubanco.sap.interfaces.exceptions.RFCNotFoundException;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

/**
 * @author ramon.becerra
 *
 */
public class SurveyCRMServiceImpl implements SurveyCRMService {

	private static Log log = LogFactory.getLog( SurveyCRMServiceImpl.class );
	/**
	 * 
	 */
	public SurveyCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.survey#getSurvey( String folioApplication, String surveyId ) throws Exception;
	 */
	public ZTE_SURVEY_Model getSurvey( String surveyId ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_P102_GET_QUEST_ProxyImpl proxy = new ZCRMORI_P102_GET_QUEST_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SURVEYID");
        input.setValue( surveyId );
        inputParams.add( input );
		
        ZTE_SURVEY_Model result = proxy.executeRemoteFunction(destination, inputParams );
        
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.survey#saveSurvey( String folioApplication, ZTE_SURVEY_Model surveyInputParams ) throws Exception;
	 */
	public void saveSurvey( String folioApplication, String documentType, String customerId, ZTE_SURVEY_Model surveyInputParams ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_P103_PUT_QUEST_ProxyImpl proxy = new ZCRMORI_P103_PUT_QUEST_ProxyImpl();
        
		proxy.executeRemoteFunction(destination, 
				Formatter.fillStringWithZerosOnLeft( folioApplication, 10),
				documentType,
				Formatter.fillStringWithZerosOnLeft( customerId, 10),
				surveyInputParams );
        
		return;
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.survey#createPDFsSurvey( String folioApplication, ArrayList<String> customersIds ) throws Exception;;
	 */
	public void createPDFsSurvey( String folioApplication, String documentType, ArrayList<String> customersIds ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_P100_CREA_PDFS_ProxyImpl proxy = new ZCRMORI_P100_CREA_PDFS_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParams = null;
	
		if( customersIds != null ){
			Iterator<String> i = customersIds.iterator();
			while( i.hasNext() ){
				String customerId = (String)i.next();
				
				inputParams = new ArrayList<ProxyInputParameter>();
				ProxyInputParameter input = new ProxyInputParameter();
		        input.setKey("I_SOLICITUD");
		        input.setValue( Formatter.fillStringWithZerosOnLeft(folioApplication, 10) );
		        inputParams.add( input );
		        input = new ProxyInputParameter();
		        input.setKey("I_TIPDOC");
		        input.setValue( documentType );
		        inputParams.add( input );
		        input = new ProxyInputParameter();
		        input.setKey("I_SURVEYID");
		        input.setValue( "" );
		        inputParams.add( input );
		        input = new ProxyInputParameter();
		        input.setKey("I_BP");
		        input.setValue( Formatter.fillStringWithZerosOnLeft(customerId, 10) );
		        inputParams.add( input );
		        
				proxy.executeRemoteFunction(destination, inputParams );
			}
		}
		
		
        
		return;
	}
	
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.survey#getSurveyBRMSParams( String folioApplication, String customerId ) throws Exception;
	 */
	public ZTE_SURVEY_Model getSurveyBRMSParams( String folioApplication, String documentType, String customerId, boolean brmsOnly ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_E103_READ_PBRMS_ProxyImpl proxy = new ZCRMORI_E103_READ_PBRMS_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft(folioApplication, 10) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPDOC");
        input.setValue( documentType );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SURVEYID");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( Formatter.fillStringWithZerosOnLeft(customerId, 10) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ONLYBRMS");
        input.setValue( brmsOnly ? "X" : "" );
        inputParams.add( input );
		
        ZTE_SURVEY_Model result = proxy.executeRemoteFunction(destination, inputParams );
        
		return result;
	}

		
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.survey#getSurveyByAppAndBp( String folioApplication, String customerId ) throws Exception;
	 */
	public ZTE_SURVEY_Model getSurveyByAppAndBp( String folioApplication, String documentType, String customerId ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_E103_READ_PBRMS_ProxyImpl proxy = new ZCRMORI_E103_READ_PBRMS_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft(folioApplication, 10) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPDOC");
        input.setValue( documentType );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SURVEYID");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( Formatter.fillStringWithZerosOnLeft(customerId, 10) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ONLYBRMS");
        input.setValue( "" );
        inputParams.add( input );
		
        ZTE_SURVEY_Model result = proxy.executeRemoteFunction(destination, inputParams );
        
		return result;
	}


	public void saveSurveyByBp(String customerBp, ZTE_SURVEY_Model surveyInputParams) throws RFCNotFoundException, RFCExecutionException, ComponentException {
		
		JCoDestination destination;
		try {
			destination = JCoDestinationManager.getDestination("CSPSAPCRM");
			ZCRMORI_P103_PUT_QUEST1_ProxyImpl proxy = new ZCRMORI_P103_PUT_QUEST1_ProxyImpl();
			proxy.executeRemoteFunction(destination,
					Formatter.fillStringWithZerosOnLeft( customerBp, 10),
					surveyInputParams );
		} catch (JCoException e) {
			throw new RFCNotFoundException("Error getting destination CSPSAPCRM: " + e.getClass().getSimpleName()+":"+ e.getMessage());
		}
	}

	public ZTE_SURVEY_Model getSurveyByBp(String customerBp, String surveyId, boolean isOnlyBrms)
			throws RFCNotFoundException, RFCExecutionException, ComponentException {
		ZTE_SURVEY_Model result = new ZTE_SURVEY_Model();
		JCoDestination destination;
		try {
			destination = JCoDestinationManager.getDestination("CSPSAPCRM");
			ZCRMORI_E103_READ_PBRMS1_ProxyImpl proxy = new ZCRMORI_E103_READ_PBRMS1_ProxyImpl();
			
			ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
			ProxyInputParameter input;
	        input = new ProxyInputParameter();
	        input.setKey("I_SURVEYID");
	        input.setValue( surveyId );
	        inputParams.add( input );
	        input = new ProxyInputParameter();
	        input.setKey("I_BP");
	        input.setValue( (StringUtils.trimToEmpty(customerBp).equals(""))?"":Formatter.fillStringWithZerosOnLeft(customerBp, 10) );
	        inputParams.add( input );
	        input = new ProxyInputParameter();
	        input.setKey("I_ONLYBRMS");
	        input.setValue(isOnlyBrms?"X":"");
	        inputParams.add( input );
			
	        result = proxy.executeRemoteFunction(destination, inputParams );
			
		} catch (JCoException e) {
			throw new RFCNotFoundException("Error getting destination CSPSAPCRM: " + e.getClass().getSimpleName()+":"+ e.getMessage());
		}
		
		return result;
	}
}
