package com.consubanco.services.sap.crm.commons.attachments;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface DeleteDocumentsService {
	
	/**
	 * Función RFC para efectuar el borrado de los documentos anexados a una
	 * solicitud.
	 * 
	 * @param requestId No. de la solicitud
	 * @param typeRequestId Tipo de la solicitud ( ZSTC )
	 * @param nameDocument Nombre del documento SI viene vacio se borran todos los adjuntos de la solicitud
	 * 
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> deleteDocumentAttachment(String requestId, String typeRequestId, String nameDocument) throws Exception;

}
