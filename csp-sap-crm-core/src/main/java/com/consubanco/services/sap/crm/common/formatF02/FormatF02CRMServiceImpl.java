/**
 * 
 */
package com.consubanco.services.sap.crm.common.formatF02;


import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.esb.validator.utils.Formatter;
import com.consubanco.sap.interfaces.common.formatF02.ZCRMORI_P015_ADDUPD_QEQDATA_ProxyImpl;
import com.consubanco.sap.interfaces.common.formatF02.ZRFC_PEPS_GET_ProxyImpl;
import com.consubanco.sap.interfaces.common.formatF02.ZRFC_PEPS_PUT_ProxyImpl;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class FormatF02CRMServiceImpl implements FormatF02CRMService {

	private static Log log = LogFactory.getLog( FormatF02CRMServiceImpl.class );
	/**
	 * 
	 */
	public FormatF02CRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.formatF02#saveFormatF02( String requestId, ZTL_PEPS_Model pepData ) throws Exception;
	 */
	public boolean saveFormatF02( String requestId, ZTL_PEPS_Model pepData ) throws Exception 
	{
		
		boolean result = false;
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_PEPS_PUT_ProxyImpl proxy = new ZRFC_PEPS_PUT_ProxyImpl();
        
		pepData.setNumSolicitud( Formatter.fillStringWithZerosOnLeft( pepData.getNumSolicitud() , 10) );
		pepData.setNumCliente( Formatter.fillStringWithZerosOnLeft(pepData.getNumCliente(), 10) );
		
		
        result = proxy.executeRemoteFunction(destination, pepData );
        
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.formatF02#saveQEQ( String customerId, String requestId, ZTL_PEPS_Model pepData ) throws Exception;
	 */
	public boolean saveQEQ( String customerId, String requestId, ZTL_PEPS_Model pepData ) throws Exception 
	{
		
		boolean result = false;
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_P015_ADDUPD_QEQDATA_ProxyImpl proxy = new ZCRMORI_P015_ADDUPD_QEQDATA_ProxyImpl();
        
        result = proxy.executeRemoteFunction(
        		destination, 
        		Formatter.fillStringWithZerosOnLeft(customerId, 10), 
        		Formatter.fillStringWithZerosOnLeft(requestId, 10),
        		pepData );
        
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.common.formatF02#getFormatF02( String applicationId, String customerId  ) throws Exception;
	 */
	public ZTL_PEPS_Model getFormatF02( String applicationId, String customerId ) throws Exception
	{
		
		ZTL_PEPS_Model model = null;
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_PEPS_GET_ProxyImpl proxy = new ZRFC_PEPS_GET_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENT");
        input.setValue( Formatter.fillStringWithZerosOnLeft( customerId, 10 ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( Formatter.fillStringWithZerosOnLeft( applicationId, 10 ) );
        inputParams.add( input );
        		
        model = proxy.executeRemoteFunction(destination, inputParams );
        
		return ( model );
	}
	
}
