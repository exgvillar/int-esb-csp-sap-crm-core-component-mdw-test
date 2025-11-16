package com.consubanco.services.sap.crm.debtBalanceInsurance;

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
public class GetSSDApplicationsImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetSSDApplicationsImplTC.class );
	
	/**
	 * 
	 */
	public GetSSDApplicationsImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetSSDApplicationsImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DebtBalanceInsuranceService processImpl = new DebtBalanceInsuranceServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<IProxyOutputData> returnList = processImpl.getSSDAplications( "E0002" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
