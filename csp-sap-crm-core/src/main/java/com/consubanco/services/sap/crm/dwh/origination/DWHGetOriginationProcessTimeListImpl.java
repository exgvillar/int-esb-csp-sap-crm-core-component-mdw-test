/**
 * 
 */
package com.consubanco.services.sap.crm.dwh.origination;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.dwh.origination.ZRFC_GEN_GET_DATSOL_InputData;
import com.consubanco.sap.interfaces.dwh.origination.ZRFC_GEN_GET_DATSOL_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class DWHGetOriginationProcessTimeListImpl implements IDWHGetProcessTimeService {

	private static Log log = LogFactory.getLog( DWHGetOriginationProcessTimeListImpl.class );
	
	/**
	 * 
	 */
	public DWHGetOriginationProcessTimeListImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.convenios.IConveniosInfoService#getConveniosLegalDates(java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getOriginationProcessTimeList( ArrayList<ZRFC_GEN_GET_DATSOL_InputData> inputParams ) throws Exception {

		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_GEN_GET_DATSOL_ProxyImpl proxy = new ZRFC_GEN_GET_DATSOL_ProxyImpl();              
       
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
      
        return( returnData );
	}

}
