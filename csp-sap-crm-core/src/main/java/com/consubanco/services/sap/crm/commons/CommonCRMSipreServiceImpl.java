/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.consubanco.sap.interfaces.commons.sipre.ZCRMADS_E001_GETINFOGENERAL_ProxyImpl;
import com.consubanco.sap.interfaces.commons.sipre.ZCRMADS_P001_TASKSIPRE_ProxyImpl;
import com.consubanco.sap.interfaces.commons.sipre.ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImpl;
import com.consubanco.services.sap.crm.commons.sipre.ChangeStatusSipreRequest;
import com.consubanco.services.sap.crm.commons.sipre.DocumentRequest;
import com.consubanco.services.sap.crm.commons.sipre.GetInfoGeneralSipreRequest;
import com.consubanco.services.sap.crm.commons.sipre.SipreDataTaskRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class CommonCRMSipreServiceImpl implements CommonCRMSipreService {
	
	private static final String JCO_DESTINATION = "CSPSAPCRM";
	
	/**
	 * 
	 */
	public CommonCRMSipreServiceImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.CommonCRMSipreService#changeStatusSipre(com.consubanco.services.sap.crm.commons.sipre.ChangeStatusSipreRequest)
	 */
	public List<IProxyOutputData> changeStatusSipre(ChangeStatusSipreRequest request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(JCO_DESTINATION);
        
		ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImpl proxy = new ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImpl();
        
		List<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TAKS");
        input.setValue( request.getTaskId());
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_STATUSID");
        input.setValue( request.getStatusId());
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NOTE");
        input.setValue( request.getMessage());
        inputParams.add( input );      
                
		return proxy.executeRemoteFunction(destination, inputParams );
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.CommonCRMSipreService#createSipreDataTask(com.consubanco.services.sap.crm.commons.sipre.SipreDataTaskRequest)
	 */
	public List<IProxyOutputData> createSipreDataTask(SipreDataTaskRequest request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(JCO_DESTINATION);
		
		ZCRMADS_P001_TASKSIPRE_ProxyImpl proxy = new ZCRMADS_P001_TASKSIPRE_ProxyImpl();
		
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_AUXILIAR");
        input.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(request.getPromotorBp()), 10) );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLIENT");
        input.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(request.getCustomerBp()), 10) );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCRIPTION");
        input.setValue( request.getDescription() );
        inputParams.getGeneralParam().add( input );   
        input = new ProxyInputParameter();
        input.setKey("I_FOLIO_BIO");
        input.setValue( request.getFolioBiometric() );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ID_BRANCH");
        input.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(request.getBranchId()), 10) );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NSS");
        input.setValue( request.getNss() );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_EMAIL");
        input.setValue( request.getMail());
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TELEPHONE");
        input.setValue( request.getTelephone() );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TASKID");
        input.setValue( request.getTaskId() );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CHANNEL");
        input.setValue( request.getChannel() );
        inputParams.getGeneralParam().add( input );
        
    	for (int i=0; i < request.getDocuments().size(); i++){
    		DocumentRequest documentRequest = request.getDocuments().get(i);
			List<ProxyInputParameter> inputTxts = new ArrayList<ProxyInputParameter>();
    		
    		ProxyInputParameter inputTxt = new ProxyInputParameter();
    		inputTxt.setKey("FILENAME");
    		inputTxt.setValue( documentRequest.getFilename() );
    		inputTxts.add(inputTxt);
    		inputTxt = new ProxyInputParameter();
    		inputTxt.setKey("BIN");
    		inputTxt.setValue( documentRequest.getBase64() );
    		inputTxts.add(inputTxt);
    		inputParams.getRecordParam().add( inputTxts );
    	}
		
		return proxy.executeRemoteFunction(destination, inputParams );
		
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.CommonCRMSipreService#getInfoGeneralSipre(com.consubanco.services.sap.crm.commons.sipre.GetInfoGeneralSipreRequest)
	 */
	public List<IProxyOutputData> getInfoGeneralSipre(GetInfoGeneralSipreRequest request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(JCO_DESTINATION);
		
		ZCRMADS_E001_GETINFOGENERAL_ProxyImpl proxy = new ZCRMADS_E001_GETINFOGENERAL_ProxyImpl();
		
		ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
	    inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
	    
	    ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_TASK");
        input.setValue( request.getTaskId() );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( request.getCustomerBP());
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CURP");
        input.setValue( request.getCurp() );
        inputParams.getGeneralParam().add( input );
        
        return proxy.executeRemoteFunction(destination, inputParams );
	}
}
