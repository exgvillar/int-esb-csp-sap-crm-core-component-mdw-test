/**
 * 
 */
package com.consupago.services.sap.crm.applications;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class ApplicationsImpl implements IApplicationsService {

	private static Log log = LogFactory.getLog( ApplicationsImpl.class );
	
	/**
	 * 
	 */
	public ApplicationsImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.IApplicationsService#saveEmployeeTypeByApplication( String request, String employeeType )
	 */
	public boolean saveEmployeeTypeByApplication( String request, String employeeType ) throws Exception {
		boolean result = false;
		
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCI_E002_SOLNOMTEMPL_ProxyImpl proxy = new ZCRMCI_E002_SOLNOMTEMPL_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ACCION");
        input.setValue( "C" ); //'C' = Crear; 'D' = Borrar; 'V' = Visualizar
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("MANDT");
        inputRecord.setValue( "" ); 
        recordParams.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZSOL_NOMINA");
        inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( request , 10) );
        recordParams.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZTIPO_EMPL");
        inputRecord.setValue( employeeType );
        recordParams.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams );
        
        proxy.executeRemoteFunction(destination, inputParams );
        result = true;
        
		return ( result );
	}

	/**
	 * 
	 */
	public ArrayList<IProxyOutputData> getProductConvenioByApp( ArrayList<ZTL_SOLICITUD_Model> applications ) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl proxy = new ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl();
        
        for( int i = 0; i < applications.size(); i++ ){
        	ZTL_SOLICITUD_Model data = applications.get( i );
        	data.setApplicationId( Formatter.fillStringWithZerosOnLeft( data.getApplicationId() , 10) );
        	applications.set(i, data);
        }
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, applications );
        
		return ( returnData );
	}

	/*
	 * (non-Javadoc)
	 * @see com.consupago.services.sap.crm.applications.IApplicationsService#getApplicationByStatus(java.util.ArrayList)
	 */
	public ArrayList<IProxyOutputData> getApplicationByStatus( ArrayList<ZTT_ESTATUS_Model> statusList) throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl proxyImpl= new ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl();
		
		ArrayList<IProxyOutputData> returnData = null;
		returnData = proxyImpl.executeRemoteFunction(destination, statusList );
		
		log.info("ApplicationsCRMServiceImpl return: " + returnData.toString());
		
		return returnData;
	
	}
	
}
