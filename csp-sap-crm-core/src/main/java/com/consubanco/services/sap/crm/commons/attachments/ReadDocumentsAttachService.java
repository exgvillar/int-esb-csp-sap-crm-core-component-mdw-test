/**
 * 
 */
package com.consubanco.services.sap.crm.commons.attachments;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public interface ReadDocumentsAttachService {
	
	/**
	 * Función que permite emitir un listado de los documentos anexados a una solicitud.
	 * 
	 * @param requestId No. de la solicitud
	 * @param typeRequestId Tipo de la solicitud ( ZSTC )
	 * 
	 * @return
	 * @throws Exception
	 */
	ArrayList<IProxyOutputData> readDocumentsAttachment(String requestId, String typeRequestId) throws Exception;

}
