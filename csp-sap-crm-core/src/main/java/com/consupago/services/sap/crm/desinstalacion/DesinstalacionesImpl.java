/**
 * 
 */
package com.consupago.services.sap.crm.desinstalacion;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.valdep.instalacion.ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData;
import com.consubanco.sap.interfaces.valdep.instalacion.ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl;
import com.consubanco.services.sap.crm.commons.utils.Formatter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.applications.ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl;
import com.consupago.sap.interfaces.proxy.applications.ZCRMCI_E002_SOLNOMTEMPL_ProxyImpl;
import com.consupago.sap.interfaces.proxy.applications.ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl;
import com.consupago.sap.interfaces.proxy.applications.model.ZTL_SOLICITUD_Model;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_ESTATUS_Model;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class DesinstalacionesImpl {

	private static Log log = LogFactory.getLog( DesinstalacionesImpl.class );
	
	/**
	 * 
	 */
	public DesinstalacionesImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.IApplicationsService#saveEmployeeTypeByApplication( String request, String employeeType )
	 */
	public ArrayList<ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData> getDesinstalacionesInfo( String request ) throws Exception {
		boolean result = false;
		CRMLocalConfigEnvironmentData.instance();
		
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl proxy = new ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl();
        
        ArrayList<ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData> arrDesintalar = proxy.executeRemoteFunction(destination );
        
		return ( arrDesintalar );
	}

	/**
	 * 
	 */
	
}
