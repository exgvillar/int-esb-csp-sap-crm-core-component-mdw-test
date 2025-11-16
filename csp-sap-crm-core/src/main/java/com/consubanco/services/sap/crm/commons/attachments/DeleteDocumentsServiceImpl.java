package com.consubanco.services.sap.crm.commons.attachments;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.attachments.ZCRMORI_P008_DETACH_FILE_ProxyImpl;
import com.consubanco.sap.interfaces.commons.attachments.model.ZTTCRMORI_C_043_Model;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class DeleteDocumentsServiceImpl implements DeleteDocumentsService {

	private static final Log log = LogFactory.getLog(DeleteDocumentsServiceImpl.class);

	/**
	 * 
	 */
	public DeleteDocumentsServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons.attachments.DeleteDocumentsService#deleteDocumentAttachment(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public ArrayList<IProxyOutputData> deleteDocumentAttachment(String requestId, String typeRequestId, String nameDocument) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P008_DETACH_FILE_ProxyImpl proxyImpl = new ZCRMORI_P008_DETACH_FILE_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParamtersList = new ArrayList<ProxyInputParameter>();
		
		
		ArrayList<ZTTCRMORI_C_043_Model> documentList = null;
		ProxyInputParameter inputParameter = null;
		ZTTCRMORI_C_043_Model model = null;  
		
		documentList = new ArrayList<ZTTCRMORI_C_043_Model>();
		
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
		
		/*
		 * Nombre del documento: si es vacio borra todos los docs adjuntos
		 */
		if(nameDocument != null){
			model = new ZTTCRMORI_C_043_Model();
			model.setDocumentName(nameDocument);
			model.setDescription( nameDocument );
		
			documentList.add(model);
		}
		
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList, documentList);
		
		log.info( returnData.toString() );

		return returnData;
		
	}
	
	
	
	
}
