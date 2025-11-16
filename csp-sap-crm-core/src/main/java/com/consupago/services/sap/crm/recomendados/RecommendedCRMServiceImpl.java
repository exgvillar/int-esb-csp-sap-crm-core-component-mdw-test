package com.consupago.services.sap.crm.recomendados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;

import com.consubanco.esb.validator.utils.Formatter;
import com.consubanco.sap.interfaces.commons.attachments.ZCRMORI_P008_ATTACH_FILE_OutputData;
import com.consubanco.sap.interfaces.commons.attachments.ZCRMORI_P008_ATTACH_FILE_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_E000_BPMSTARTER_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_E002_GETINFO_CLTEREFI_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_E003_ORDSERV_X_STATUS_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl;
import com.consubanco.sap.interfaces.recomendados.model.ESTATUS_MOTIVO_Model;
import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.calendar.Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl;
import com.consupago.services.sap.crm.recomendados.models.DocumentModel;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class RecommendedCRMServiceImpl implements RecommendedCRMService {


	private static Log log = LogFactory.getLog( RecommendedCRMServiceImpl.class );

	/**
	 * 
	 */
	public RecommendedCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	
	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#startRecommended( String requestId ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> startRecommended( String requestId ) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_E000_BPMSTARTER_ProxyImpl proxy = new ZCRMRECO_E000_BPMSTARTER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_NUMSOL");
        input.setValue( Formatter.fillStringWithZerosOnLeft( requestId, 10 ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
		return ( returnData );
	}


	
	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#getInfoCustomerRefer( String businessPartner ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getInfoCustomerRefer( String businessPartner ) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_E002_GETINFO_CLTEREFI_ProxyImpl proxy = new ZCRMRECO_E002_GETINFO_CLTEREFI_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_PARTNER");
        input.setValue( Formatter.fillStringWithZerosOnLeft( businessPartner, 10 ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
		return ( returnData );
	}



	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#getServiceOrderByStatus( ArrayList<String> statusList ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getServiceOrderByStatus( ArrayList<String> statusList ) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_E003_ORDSERV_X_STATUS_ProxyImpl proxy = new ZCRMRECO_E003_ORDSERV_X_STATUS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = null;

        Iterator<String> ite = statusList.iterator();

        if(statusList!=null){
            while(ite.hasNext()){
            	String status = (String)ite.next();

            	input = new ProxyInputParameter();
                input.setKey("STATUS");
                input.setValue(status);
                inputParams.add( input );
            }
        }    
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );

		return ( returnData );
	}


	
	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#addUpdateServiceOrder( ORDEN_SERVICIO_Model serviceOrder ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> addUpdateServiceOrder( ORDEN_SERVICIO_Model serviceOrder ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl proxy = new ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl();
        
        if( StringUtils.isNotEmpty( serviceOrder.getSolClienteReferido() ) )
        	serviceOrder.setSolClienteReferido( Formatter.fillStringWithZerosOnLeft(serviceOrder.getSolClienteReferido(), 10 ) );
        else
        	serviceOrder.setSolClienteReferido( StringUtils.trimToEmpty( serviceOrder.getSolClienteReferido() ) );
        
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, serviceOrder );
        
		return ( returnData );
	}

	

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#updateStatusMotive( ESTATUS_MOTIVO_InputData inputParamsData ) throws Exception ;
	 */
	public ArrayList<IProxyOutputData> updateStatusMotive( ESTATUS_MOTIVO_Model inputParamsData ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl proxy = new ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl();
        
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParamsData );
        
		return ( returnData );
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#updateServiceOrderByReference( String reference, String status, String fechaCobro ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> updateServiceOrderByReference( String reference, String status, Date fechaCobro ) throws Exception {

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImpl proxy = new ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_REFERE");
        input.setValue( reference );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( status );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECOBR");
        input.setType("java.util.date");
        input.setDateValue(fechaCobro);
        inputParams.add( input );

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
		return ( returnData );
	}



	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#attachDocuments( String serviceOrderId,  ArrayList<DocumentModel> documents ) throws Exception;
	 */
	public ArrayList<DocumentModel> attachDocuments( String serviceOrderId,  ArrayList<DocumentModel> documents ) throws Exception{
		
		ArrayList<DocumentModel> returnDocuments = new ArrayList<DocumentModel>();
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        Iterator<DocumentModel> documentIter = documents.iterator();
        while( documentIter.hasNext() ) {
        	
        	DocumentModel document = documentIter.next();
        	
    		OutputStream os = null;
    		BASE64Decoder decoder = new BASE64Decoder();
    		String path = "/BF/Recomendados/Spool/" + document.getFilename() ;
    		try {
    			os = new FileOutputStream( path );
    			byte[] buf = decoder.decodeBuffer( document.getBase64Content() );	        
    	        os.write( buf );	        
    	        os.close();
    		} catch( Exception ex ) {
    			log.error("saving file", ex );
    			throw ex;
    		} finally {
    			if( os != null ) try { os.close(); os = null; } catch( Exception ex ) {}
    		}
            
            File file = new File( path );
             
            ZCRMORI_P008_ATTACH_FILE_ProxyImpl proxy1 = new ZCRMORI_P008_ATTACH_FILE_ProxyImpl();
            
            ArrayList<ProxyInputParameter> inputParams1 = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter input1 = new ProxyInputParameter();
            input1.setKey("LV_OBJECT");
            input1.setValue(  Formatter.fillStringWithZerosOnLeft( serviceOrderId, 10 ) );
            inputParams1.add( input1 );
            input1 = new ProxyInputParameter();
            input1.setKey("LV_TIPDOC");
            input1.setValue( "ZOSR" );
            inputParams1.add( input1 );
            input1 = new ProxyInputParameter();
            input1.setKey("LV_FILE_NAME");
            input1.setValue( file.getName() );
            inputParams1.add( input1 );
            input1 = new ProxyInputParameter();
            input1.setKey("LV_TIPO");
            input1.setValue( "2" );
            inputParams1.add( input1 );
            
            ArrayList<IProxyOutputData> returnData1 = proxy1.executeRemoteFunction(destination, inputParams1, file );
            Iterator returnDocIter = returnData1.iterator();
            while( returnDocIter.hasNext() ) {
            	ZCRMORI_P008_ATTACH_FILE_OutputData returnDoc = (ZCRMORI_P008_ATTACH_FILE_OutputData) returnDocIter.next();
            	DocumentModel returnDocument = new DocumentModel();
            	returnDocument.setFilename( file.getName());
            	returnDocument.setUrl( returnDoc.getUrl() );
            	returnDocuments.add( returnDocument );
            }
            
        }
        
        return( returnDocuments );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#addUpdateServiceOrder( ORDEN_SERVICIO_Model serviceOrder ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> updateServiceOrderBrmsBkr( ORDEN_SERVICIO_Model serviceOrder ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl proxy = new ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ORDSERV");
        input.setValue( Formatter.fillStringWithZerosOnLeft( serviceOrder.getNumeroOrdenServicio() , 10) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_P");
        input.setValue( ""+serviceOrder.getMontoPago() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue( serviceOrder.getEstatus() );
        inputParams.add( input );
        
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
		return ( returnData );
	}
	
	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.recomendados#getExpirationDate( Date date ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getExpirationDate( Date date ) throws Exception
	{

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl proxy = new Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_FECHA");
		input.setDateValue( SAPFormatter.convertUtilDate2SqlDate(date) );
		input.setType("java.util.Date");
		inputParams.add( input );
		input = new ProxyInputParameter();
		input.setKey("I_DIAS");
		input.setValue( "5" );
		inputParams.add( input );
		input = new ProxyInputParameter();
		input.setKey("I_CALENDARIO");
		input.setValue( "Z1" );
		inputParams.add( input );
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );

		return ( returnData );
	}

}
