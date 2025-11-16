/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.cancellations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import BPMCXNService.RemoveMasterQueueRequestBO;
import BPMCXNService.RemoveMasterQueueResponseBO;
import BPMCXNService.BPMCXNService.BPMCXNService;
import BPMCXNService.BPMCXNService.Binding.BPMCXNServiceExport1_BPMCXNServiceHttpServiceLocator;

import com.consubanco.sap.interfaces.common.status.ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl;
import com.consubanco.sap.interfaces.common.status.ZRFC_ACT_CASO_COTIZ_ProxyImpl;
import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationBOP;
import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationRequestBOP;
import com.consubanco.services.sap.crm.bpm.cancellations.models.CancelApplicationResponseBOP;
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
public class CRMBPMCancellationsServiceImpl implements ICRMBPMCancellationsService {

//	private static Log log = LogFactory.getLog( CRMBPMQueuesServiceImpl.class );
	/**
	 * 
	 */
	public CRMBPMCancellationsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public CancelApplicationResponseBOP cancellApplicationCxN( CancelApplicationRequestBOP cancelApplicationRequestBOP ) throws Exception
	{
		
		CancelApplicationResponseBOP cancelApplicationResponseBOP = new CancelApplicationResponseBOP();
		ArrayList<CancelApplicationBOP> applicationsResponseList = null;
		com.csb.bpmOperationsExtended.BpmOperationsExtendedSOAPStub stubBPMOrig = null;
		BPMCXNServiceExport1_BPMCXNServiceHttpServiceLocator locator = null;
		BPMCXNService stubBPMCXN = null;
		RemoveMasterQueueRequestBO removeMQRequest = null;
		RemoveMasterQueueResponseBO removeMQResponse = null;
		
		try{
			if( cancelApplicationRequestBOP != null 
						&& cancelApplicationRequestBOP.getUser() != null && cancelApplicationRequestBOP.getApplications() != null ){
				
				applicationsResponseList = new ArrayList<CancelApplicationBOP>();		
				Iterator<CancelApplicationBOP> it = cancelApplicationRequestBOP.getApplications().iterator();
				while( it.hasNext() ){
					boolean bpmCancel = false; 
					CancelApplicationBOP cancelAppBOP =  it.next();
					
					/**
					 * cancell Process in SAP BPM
					 */
					stubBPMOrig = (com.csb.bpmOperationsExtended.BpmOperationsExtendedSOAPStub)
		                          new com.csb.bpmOperationsExtended.BpmOperationsExtended_ServiceLocator().getbpmOperationsExtendedSOAP();
		            // Time out after a minute
					stubBPMOrig.setTimeout(60000);
			        stubBPMOrig.run( "C", cancelAppBOP.getProcessId(), "", "", cancelAppBOP.getFolioApplication(), new javax.xml.rpc.holders.StringHolder(), new javax.xml.rpc.holders.StringHolder());
			        
			        if( stubBPMOrig.getOutResponse().equals("1") || stubBPMOrig.getOutResponse().equals("4") )
			        	bpmCancel = true;
			        
			        if( bpmCancel ){
			        	/**
						 * remove in CRM table "Z" MasterQueue
						 */
						locator = new BPMCXNServiceExport1_BPMCXNServiceHttpServiceLocator();
						stubBPMCXN = locator.getSrv_BPMCXNServiceHttpPort();
	
						removeMQRequest = new RemoveMasterQueueRequestBO();
						removeMQRequest.setApplicationId( cancelAppBOP.getProcessId() );
						removeMQRequest.setProcessId("");
						removeMQRequest.setFolioApplication( StringUtils.trimToEmpty( cancelAppBOP.getFolioApplication() ) );
				        
				        removeMQResponse = stubBPMCXN.removeMasterQueue( removeMQRequest );
				        if( removeMQResponse != null && 
				        		removeMQResponse.getStatus().equals("C") && removeMQResponse.getCode().equals("200") ){
				        	
				        	/**
			        		 * cancell Application in SAP CRM
			        		 */
			        		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
			        		ZRFC_ACT_CASO_COTIZ_ProxyImpl proxyActCasoCotiz = new ZRFC_ACT_CASO_COTIZ_ProxyImpl();
			        		
			        		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
			                ProxyInputParameter input = new ProxyInputParameter();
			                input.setKey("EXT_KEY");
			                input.setValue( Formatter.fillStringWithZerosOnLeft( StringUtils.trimToEmpty( cancelAppBOP.getFolioApplication() ) , 10 ) );
			                inputParams.add( input );
			                input = new ProxyInputParameter();
			                input.setKey("IV_STATUS");
			                input.setValue( "200" ); //CANCELADA
			                inputParams.add( input );
			               
			                ArrayList<IProxyOutputData> returnData = proxyActCasoCotiz.executeRemoteFunction(destination, inputParams );
			                if( returnData != null ){
			                	ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl proxyGrabaHist = new ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl();
				        		
			                	ProxyInputParameterWithTable inputTblParams = new ProxyInputParameterWithTable();
			                	inputTblParams.setRecordParam( new ArrayList<Object>() );
			                	
			                	Date currentDate = new Date();
			            		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("ES", "MX")).format(currentDate);
			            		String time =  new SimpleDateFormat("HH:mm:ss", new Locale("ES", "MX")).format(currentDate);

			            		ArrayList<ProxyInputParameter> recordParams = new ArrayList<ProxyInputParameter>();
			                    ProxyInputParameter inputRecord = new ProxyInputParameter();
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("OBJECT_ID");
			                    inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( StringUtils.trimToEmpty( cancelAppBOP.getFolioApplication() ) , 10 ) );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("UDATE");
			                    inputRecord.setValue( date );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("UTIME");
			                    inputRecord.setValue( time );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("USERNAME");
			                    inputRecord.setValue( cancelApplicationRequestBOP.getUser().getUserName() );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("INDTEXT");
			                    inputRecord.setValue( "CAMBIO DE ESTATUS" );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("F_OLD"); 
			                    inputRecord.setValue( "" );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("F_NEW");
			                    inputRecord.setValue( "CANCELADA" );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("USER_CSB");
			                    inputRecord.setValue( "ESBCOMM" );
			                    recordParams.add( inputRecord );
			                    inputRecord = new ProxyInputParameter();
			                    inputRecord.setKey("PARTNER");
			                    inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( cancelApplicationRequestBOP.getUser().getBusinessPartner(), 10 ) );
			                    recordParams.add( inputRecord );
			                    
			                    inputTblParams.getRecordParam().add( recordParams );
				                returnData = proxyGrabaHist.executeRemoteFunction(destination, inputTblParams);
				                
			                	cancelAppBOP.setCancelled( true );
					        	cancelAppBOP.setMessage("");
								applicationsResponseList.add( cancelAppBOP );
								
			                }else{ //if( returnData != null )
			                	cancelAppBOP.setCancelled( false );
					        	cancelAppBOP.setMessage("SAP CRM ZRFC_ACT_CASO_COTIZ_ProxyImpl :: Solicitud No cancelada");
								applicationsResponseList.add( cancelAppBOP );
			                }
				        }else{ //if( removeMQResponse != null )
				        	cancelAppBOP.setCancelled( false );
				        	cancelAppBOP.setMessage("SAP CRM Remove MQ :: Solicitud No cancelada");
							applicationsResponseList.add( cancelAppBOP );
				        }	
			        }else{ //if( bpmCancel )
						cancelAppBOP.setCancelled( false );
						cancelAppBOP.setMessage("SAP BPM :: Proceso No cancelado :: ["+stubBPMOrig.getErrorResponse()+"]");
						applicationsResponseList.add( cancelAppBOP );
					}
				}//while
			}else{
				cancelApplicationResponseBOP.setStatus("E");
				cancelApplicationResponseBOP.setCode("301");
				cancelApplicationResponseBOP.setResponse("Se requieren los parámetros de entrada");
			}
		}catch(Exception e){
			cancelApplicationResponseBOP.setStatus("E");
			cancelApplicationResponseBOP.setCode("500");
			cancelApplicationResponseBOP.setResponse("Occurred Exception :: " + e.getMessage() );
			throw e;
		}finally{
			if( stubBPMOrig != null ) stubBPMOrig = null;
			if( locator  != null ) locator = null;
			if( stubBPMCXN != null ) stubBPMCXN = null;
			if( removeMQRequest != null ) removeMQRequest = null;
			if( removeMQResponse != null ) removeMQResponse = null;
		}
		
		cancelApplicationResponseBOP.setApplications( applicationsResponseList );
		cancelApplicationResponseBOP.setStatus("C");
		cancelApplicationResponseBOP.setCode("200");
		cancelApplicationResponseBOP.setResponse("Service terminated with no errors and warnings.");
		return ( cancelApplicationResponseBOP );
	}
	
}
