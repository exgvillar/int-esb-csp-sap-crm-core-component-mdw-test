/**
 * 
 */
package com.consupago.services.sap.crm.ivr;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.esb.validator.utils.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ivr.ZRFC_IVR_GET_CREDITS_ProxyImpl;
import com.consupago.sap.interfaces.proxy.ivr.ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl;
import com.consupago.sap.interfaces.proxy.ivr.ZRFC_IVR_VALGET_PARTNER_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class IVRServiceImpl implements IIVRService {

	private static Log log = LogFactory.getLog( IVRServiceImpl.class );
	/**
	 * 
	 */
	public IVRServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.ivr.IIVRService#getBusinessPartner( long clientId, int typeBussinesPartner)
	 */
	public ArrayList<IProxyOutputData> getBusinessPartner(long clientId, int typeBussinesPartner) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_IVR_VALGET_PARTNER_ProxyImpl proxy = new ZRFC_IVR_VALGET_PARTNER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENTID");
        input.setValue( StringUtils.trimToEmpty( ""+clientId ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TYPE");
        input.setValue( StringUtils.trimToEmpty( ""+typeBussinesPartner ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.ivr.IIVRService#getCreditRequests( long clientId, int typeBussinesPartner, long creditRequestId ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getCreditRequests(long clientId, int typeBussinesPartner, long creditRequestId) throws Exception 
	{
				
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_IVR_GET_CREDITS_ProxyImpl proxy = new ZRFC_IVR_GET_CREDITS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENTID");
        input.setValue( StringUtils.trimToEmpty( ""+clientId ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TYPE");
        input.setValue( StringUtils.trimToEmpty( ""+typeBussinesPartner ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CREDITID");
        input.setValue( StringUtils.trimToEmpty( ""+creditRequestId ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getInfoCRMTickets(String ticketId) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl proxyImpl = new ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParamtersList = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TICKET");
        input.setValue( StringUtils.trimToEmpty( Formatter.fillStringWithZerosOnLeft(ticketId, 10) ) );
        inputParamtersList.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList );
        
       
		return ( returnData );

	}

}
