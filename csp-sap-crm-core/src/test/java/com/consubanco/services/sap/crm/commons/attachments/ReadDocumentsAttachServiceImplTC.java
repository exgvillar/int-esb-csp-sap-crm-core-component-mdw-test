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
public class ReadDocumentsAttachServiceImplTC extends TestCase {
	
	private static final Log log = LogFactory.getLog(ReadDocumentsAttachServiceImplTC.class);

	/**
	 * 
	 */
	public ReadDocumentsAttachServiceImplTC() {
		super();
	}

	/**
	 * @param name
	 */
	public ReadDocumentsAttachServiceImplTC(String name) {
		super(name);
	}
	
	public void testDestination( ) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		ReadDocumentsAttachServiceImpl readDocAttachServiceImpl = new ReadDocumentsAttachServiceImpl();
		
		
		String requestId="60073166";
		String typeRequestId="ZSTC";
		
		ArrayList<IProxyOutputData> returnList = readDocAttachServiceImpl.readDocumentsAttachment(requestId, typeRequestId);
		
		log.info(returnList.toString());
		
		assertFalse(returnList.isEmpty());
		
	}
	
	

}
