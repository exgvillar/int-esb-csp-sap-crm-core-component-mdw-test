package com.consubanco.services.sap.crm.common.formatF02;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class GetFormatF02CRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetFormatF02CRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetFormatF02CRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetFormatF02CRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		FormatF02CRMServiceImpl processImpl = new FormatF02CRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		                
		ZTL_PEPS_Model model = processImpl.getFormatF02("60000257", "142");
		
		log.info( "Test - Response :: " + model.toString() );
	
	}


	 
}
