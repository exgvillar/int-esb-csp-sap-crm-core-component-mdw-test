/**
 * 
 */
package com.consupago.services.sap.crm.applications;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_ESTATUS_Model;

/**
 * @author user-admin
 *
 */
public class GetApplicationByStatusServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetApplicationByStatusServiceImplTC.class );

	/**
	 * 
	 */
	public GetApplicationByStatusServiceImplTC() {
		super();
	}

	/**
	 * 
	 * @param name
	 */
	public GetApplicationByStatusServiceImplTC(String name) {
		super(name);
	}
	
	
	public void testAuth( ) throws Exception {
		
		ApplicationsImpl processImpl = new ApplicationsImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<ZTT_ESTATUS_Model> status = new ArrayList<ZTT_ESTATUS_Model>();
		ZTT_ESTATUS_Model data = new ZTT_ESTATUS_Model();
		
		data.setStatus("E0030");
		status.add( data );
		
		ArrayList<IProxyOutputData> resultData = processImpl.getApplicationByStatus( status );
		
		log.info( resultData );
		
		assertEquals(false, resultData.isEmpty() );
	}
	
}
