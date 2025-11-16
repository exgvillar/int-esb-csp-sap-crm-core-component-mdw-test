package com.consubanco.services.sap.crm.cobranza;

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
public class InfoRequestsCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( InfoRequestsCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public InfoRequestsCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public InfoRequestsCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		CobranzaCRMService processImpl = new CobranzaCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<String> accounts = new ArrayList<String>();
		accounts.add("1611284");
		accounts.add("1610893");
		
		ArrayList<IProxyOutputData> returnList = processImpl.getInfoRequests(accounts);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
