/**
 * 
 */
package com.consubanco.services.sap.crm.sic;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.esb.validator.utils.Formatter;
import com.consubanco.sap.interfaces.sic.ZFM_SIC_CONVENIOS_ProxyImpl;
import com.consubanco.sap.interfaces.sic.dependences.ZFM_SIC_CONVENIOS_DET_ProxyImpl;
import com.consubanco.sap.interfaces.sic.dependences.ZFM_SIC_DEPEN_ProxyImpl;
import com.consubanco.sap.interfaces.sic.formalization.ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl;
import com.consubanco.sap.interfaces.sic.requests.ZFM_SIC_DATOS_DINAMICOS_ProxyImpl;
import com.consubanco.sap.interfaces.sic.requests.ZFM_SIC_ORIG_ProxyImpl;
import com.consubanco.sap.interfaces.sic.requests.ZFM_SIC_RECIBO_NOMINA_ProxyImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class SICCRMServiceImpl implements SICCRMService {

	private static Log log = LogFactory.getLog( SICCRMServiceImpl.class );
	/**
	 * 
	 */
	public SICCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sic#getAgreementsByBP( String bpId ) throws Exception
	 */
	public ArrayList<IProxyOutputData> getAgreementsByBP( String bpId ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZFM_SIC_CONVENIOS_ProxyImpl proxy = new ZFM_SIC_CONVENIOS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_PARTNER");
        if( StringUtils.isNotEmpty( bpId ) )
        	input.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty( bpId ), 10 ) );
        else
        	input.setValue( StringUtils.trimToEmpty( bpId ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sic#getDependenceByAgreement( String agreementId ) throws Exception
	 */
	public ArrayList<IProxyOutputData> getDependenceByAgreement( String agreementId ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZFM_SIC_CONVENIOS_DET_ProxyImpl proxy = new ZFM_SIC_CONVENIOS_DET_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_CONV");
        input.setValue( agreementId );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sic#getDependenceDetail( String dependenceId ) throws Exception
	 */
	public ArrayList<IProxyOutputData> getDependenceDetail( String dependenceId ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZFM_SIC_DEPEN_ProxyImpl proxy = new ZFM_SIC_DEPEN_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_PARTNER");
        input.setValue( dependenceId );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sic#getOriginationDetail( String requestId ) throws Exception
	 */
	public ArrayList<IProxyOutputData> getOriginationDetail( String requestId ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZFM_SIC_ORIG_ProxyImpl proxy = new ZFM_SIC_ORIG_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft(requestId, 10) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sic#getDynamicsFieldsRequest( String requestId ) throws Exception
	 */
	public ArrayList<IProxyOutputData> getDynamicsFieldsRequest( String requestId ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZFM_SIC_DATOS_DINAMICOS_ProxyImpl proxy = new ZFM_SIC_DATOS_DINAMICOS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft(requestId, 10) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        ZFM_SIC_RECIBO_NOMINA_ProxyImpl proxyRN = new ZFM_SIC_RECIBO_NOMINA_ProxyImpl();
        ArrayList<IProxyOutputData> returnDataRN = proxyRN.executeRemoteFunction(destination, inputParams );
        if( returnDataRN != null ){
        	Iterator<IProxyOutputData> i = returnDataRN.iterator();
        	while( i.hasNext() ){
        		returnData.add( i.next() );
        	}
        }
 		return ( returnData );
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.sic#getRequestsFormalized( Date start, Date end ) throws Exception
	 */
	public ArrayList<IProxyOutputData> getRequestsFormalized( Date start, Date end ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl proxy = new ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_FINI");
        input.setDateValue( start );
        input.setType("java.util.Date");
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FFIN");
        input.setDateValue( end );
        input.setType("java.util.Date");
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        
 		return ( returnData );
	}
	
}
