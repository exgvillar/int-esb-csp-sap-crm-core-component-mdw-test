package com.consubanco.services.sap.crm.dispersion;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.status.ZCRMLCOM_E004_GET_DOC_STATUS_OutputData;

/**
 * @author hsanchez
 *
 */
public class CheckDocumentStatusCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CheckDocumentStatusCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public CheckDocumentStatusCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CheckDocumentStatusCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DispersionCRMService processImpl = new DispersionCRMServiceImpl();
		
		
		ZCRMLCOM_E004_GET_DOC_STATUS_OutputData returnData = processImpl.checkDocumentStatus("50599649", "ZCSP");
		
		log.info( returnData.toString() );
		
		assertNotNull( returnData );
	}

}
