/**
 * 
 */
package com.consupago.services.sap.crm.convenios;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.convenios.ZFM_FECHAS_JURIDICO_OutputData;
import com.consupago.sap.interfaces.proxy.convenios.ZFM_FECHAS_JURIDICO_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ConveniosLegalDatesImpl implements IConveniosInfoService {

	private static Log log = LogFactory.getLog( ConveniosLegalDatesImpl.class );
	
	/**
	 * 
	 */
	public ConveniosLegalDatesImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.convenios.IConveniosInfoService#getConveniosLegalDates(java.lang.String)
	 */
	public ZFM_FECHAS_JURIDICO_OutputData getConveniosLegalDates(
			String productId) throws Exception {
		ZFM_FECHAS_JURIDICO_OutputData resultData = new ZFM_FECHAS_JURIDICO_OutputData();
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZFM_FECHAS_JURIDICO_ProxyImpl proxy = new ZFM_FECHAS_JURIDICO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("PRODUCT_ID");
        input.setValue( StringUtils.trim( productId ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Iterator iter = returnData.iterator();
        while( iter.hasNext() ) {
        	resultData = (ZFM_FECHAS_JURIDICO_OutputData) iter.next();
        	break;
        }
        return( resultData );
	}

}
