/**
 * 
 */
package com.consubanco.services.sap.crm.bpm.spei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

 

import com.consubanco.esb.validator.utils.Formatter;
import com.consubanco.sap.interfaces.bpm.spei.ZCRMUTL_P001_CHG_COMP_A_SPEIDE_OutputData;
import com.consubanco.sap.interfaces.bpm.spei.ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl;
import com.consubanco.sap.interfaces.common.status.ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class CRMBPMSpeiServiceImpl implements CRMBPMSpeiService {

	private static Log LOG = LogFactory.getLog(CRMBPMSpeiServiceImpl.class);

	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.bpm.spei.CRMBPMSpeiService#speiDevuelto(java.lang.String)
	 */
	public ArrayList<IProxyOutputData> speiDevuelto(String folioAppId, String username, String bpId) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl proxy = new ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUMDOC");
		input.setValue( Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty( folioAppId ), 10 ) );
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		
		if(returnData != null){
			
			Iterator<IProxyOutputData> iterator = returnData.iterator();
			while (iterator.hasNext()) {
				ZCRMUTL_P001_CHG_COMP_A_SPEIDE_OutputData next = (ZCRMUTL_P001_CHG_COMP_A_SPEIDE_OutputData)iterator.next();
				
				if(next.isSuccess()){
					
					LOG.info("Grabando Historial de estatus para la solicitud: " + folioAppId);
					
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
		            inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( StringUtils.trimToEmpty( folioAppId ) , 10 ) );
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
		            inputRecord.setValue( username );
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
		            inputRecord.setValue( "SPEI DEVUELTO" );
		            recordParams.add( inputRecord );
		            inputRecord = new ProxyInputParameter();
		            inputRecord.setKey("USER_CSB");
		            inputRecord.setValue( "ESBCOMM" );
		            recordParams.add( inputRecord );
		            inputRecord = new ProxyInputParameter();
		            inputRecord.setKey("PARTNER");
		            inputRecord.setValue( Formatter.fillStringWithZerosOnLeft( StringUtils.trimToEmpty( bpId ) , 10 ) );
		            recordParams.add( inputRecord );
		            
		            inputTblParams.getRecordParam().add( recordParams );
		            proxyGrabaHist.executeRemoteFunction(destination, inputTblParams);
		            
		            LOG.info("Historial grabado exitosamente para la solicitud: " + folioAppId);
				}
			}
            
		}
		LOG.info(returnData.toString());
	
		return returnData;
	}

}
