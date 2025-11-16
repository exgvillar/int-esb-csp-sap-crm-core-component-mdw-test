/**
 * 
 */
package com.consupago.services.sap.crm.cm;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_EMPLEADO_COMISION_ProxyImpl;
import com.consupago.sap.interfaces.proxy.cm.catalogs.ZCRM_DISTRIBUIDOR_COMISION_ProxyImpl;
import com.consupago.sap.interfaces.proxy.cm.catalogs.ZCRM_SUCURSAL_COMISION_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class HRPServiceImpl implements IHRPService {

	private static Log log = LogFactory.getLog( HRPServiceImpl.class );
	
	/**
	 * 
	 */
	public HRPServiceImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.IHRPService#getBranchesByDistributor(java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getBranchesByDistributor(
			String distributorSigla) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_SUCURSAL_COMISION_ProxyImpl proxy = new ZCRM_SUCURSAL_COMISION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDDISTRIBUIDOR");
        input.setValue( StringUtils.trimToEmpty( distributorSigla ) );        
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.IHRPService#getDistributors()
	 */
	public ArrayList<IProxyOutputData> getDistributors() throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_DISTRIBUIDOR_COMISION_ProxyImpl proxy = new ZCRM_DISTRIBUIDOR_COMISION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.IHRPService#getPersonalByBranch(java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getPersonalByBranch(String distributorSigla, String branchSigla)
			throws Exception {
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_EMPLEADO_COMISION_ProxyImpl proxy = new ZCRM_EMPLEADO_COMISION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDDISTRIBUIDOR");
        input.setValue( StringUtils.trimToEmpty( distributorSigla ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDSUCURSAL");
        input.setValue( StringUtils.trimToEmpty( branchSigla ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return( returnData );
	}

}
