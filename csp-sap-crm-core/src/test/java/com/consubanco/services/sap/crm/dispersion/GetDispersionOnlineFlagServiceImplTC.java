package com.consubanco.services.sap.crm.dispersion;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class GetDispersionOnlineFlagServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetDispersionOnlineFlagServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetDispersionOnlineFlagServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetDispersionOnlineFlagServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DispersionCRMService processImpl = new DispersionCRMServiceImpl();
		
		
		 ArrayList<IProxyOutputData> returnData = processImpl.getDispersionOnlineFlag();
		
		log.info( returnData.toString() );
		
		assertNotNull( returnData );
	}

}
