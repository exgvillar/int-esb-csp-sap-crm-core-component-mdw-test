/**
 * 
 */
package com.consupago.services.sap.crm.casemgt;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_CASE_ATTACH_ProxyImpl;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_GET_DOC_URL_OutputData;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_GET_DOC_URL_ProxyImpl;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_SOLICITUD_CASO_OutputData;
import com.consupago.sap.interfaces.proxy.casemgt.ZRFC_SOLICITUD_CASO_ProxyImpl;
import com.consupago.sap.interfaces.proxy.casemgt.Z_CRMRFC_ATTACHFILE2CASE_OutputData;
import com.consupago.sap.interfaces.proxy.casemgt.Z_CRMRFC_ATTACHFILE2CASE_ProxyImpl;
import com.consupago.sap.interfaces.proxy.ecmi.ZIF_OBTENERFOLDER_OutputData;
import com.consupago.sap.interfaces.proxy.ecmi.ZIF_OBTENERFOLDER_ProxyImpl;
import com.consupago.services.sap.crm.util.SAPFormatter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;


/**
 * This class handle the reception of Base64 Content and attach it into the Case of the given SAP CRM Quotation
 * @author ramon.becerra
 *
 */
public class AttachDocumentToCaseImpl implements ICaseManagement {

	private static Log log = LogFactory.getLog( AttachDocumentToCaseImpl.class );
	
	/**
	 * 
	 */
	public AttachDocumentToCaseImpl() {
		super();
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.casemgt.ICaseManagement#attachDocumentToQuotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String attachDocumentToQuotation(String requestId, String fileName,
			String base64Content) throws Exception {

		String contentURL = null;
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		String caseId = null;
		ZRFC_SOLICITUD_CASO_ProxyImpl proxy = new ZRFC_SOLICITUD_CASO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_SOLICITUD");
        input.setValue( SAPFormatter.fillStringWithZerosOnLeft( requestId, 10 ) );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> caseList = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( caseList.toString() );
        
        Iterator<IProxyOutputData> caseIter = caseList.iterator();
        while( caseIter.hasNext() ) {
        	ZRFC_SOLICITUD_CASO_OutputData caseData = (ZRFC_SOLICITUD_CASO_OutputData) caseIter.next();
        	caseId = caseData.getCaseId();
        }
        
        
       
        Z_CRMRFC_ATTACHFILE2CASE_ProxyImpl proxy2 = new Z_CRMRFC_ATTACHFILE2CASE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> _inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter _input = new ProxyInputParameter();
        _input.setKey("EXT_KEY");
        _input.setValue( caseId );
        _inputParams.add( _input );
        _input = new ProxyInputParameter();
        _input.setKey("FULL_FILENAME");
        _input.setValue( fileName );
        _inputParams.add( _input );
        
        ArrayList<IProxyOutputData> returnData = proxy2.executeRemoteFunction(destination, _inputParams, base64Content );
        
        Iterator<IProxyOutputData> rIter = returnData.iterator();
        while( rIter.hasNext() ) {
        	Z_CRMRFC_ATTACHFILE2CASE_OutputData data = (Z_CRMRFC_ATTACHFILE2CASE_OutputData) rIter.next();
        	contentURL = data.getUrl();
        }
        
        return( contentURL );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.casemgt.ICaseManagement#getDocumentURLFromContentManager(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getDocumentURLFromContentManager(String requestId,
			String caseId, String documentName) throws Exception {
		
		String url = null;
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_GET_DOC_URL_ProxyImpl proxy = new ZRFC_GET_DOC_URL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( requestId ); // Check the two zeros on the left
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CASO");
        input.setValue( caseId ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FILENAME");
        input.setValue( documentName ); 
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        if( returnData != null ) {
        	Iterator<IProxyOutputData> iter = returnData.iterator();
        	while( iter.hasNext() ) {
        		ZRFC_GET_DOC_URL_OutputData data = (ZRFC_GET_DOC_URL_OutputData) iter.next();
        		url = data.getDocumentURL();
        		break;
        	}
        }
        return( url );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.casemgt.ICaseManagement#getECMIFolder(java.lang.String)
	 */
	public String getECMIFolder(String requestId) throws Exception {
		String ecmiFolder = null;
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZIF_OBTENERFOLDER_ProxyImpl proxy = new ZIF_OBTENERFOLDER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("OBJID");
        input.setValue( requestId ); // TODO Check the two zeros on the left
        inputParams.add( input );
 
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        if( returnData != null ) {
        	Iterator<IProxyOutputData> iter = returnData.iterator();
        	while( iter.hasNext() ) {
        		ZIF_OBTENERFOLDER_OutputData data = (ZIF_OBTENERFOLDER_OutputData) iter.next();
        		ecmiFolder = data.getFolderECMI();
        		break;
        	}
        }
       
        return( ecmiFolder );
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.casemgt.ICaseManagement#getFileListFromCMN(java.lang.String)
	 */
	public ArrayList<IProxyOutputData> getFileListFromCMN(String requestId)
			throws Exception {
		
		String caseId = null;
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_SOLICITUD_CASO_ProxyImpl proxy = new ZRFC_SOLICITUD_CASO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_SOLICITUD");
        input.setValue( requestId );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        Iterator<IProxyOutputData> iter = returnData.iterator();
        while( iter.hasNext() ) {
        	ZRFC_SOLICITUD_CASO_OutputData caseData = (ZRFC_SOLICITUD_CASO_OutputData) iter.next();
        	caseId = caseData.getCaseId();
        	break;
        }
        
        ZRFC_CASE_ATTACH_ProxyImpl proxy2 = new ZRFC_CASE_ATTACH_ProxyImpl();
        inputParams = null;
        input = null;
        inputParams = new ArrayList<ProxyInputParameter>();
        input = new ProxyInputParameter();
        input.setKey("I_CASE");
        input.setValue( caseId );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> fileListData = proxy2.executeRemoteFunction(destination, inputParams );
        
        return( fileListData );
	}

}
