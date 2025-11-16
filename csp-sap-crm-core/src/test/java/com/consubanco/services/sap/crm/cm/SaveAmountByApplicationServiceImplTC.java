package com.consubanco.services.sap.crm.cm;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cm.models.ApplicationModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class SaveAmountByApplicationServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveAmountByApplicationServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveAmountByApplicationServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveAmountByApplicationServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		ICMService processImpl = new CMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ApplicationModel application = new ApplicationModel();
		application.setBranchId( "50000036" );
		application.setFolioApplication( "0050385718" );
		application.setRequestAmount( 25000.0 );
		application.setCncaAmount( 5000.0 );
		application.setIntercompanyAmount( 3000.0 );
		
		ArrayList<IProxyOutputData> returnList = processImpl.saveAmountByApplication( application );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
