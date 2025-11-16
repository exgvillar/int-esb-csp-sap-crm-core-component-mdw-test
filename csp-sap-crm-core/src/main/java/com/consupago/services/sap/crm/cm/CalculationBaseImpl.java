/**
 * 
 */
package com.consupago.services.sap.crm.cm;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_EMPLEADO_COMISION_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class CalculationBaseImpl implements ICalculationBase {

	private static Log log = LogFactory.getLog( CalculationBaseImpl.class );
	
	/**
	 * 
	 */
	public CalculationBaseImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.ICalculationBase#getCalculationBase(java.lang.String, java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getCalculationBase(
			String distributorSigla, String sucursalSigla, String idEmpleado) throws Exception {
		
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_EMPLEADO_COMISION_ProxyImpl proxy = new ZCRM_EMPLEADO_COMISION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDDISTRIBUIDOR");
        input.setValue( StringUtils.trimToEmpty( distributorSigla ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDSUCURSAL");
        input.setValue( StringUtils.trimToEmpty( sucursalSigla ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDEMPLEADO");
        input.setValue( StringUtils.trimToEmpty( idEmpleado ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}

}
