/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.queues;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;

import com.consubanco.sap.interfaces.bpm.queues.catalogs.ZCRMWKQUE_E007_CATALOG_CONVCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E008_NOTIFICATIONS_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E011_MONITOR_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E012_LAST_USR_ASSIGN_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E015_DATA_SOL_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P008_UNLOCK_BP_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.generals.ZCRMWKQUE_P008_UNLOCK_BP_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E001_GETUSERCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.mantto.ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_INC_RECAP_Model;
import com.consubanco.sap.interfaces.bpm.queues.models.ZWRKQUEUE_UNASIGN_SOLS_Model;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P002_UPD_TRK_RECAP_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P003_UPD_CONT_RECAP_OutputData;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P003_UPD_CONT_RECAP_ProxyImpl;
import com.consubanco.sap.interfaces.bpm.queues.recaptures.ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImpl;
import com.consubanco.services.sap.crm.bpm.queues.models.IncidenceRecaptureInputParameter;
import com.consubanco.services.sap.crm.bpm.queues.models.RecaptureInputParameter;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author hsanchez
 *
 */
public class CRMBPMQueuesServiceImpl implements CRMBPMQueuesService {

//	private static Log log = LogFactory.getLog( CRMBPMQueuesServiceImpl.class );
	/**
	 * 
	 */
	public CRMBPMQueuesServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.bpm.queues#saveUserCOX( ZCRMBPM_P001_ADDUPDUSERSCOX_OutputData employee, boolean remove ) throws Exception
	 */
	public ArrayList<IProxyOutputData> saveUserCOX( ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData employee ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl proxy = new ZCRMWKQUE_P001_ADDUPDUSERSCOX_ProxyImpl();
		
		employee.setBusinessPartner( Formatter.fillStringWithZerosOnLeft( employee.getBusinessPartner(), 10));
		
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, employee );
        
