/**
 * 
 */
package com.consupago.services.sap.crm.cdb;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cdb.ZRFC_ORIG_TOTMENS_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class CDBServiceImpl implements ICDBService {

	private static Log log = LogFactory.getLog( CDBServiceImpl.class );
	/**
	 * 
	 */
	public CDBServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cdb#getSalesAmountConvenio( String crmConvenio_Id ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getSalesAmountConvenio( String crmConvenio_Id ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZRFC_ORIG_TOTMENS_ProxyImpl proxy = new ZRFC_ORIG_TOTMENS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CONVENIO");
        input.setValue( StringUtils.trimToEmpty( ""+crmConvenio_Id ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	

}
