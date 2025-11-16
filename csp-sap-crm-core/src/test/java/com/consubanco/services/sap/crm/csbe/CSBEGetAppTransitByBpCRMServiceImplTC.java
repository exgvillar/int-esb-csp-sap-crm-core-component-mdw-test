package com.consubanco.services.sap.crm.csbe;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class CSBEGetAppTransitByBpCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CSBEGetAppTransitByBpCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public CSBEGetAppTransitByBpCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CSBEGetAppTransitByBpCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CSBEmpresarialCRMService processImpl = new CSBEmpresarialCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList<IProxyOutputData> returnList = processImpl.getApplicationsTransitByBp("0002600689", "AACE700101");
//		ArrayList returnList = processImpl.getApplicationsTransitByBp("0002600689", "");
//		ArrayList returnList = processImpl.getApplicationsTransitByBp("", "AACE700101");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

}
