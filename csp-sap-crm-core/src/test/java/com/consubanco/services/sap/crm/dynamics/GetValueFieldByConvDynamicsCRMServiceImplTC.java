package com.consubanco.services.sap.crm.dynamics;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.services.sap.crm.dynamics.DynamicsCRMServiceImpl;
import com.consupago.services.sap.crm.dynamics.IDynamicsCRMService;

/**
 * @author hsanchez
 *
 */
public class GetValueFieldByConvDynamicsCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetValueFieldByConvDynamicsCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetValueFieldByConvDynamicsCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetValueFieldByConvDynamicsCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		IDynamicsCRMService processImpl = new DynamicsCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		//getValueFieldByConvenio("10000590", "CSP_NAC_PEMEX", "33", "8", "JUANITO");
		ArrayList<IProxyOutputData> returnList = processImpl.getValueFieldByConvenio("", "CSP_NAC_PEMEX", "33", "8", "");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

}
