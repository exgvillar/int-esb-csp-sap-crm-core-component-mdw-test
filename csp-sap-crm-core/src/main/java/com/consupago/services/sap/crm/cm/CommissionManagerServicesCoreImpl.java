/**
 * 
 */
package com.consupago.services.sap.crm.cm;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_BP_TOTAL_SEGURO_OutputData;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_BP_TOTAL_SEGURO_ProxyImpl;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_EMPLEADO_NIVEL_ProxyImpl;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_PUESTOS_SUCURSAL_OutputData;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_PUESTOS_SUCURSAL_ProxyImpl;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_SUCURSAL_TOTALES_OutputData;
import com.consupago.sap.interfaces.proxy.cm.ZCRM_SUCURSAL_TOTALES_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class CommissionManagerServicesCoreImpl implements ICommissionManagerServices {
	
	private static Log log = LogFactory.getLog( CommissionManagerServicesCoreImpl.class );

	/**
	 * 
	 */
	public CommissionManagerServicesCoreImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.ICMTotalByBranch#getTotalPerBranch(java.lang.String, java.sql.Date, java.sql.Date)
	 */
	public ArrayList<IProxyOutputData> getTotalPerBranch(String branch,
			Date fechaInicio, Date fechaFin) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_SUCURSAL_TOTALES_ProxyImpl proxy = new ZCRM_SUCURSAL_TOTALES_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDSUCURSAL");
        input.setValue( StringUtils.trim( branch ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_INICIO");
        input.setDateValue( SAPFormatter.convertUtilDate2SqlDate( fechaInicio ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_FIN");
        input.setDateValue( SAPFormatter.convertUtilDate2SqlDate( fechaFin ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        if( returnData.isEmpty() ) {
        	ZCRM_SUCURSAL_TOTALES_OutputData output = new ZCRM_SUCURSAL_TOTALES_OutputData();
        	returnData.add( output );
        }
        
        return( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.ICommissionManagerServices#getBusinessPartnerInsuranceTotals(java.lang.String, java.sql.Date, java.sql.Date)
	 */
	public ArrayList<IProxyOutputData> getBusinessPartnerSalesTotals(
			String bpId, String puesto, Date fechaInicio, Date fechaFin) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_BP_TOTAL_SEGURO_ProxyImpl proxy = new ZCRM_BP_TOTAL_SEGURO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDBP");
        input.setValue( StringUtils.trim( bpId ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("PUESTO");
        input.setValue( StringUtils.trim( puesto ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_INICIO");
        input.setDateValue( SAPFormatter.convertUtilDate2SqlDate( fechaInicio ) );
        input.setType("java.util.date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_FIN");
        input.setDateValue( SAPFormatter.convertUtilDate2SqlDate( fechaFin ) );
        input.setType("java.util.date");
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        if( returnData.isEmpty() ) {
        	ZCRM_BP_TOTAL_SEGURO_OutputData tableData = new ZCRM_BP_TOTAL_SEGURO_OutputData();
        	returnData.add( tableData );
        }
        
        return( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.cm.ICommissionManagerServices#getEmpleadoMultinivel(java.lang.String, java.lang.String, java.sql.Date, java.sql.Date)
	 */
	public ArrayList<IProxyOutputData> getEmpleadoMultinivel(String idEmpleado,
			String puesto, Date fechaInicio, Date fechaFin) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_EMPLEADO_NIVEL_ProxyImpl proxy = new ZCRM_EMPLEADO_NIVEL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDEMPLEADO");
        input.setValue( StringUtils.trim( idEmpleado ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("PUESTO");
        input.setValue( StringUtils.trim( puesto ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_INICIO");
        input.setDateValue( SAPFormatter.convertUtilDate2SqlDate( fechaInicio ) );
        input.setType("java.util.date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_FIN");
        input.setDateValue( SAPFormatter.convertUtilDate2SqlDate( fechaFin ) );
        input.setType("java.util.date");
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
                
        return( returnData );
	}

	public ArrayList<IProxyOutputData> getNumberPersonsInSamePosition( String idEmpleado, String puesto, ArrayList<String> sucursalesList ) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_PUESTOS_SUCURSAL_ProxyImpl proxy = new ZCRM_PUESTOS_SUCURSAL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDEMPLEADO");
        input.setValue( StringUtils.trim( idEmpleado ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDPUESTO");
        input.setValue( StringUtils.trim( puesto ) );
        inputParams.add( input );
        
       
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, sucursalesList );
        
        if( returnData.isEmpty() ) {
        	ZCRM_PUESTOS_SUCURSAL_OutputData tableData = new ZCRM_PUESTOS_SUCURSAL_OutputData();
        	returnData.add( tableData );
        }
        
        return( returnData );
        
	}
}
