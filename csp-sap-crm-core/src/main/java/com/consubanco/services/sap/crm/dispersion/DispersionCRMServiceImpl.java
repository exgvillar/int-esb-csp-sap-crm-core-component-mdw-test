/**
 * 
 */
package com.consubanco.services.sap.crm.dispersion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.status.ZCRMLCOM_E004_GET_DOC_STATUS_OutputData;
import com.consubanco.sap.interfaces.common.status.ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl;
import com.consubanco.sap.interfaces.dispersion.ZCRMTESO_DISPERSION_DUP_ProxyImpl;
import com.consubanco.sap.interfaces.dispersion.ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl;
import com.consubanco.sap.interfaces.dispersion.ZCRMTESO_UPD_IND_DISPAUTO_ProxyImpl;
import com.consubanco.sap.interfaces.dispersion.ZCRMUTIL_GET_HABINHAB_OutputData;
import com.consubanco.sap.interfaces.dispersion.ZCRMUTIL_GET_HABINHAB_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_SOLICITUD_CASO_OutputData;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_SOLICITUD_CASO_ProxyImpl;
import com.consupago.sap.interfaces.proxy.incidencias.ZRFC_INCIDENCIAS_SOLIC_ProxyImpl;
import com.consupago.sap.interfaces.proxy.incidencias.ZRFC_SET_INCIDENCIAS_ProxyImpl;
import com.consupago.sap.interfaces.proxy.lcom.commons.ZRFC_SOL_COUNT_ADD_ProxyImpl;
import com.consupago.sap.interfaces.proxy.lcom.commons.ZRFC_SOL_COUNT_READ_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class DispersionCRMServiceImpl implements DispersionCRMService {

	private static Log log = LogFactory.getLog( DispersionCRMServiceImpl.class );
	/**
	 * 
	 */
	public DispersionCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<IProxyOutputData> dispersionDuplicity( String documentId, String event, boolean remove ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMTESO_DISPERSION_DUP_ProxyImpl proxy = new ZCRMTESO_DISPERSION_DUP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_DOCUMENTO");
        input.setValue( Formatter.fillStringWithZerosOnLeft( documentId, 10 ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_EVENTO");
        input.setValue( event );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DELETE");
        input.setValue( remove ? "X" : "" );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	/**
	 * 
	 */
	public ZCRMLCOM_E004_GET_DOC_STATUS_OutputData checkDocumentStatus( String documentId, String documentType ) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl proxy = new ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl();

    	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
    	ProxyInputParameter input = new ProxyInputParameter();
    	input.setKey("I_NUMDOC");
    	input.setValue( Formatter.fillStringWithZerosOnLeft( documentId, 10 ) );
    	inputParams.add( input );

    	input = new ProxyInputParameter();
    	input.setKey("I_TIPDOC");
    	input.setValue( documentType );
    	inputParams.add( input );

    	ZCRMLCOM_E004_GET_DOC_STATUS_OutputData dataOut = proxy.executeRemoteFunction(destination, inputParams );
    	
    	log.info( dataOut );
    	
    	return( dataOut );
	}
	
	/**
	 * 
	 */
	public boolean updateDispersionOnlineFlag( String flag ) throws Exception {
		boolean updated = false;
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTESO_UPD_IND_DISPAUTO_ProxyImpl proxy = new ZCRMTESO_UPD_IND_DISPAUTO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_INDICADOR");
        input.setValue( flag );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        updated = true;
        log.info( returnData.toString() );
        
        return( updated );
	}
	
	/***
	 * 
	 */
	public ArrayList<IProxyOutputData> getDispersionOnlineFlag( ) throws Exception {
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl proxy = new ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        return( returnData );
	}
	
	/**
	 * 
	 */
	public boolean calendarValidatedDay( Date currentDate, String calendarType ) throws Exception {
		
		boolean laborableDay = false;
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMUTIL_GET_HABINHAB_ProxyImpl proxy = new ZCRMUTIL_GET_HABINHAB_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_DATE");
        input.setDateValue( currentDate );
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALENDAR");
        input.setValue( calendarType );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        Iterator iter = returnData.iterator();
        while( iter.hasNext() ) {
        	ZCRMUTIL_GET_HABINHAB_OutputData _data = (ZCRMUTIL_GET_HABINHAB_OutputData) iter.next();
        	laborableDay = _data.isLaborableDay();
        }
        	
        return( laborableDay );	
	}
	
	/**
	 * 
	 */
	public boolean startSPEIDevueltoSubprocess( String applicationId, String requestId, String bpId, String dispersionMode ) throws Exception {
		boolean result = false;
		
		// Obtener contador de incidencias
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_SOL_COUNT_READ_ProxyImpl proxySolCount = new ZRFC_SOL_COUNT_READ_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) );
        inputParams.add( input );
       
        int incidentCounter = proxySolCount.executeRemoteFunction(destination, inputParams );
        
        log.info("incident counter == " + incidentCounter );
        
        // incrementar el contador de incidencias
        incidentCounter++;
        ZRFC_SOL_COUNT_ADD_ProxyImpl proxyInc = new ZRFC_SOL_COUNT_ADD_ProxyImpl();
        
        inputParams = new ArrayList<ProxyInputParameter>();
        input = new ProxyInputParameter();
        input.setKey("P_OBJECT_ID");
        input.setValue( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("P_COUNTER");
        input.setValue( String.valueOf( incidentCounter ) );
        inputParams.add( input );
        
        proxyInc.executeRemoteFunction(destination, inputParams);
		
        // agregar incidencias a SAP CRM parte1
        ZRFC_SET_INCIDENCIAS_ProxyImpl proxy = new ZRFC_SET_INCIDENCIAS_ProxyImpl();
        ProxyInputParameterWithTable inputParamsTable = new ProxyInputParameterWithTable();
        inputParamsTable.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_SOLICITUD");
        inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_CAUSA");
        inputRecord.setValue( "15" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_MOTIVO");
        inputRecord.setValue( "54" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_CONTADOR_BPM");
        inputRecord.setValue( String.valueOf( incidentCounter ) );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_DESC_INT");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_DESC_EXT");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        
        
        inputParamsTable.getRecordParam().add( recordParams1 );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParamsTable );
        
        
        
        /** Agregar incidencias en SAP CRM Parte 2 **/
        
        // first we need to obtain the caseId based on applicationId
        ZRFC_SOLICITUD_CASO_ProxyImpl _proxy = new ZRFC_SOLICITUD_CASO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> _inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter _input = new ProxyInputParameter();
        _input.setKey("P_SOLICITUD");
        _input.setValue( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) );
        _inputParams.add( _input );        
        
        ArrayList<IProxyOutputData> _returnData = _proxy.executeRemoteFunction(destination, _inputParams );
        
        log.info( _returnData.toString() );
        String caseId = null;
        Iterator iter = _returnData.iterator();
        while( iter.hasNext() ) {
        	ZRFC_SOLICITUD_CASO_OutputData _data = (ZRFC_SOLICITUD_CASO_OutputData) iter.next();
        	caseId = _data.getCaseId();
        }
        
        
        /****/
        
        ZRFC_INCIDENCIAS_SOLIC_ProxyImpl proxy4 = new ZRFC_INCIDENCIAS_SOLIC_ProxyImpl();
        
        
        ProxyInputParameterWithTable inputParams4 = new ProxyInputParameterWithTable();
        inputParams4.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams4 = new ArrayList<ProxyInputParameter>();
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_CVEINC");
        inputRecord.setValue( "A01" );
        recordParams4.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_TIPOINC");
        inputRecord.setValue( "A" );
        recordParams4.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_DESCINC");
        inputRecord.setValue( "SPEI DEVUELTO. VERIFICAR LOS DATOS BANCARIOS DEL CLIENTE." );
        recordParams4.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_INCREP");
        inputRecord.setValue( "X" );
        recordParams4.add( inputRecord );
               
        
        inputParams4.getRecordParam().add( recordParams4 );
        
        // Second table for incidents recording
        ProxyInputParameterWithTable inputParams2 = new ProxyInputParameterWithTable();
        inputParams2.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams2 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("Z_CVEINC");
        inputRecord2.setValue( "A01" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("Z_DESCINC");
        inputRecord2.setValue( "SPEI DEVUELTO. VERIFICAR LOS DATOS BANCARIOS DEL CLIENTE." );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("Z_ESTAT");
        inputRecord2.setValue( "" );
        recordParams2.add( inputRecord2 );
        
        inputParams2.getRecordParam().add( recordParams2 );
        
        ArrayList<ProxyInputParameter> _inputParams4 = new ArrayList<ProxyInputParameter>();
        input = new ProxyInputParameter();
        input.setKey("I_ACCION");
        input.setValue( "U" );
        _inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CVECASO");
        input.setValue( StringUtils.trim( caseId ) );
        _inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CVESOL");
        input.setValue( StringUtils.trim( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) ) );
        _inputParams4.add( input );
        
        
        returnData = proxy4.executeRemoteFunction(destination, _inputParams4, inputParams4, inputParams2 );
        
        /*****/
        
        // Ejecutar el starter de BPM
        mx.com.csb.IniVerificacionClabeProceso.IniVerificacionClabeProceso_BindingStub binding = null;
        try {
        	
            
            binding = (mx.com.csb.IniVerificacionClabeProceso.IniVerificacionClabeProceso_BindingStub)
                          new mx.com.csb.IniVerificacionClabeProceso.IniVerificacionClabeProceso_ServiceLocator().getIniVerificacionClabeProceso_Port();
            
            // Time out after a minute
            binding.setTimeout(60000);

            // Run operation
            ZCRMLCOM_E004_GET_DOC_STATUS_OutputData docStatus = this.checkDocumentStatus( Formatter.fillStringWithZerosOnLeft( requestId, 10 ), "ZCSP");

            // dispersion mode must be "1" 
            binding.runService( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) , StringUtils.trim( docStatus.getEstatus() ) , StringUtils.trim(  docStatus.getDescrip() ) , "1" );

            result = true;
        } catch (Exception ex) {
        	log.error("invoking BPM Starter service", ex);
        	throw ex;
        } finally {
        	if( binding != null ) binding = null;
        }
        
		return( result );
	}
}
