/**
 * 
 */
package com.consubanco.services.sap.crm.commons.attachments;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class DeleteDocumentsServiceImplTC extends TestCase {

	private static final Log log = LogFactory.getLog(DeleteDocumentsServiceImplTC.class);

	/**
	 * 
	 */
	public DeleteDocumentsServiceImplTC() {
		super();
	}

	/**
	 * @param name
	 */
	public DeleteDocumentsServiceImplTC(String name) {
		super(name);
	}
	
	public void testDeleteDocumentsServiceImpl( ) throws Exception{
		CRMLocalConfigEnvironmentData.instance();
		
		DeleteDocumentsService deleteDocumentsServiceImpl = new DeleteDocumentsServiceImpl();
		
		String requestId="60073166";
		String typeRequestId="ZSTC";
		String nameDocument="";
		
		ArrayList<IProxyOutputData> returnList = deleteDocumentsServiceImpl.deleteDocumentAttachment(requestId, typeRequestId, nameDocument);
		
		log.info(returnList.toString());
		
		assertFalse(!returnList.isEmpty());
		
	}
	
	
}