        return ( returnData );
	}
	

	public ArrayList<IProxyOutputData> getUsersCox( String bp, String username ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMWKQUE_E001_GETUSERCOX_ProxyImpl proxy = new ZCRMWKQUE_E001_GETUSERCOX_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_PARTNER");
        if( StringUtils.isNotEmpty( bp ) )
        	input.setValue( Formatter.fillStringWithZerosOnLeft( bp, 10 ) );
        else
        	input.setValue( bp );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USUARIO");
        input.setValue( username );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
               
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getProductCategories( ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl proxy = new ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CONVENIO");
        input.setValue( "" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCCONV");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CATEGORIA");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCCAT");
        input.setValue( "*" );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
               
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> searchConvenioProd( String convenioId, String convenioDesc, String productId, String productDesc ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl proxy = new ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl();
	    
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
	    ProxyInputParameter input = new ProxyInputParameter();
	    input.setKey("I_CONVENIO");
	    input.setValue( convenioId ); 
	    inputParams.add( input );
	    input = new ProxyInputParameter();
	    input.setKey("I_DESCCONV");
	    input.setValue( convenioDesc );
	    inputParams.add( input );
	    input = new ProxyInputParameter();
        input.setKey("I_PRODUCTO");
        input.setValue( productId ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCPROD");
        input.setValue( productDesc );
        inputParams.add( input );
	    input = new ProxyInputParameter();
	    input.setKey("I_CATEGORIA");
	    input.setValue( "" );
	    inputParams.add( input );
	    input = new ProxyInputParameter();
	    input.setKey("I_DESCCAT");
	    input.setValue( "" );
	    inputParams.add( input );
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> savePrioritiesConvProd( String convProdId, String categoryId, int ratePriority ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImpl proxy = new ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_CONVENIO");
        input.setValue( convProdId ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ID_CATEGORIA");
        input.setValue( categoryId );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALIFICACION");
        input.setValue( ""+ ratePriority );
        inputParams.add( input );
        		
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        return ( returnData );
	}

	public ArrayList<IProxyOutputData> getCatalogConfField( ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E007_CATALOG_CONVCOX_ProxyImpl proxy = new ZCRMWKQUE_E007_CATALOG_CONVCOX_ProxyImpl();
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, new ArrayList<ProxyInputParameter>() );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> saveConfigurablesFields( ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData> paramsList ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl proxy = new ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl();
	    
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, paramsList );
	    
	    return ( returnData );
	}

	public ArrayList<IProxyOutputData> getConfigurablesFields( ZCRMWKQUE_E005_GET_CONF_VARCOX_OutputData data ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl proxy = new ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl();
	    
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLAVE");
        input.setValue( data.getId() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NOMBRE");
        input.setValue( data.getFieldName() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPO");
        input.setValue( data.getType() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_VALOR");
        input.setValue( data.getValue() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALIF_PRIORI");
        input.setValue( data.getRatePriority() > 0 ? ""+ data.getRatePriority() : "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SOLICITADO_POR");
        input.setValue( data.getRequestedBy() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_AUTORIZADO");
        input.setValue( data.isAuthorized() ? "X" : "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_AUTORIZADO_POR");
        input.setValue( data.getAuthorizedBy() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ACTIVO");
        input.setValue( data.isActive() ? "X" : "" );
        inputParams.add( input );
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> saveAttentionTimes( ZCRMWKQUE_P004_SAVE_TIMEATNCOX_OutputData attentionTime, boolean remove ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl proxy = new ZCRMWKQUE_P004_SAVE_TIMEATNCOX_ProxyImpl();
        
        attentionTime.setBusinessPartner( Formatter.fillStringWithZerosOnLeft(attentionTime.getBusinessPartner(), 10) ); 
        attentionTime.setDelete( remove );
        
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, attentionTime ); 
	    
	    return ( returnData );
	}

	public ArrayList<IProxyOutputData> getAttentionTimes( String bp, String username ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl proxy = new ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl();
	    
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_PARTNER");
        if( StringUtils.isNotEmpty( bp ) )
        	input.setValue( Formatter.fillStringWithZerosOnLeft( bp, 10 ) );
        else
        	input.setValue( bp );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER");
        input.setValue( username );
        inputParams.add( input );
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.bpm.queues#updateStatusUser( ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData user ) throws Exception
	 */
	public ArrayList<IProxyOutputData> updateStatusUser( ZCRMWKQUE_P005_UPD_STATUSUSER_OutputData user ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl proxy = new ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_BP");
        input.setValue( Formatter.fillStringWithZerosOnLeft( user.getBusinessPartner() , 10 ) ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USERNAME");
        input.setValue( user.getUserName() );
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_CLV_ESTATUS");
        input.setValue( user.getStatusId() );
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_DESC_ESTATUS");
        input.setValue( user.getStatusDesc() );
        inputParams.add( input ); 
		
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	    
	    return ( returnData );
	}

	public ArrayList<IProxyOutputData> getApplicationsByNotifications( boolean assigned ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E008_NOTIFICATIONS_ProxyImpl proxy = new ZCRMWKQUE_E008_NOTIFICATIONS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ASIGNADA");
        input.setValue( assigned ? "X" : "" ); 
        inputParams.add( input );
               
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.bpm.queues#saveMasterQueue( ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData queue ) throws Exception
	 */
	public ArrayList<IProxyOutputData> saveMasterQueue( ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData queue ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl proxy = new ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl();
		
		queue.setFolioApplication( Formatter.fillStringWithZerosOnLeft( queue.getFolioApplication(), 10));
		
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, queue );
	    
	    return ( returnData );
	}

	public ArrayList<IProxyOutputData> availableUsers( ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData inputData  ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl proxy = new ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLAVE_AREA");
        input.setValue( inputData.getAreaKey() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESC_AREA");
        input.setValue( inputData.getAreaDesc() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLAVE_ESTATUS");
        input.setValue( inputData.getStatusKey() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESC_ESTATUS");
        input.setValue( inputData.getStatusDesc() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLAVE_CONVENIO");
        input.setValue( inputData.getConvenioId() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLV_CAT_PROD");
        input.setValue( inputData.getProductCategoryId() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CANAL_ORIGEN");
        input.setValue( inputData.getSourceChannelId() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_SOL_ASIG");
        input.setValue( "" + inputData.getNumberAssignedRequests() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_REG_MAX");
        input.setValue( "" + inputData.getMaxNumberRecords() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_AVAIL_USER");
        input.setValue( inputData.getLastUserAssigned() );
        inputParams.add( input );
        
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getMasterQueue( ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData data ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl proxy = new ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl();
        
        data.setFolioApplication( StringUtils.isEmpty( data.getFolioApplication() ) ? "" : Formatter.fillStringWithZerosOnLeft( data.getFolioApplication() , 10) );
               
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, data );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getLastUsersAssignedByApp( String folioApplication ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E012_LAST_USR_ASSIGN_ProxyImpl proxy = new ZCRMWKQUE_E012_LAST_USR_ASSIGN_ProxyImpl();
	    
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
	    ProxyInputParameter input = new ProxyInputParameter();
	    input.setKey("I_FOLIO");
	    input.setValue( Formatter.fillStringWithZerosOnLeft( folioApplication , 10 ) );
	    inputParams.add( input );
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> monitorMasterQueue( Date startDate, Date endDate, String convenioId, String username, String taskPriorityId ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E011_MONITOR_ProxyImpl proxy = new ZCRMWKQUE_E011_MONITOR_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        //50384960
        input.setKey("I_FECHAINI");
        input.setDateValue( startDate ); 
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FECHAFIN");
        input.setDateValue( endDate ); 
        input.setType("java.util.Date");
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_CONVENIO"); 
        input.setValue( convenioId ); 
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_USUARIO");
        input.setValue( username ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_PRIORIDAD");
        input.setValue( taskPriorityId ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCPRIORI");
        input.setValue( "" ); 
        inputParams.add( input );
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getFolioApplicationGralInfo( String folioApplication ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E015_DATA_SOL_ProxyImpl proxy = new ZCRMWKQUE_E015_DATA_SOL_ProxyImpl();
	    
	    ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
	    ProxyInputParameter input = new ProxyInputParameter();
	    input.setKey("I_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft( folioApplication , 10) ); 
	    inputParams.add( input );
	           
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}
	

	public ArrayList<IProxyOutputData> unlockUsersCox( ZCRMWKQUE_P008_UNLOCK_BP_OutputData inputParams ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_P008_UNLOCK_BP_ProxyImpl proxy = new ZCRMWKQUE_P008_UNLOCK_BP_ProxyImpl();
        
		ProxyInputParameterWithTable inputParamsWT = new ProxyInputParameterWithTable();
		inputParamsWT.setRecordParam( new ArrayList<Object>() );
        
		ArrayList<ProxyInputParameter> generalParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputParam = new ProxyInputParameter();
        inputParam.setKey("I_SEQUENCE");
        inputParam.setValue( "U" );
        generalParams.add( inputParam );
        inputParamsWT.setGeneralParam( generalParams );
        
		if( inputParams.getUsersCox() != null ){
			Iterator<String> it = inputParams.getUsersCox().iterator();
			while( it.hasNext() ){
				String userCox = (String)it.next();
				ArrayList<ProxyInputParameter> recordParams = new ArrayList<ProxyInputParameter>();
		        ProxyInputParameter inputRecord = new ProxyInputParameter();
		        inputRecord.setKey("ZBP");
		        inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( userCox , 10) );
		        recordParams.add( inputRecord );
		        inputParamsWT.getRecordParam().add( recordParams );
			}
		}
		
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParamsWT );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getPriorityMasterQueue( String executorRol, String taskPriorityKey, String taskPriorityDesc ) throws Exception
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl proxy = new ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl();
	    
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ROL");
        input.setValue( executorRol ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_PRIORITY");
        input.setValue( taskPriorityKey ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_DESC_PRIORITY");
        input.setValue( taskPriorityDesc ); 
        inputParams.add( input );
        
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	           
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> saveRecaptureMQ( RecaptureInputParameter recapture ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImpl proxy = new ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImpl();
        
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_INDICE");
        input.setValue( "" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_SOLICITUD");
        input.setValue( Formatter.fillStringWithZerosOnLeft( recapture.getFolioApplication(), 10 ) ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER_CAP_ERROR");
        input.setValue( recapture.getUserCaptureError() );  
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER_REPORT");
        input.setValue( recapture.getUserReport() ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ROL_REPORT");
        input.setValue( recapture.getRoleReport() );  
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER_CAP_RESOL");
        input.setValue( recapture.getUserCaptureResolve() );
        inputParams.add( input );
        
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	    
	    //save Incidences
	    if( recapture.getIncidencesRecapture() != null ){
	    	if( returnData != null ){
	    		ZCRMRWKQUE_P002_UPD_TRK_RECAP_OutputData recaptureData = (ZCRMRWKQUE_P002_UPD_TRK_RECAP_OutputData)returnData.get(0);
	    		if( recaptureData.isSuccess() ){
	    			ZCRMRWKQUE_P003_UPD_CONT_RECAP_ProxyImpl proxyCont = new ZCRMRWKQUE_P003_UPD_CONT_RECAP_ProxyImpl();
	    	        
	    	        inputParams = new ArrayList<ProxyInputParameter>();
	    	        input = new ProxyInputParameter();
	    	        input.setKey("I_NUM_SOLICITUD");
	    	        input.setValue( Formatter.fillStringWithZerosOnLeft( recapture.getFolioApplication(), 10 ) ); 
	    	        inputParams.add( input );
	    	        input = new ProxyInputParameter();
	    	        input.setKey("I_NUM_TOTAL_RECAP");
	    	        input.setValue( "" + recapture.getTotalRecapture() ); 
	    	        inputParams.add( input );
	    	        
	    	        returnData = proxyCont.executeRemoteFunction(destination, inputParams );
	    	        if( returnData != null ){
	    	        	ZCRMRWKQUE_P003_UPD_CONT_RECAP_OutputData contData = (ZCRMRWKQUE_P003_UPD_CONT_RECAP_OutputData)returnData.get(0);
	    	    		if( contData.isSuccess() ){
	    	    			ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl proxyInc = new ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl();
	    	    	        
	    	    			ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData incidenceParams = new ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData();
	    	    			incidenceParams.setIncidences( new ArrayList<ZM_INC_RECAP_Model>() );
	    	    			Iterator<IncidenceRecaptureInputParameter> it = recapture.getIncidencesRecapture().iterator();
	    	    			while( it.hasNext() ){
	    	    				IncidenceRecaptureInputParameter incidenceRecapture = it.next();
	    	    				ZM_INC_RECAP_Model incidence = new ZM_INC_RECAP_Model();
		    	    	        incidence.setIncidenceNumber( incidenceRecapture.getId() );
		    	    	        incidence.setFolioApplication( Formatter.fillStringWithZerosOnLeft( recapture.getFolioApplication(), 10 ) );
		    	    	        incidence.setCause( incidenceRecapture.getCause() );
		    	    	        incidence.setMotive( incidenceRecapture.getMotive() );
		    	    	        incidence.setGeneralDescription( incidenceRecapture.getDescription() );
		    	    	        incidence.setResolve( incidenceRecapture.isResolve() );
		    	    	        incidenceParams.getIncidences().add( incidence );
		    	    	        
		    	    	        //relacionar
		    	    	        if( !incidenceRecapture.isResolve() ){
		    	    	        	ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImpl proxyRelRec = new ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImpl();
		                            
			    	    	        inputParams = new ArrayList<ProxyInputParameter>();
			    	    	        input = new ProxyInputParameter();
			    	    	        input.setKey("I_NUM_SOLICITUD");
			    	    	        input.setValue( Formatter.fillStringWithZerosOnLeft( recapture.getFolioApplication(), 10 ) ); 
			    	    	        inputParams.add( input );
			    	    	        input = new ProxyInputParameter();
			    	    	        input.setKey("I_NUM_RECAPTURA");
			    	    	        input.setValue( Formatter.fillStringWithZerosOnLeft(""+ recapture.getTotalRecapture(), 3 ) ); 
			    	    	        inputParams.add( input );
			    	    	        input = new ProxyInputParameter();
			    	    	        input.setKey("I_NUM_INCIDENCIA");
			    	    	        input.setValue( "" + incidenceRecapture.getId() );  
			    	    	        inputParams.add( input );
			    	    	                
			    	    	        returnData = proxyRelRec.executeRemoteFunction(destination, inputParams );	
		    	    	        }
		    	    	        
	    	    			}
	    	    	        returnData = proxyInc.executeRemoteFunction(destination, incidenceParams );
	    	    		}
	    	        }
	    		}
	    		
	    	}
	    }
	    
	    return ( returnData );
	}

	public ArrayList<IProxyOutputData> asignacionDeSolicitudes( ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model> dataList) throws Exception {
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		return new ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl().executeRemoteFunction(destination, dataList);
	}
	
}
