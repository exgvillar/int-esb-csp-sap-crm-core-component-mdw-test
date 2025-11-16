package com.consupago.services.sap.crm.casemgt;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class GetDocumentURLFromCMCaseImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetDocumentURLFromCMCaseImplTC.class );
	
	/**
	 * 
	 */
	public GetDocumentURLFromCMCaseImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetDocumentURLFromCMCaseImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		AttachDocumentToCaseImpl processImpl = new AttachDocumentToCaseImpl();
		
		CRMLocalConfigEnvironmentData.instance();		
		
		
		String URL = processImpl.getDocumentURLFromContentManager("0050095368", "", "Conapa3.pdf");
		
		log.info( URL );
			
	}

	
}
