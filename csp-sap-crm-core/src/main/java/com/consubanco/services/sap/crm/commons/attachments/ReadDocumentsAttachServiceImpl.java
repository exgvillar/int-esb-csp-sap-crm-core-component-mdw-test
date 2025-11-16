/**
 * 
 */
package com.consubanco.services.sap.crm.commons.attachments;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.attachments.ZCRMORI_P008_READ_FILESATTACH_ProxyImpl;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ReadDocumentsAttachServiceImpl implements ReadDocumentsAttachService {
	
	private static final Log log = LogFactory.getLog(ReadDocumentsAttachServiceImpl.class);
	
	/**
	 * 
	 */
	public ReadDocumentsAttachServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.attachments.ReadDocumentsAttachOfAppService#deleteDocumentAttachment(java.lang.String, java.lang.String)
	 */
	public ArrayList<IProxyOutputData> readDocumentsAttachment( String requestId, String typeRequestId ) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P008_READ_FILESATTACH_ProxyImpl proxyImpl = new ZCRMORI_P008_READ_FILESATTACH_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParamtersList = new ArrayList<ProxyInputParameter>();
		
		ProxyInputParameter inputParameter = null;
		
		
		/*
		 * Id de la solicitud
		 */
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_NUMDOC");
		inputParameter.setValue(Formatter.fillStringWithZerosOnLeft(requestId, 10));
		inputParamtersList.add(inputParameter);
		
		/*
		 * Tipo de la solicitud : "ZSTC" (Tarjeta de credito)
		 */
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_TIPDOC");
		inputParameter.setValue( typeRequestId );
		inputParamtersList.add(inputParameter);
		
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList);
		
		log.info( returnData.toString() );

		return returnData;
		
	}

}
