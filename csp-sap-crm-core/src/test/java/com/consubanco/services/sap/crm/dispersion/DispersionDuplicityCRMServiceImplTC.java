package com.consubanco.services.sap.crm.dispersion;

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
public class DispersionDuplicityCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( DispersionDuplicityCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public DispersionDuplicityCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public DispersionDuplicityCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DispersionCRMService processImpl = new DispersionCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList<IProxyOutputData> returnList = processImpl.dispersionDuplicity("50384732", "DISPERSION_CLIENTE", false);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

}
