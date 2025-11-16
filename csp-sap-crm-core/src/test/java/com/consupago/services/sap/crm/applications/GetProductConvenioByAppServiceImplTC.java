package com.consupago.services.sap.crm.applications;


import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZTL_SOLICITUD_Model;

/**
 * @author hsanchez
 *
 */
public class GetProductConvenioByAppServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetProductConvenioByAppServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetProductConvenioByAppServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetProductConvenioByAppServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		ApplicationsImpl processImpl = new ApplicationsImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<ZTL_SOLICITUD_Model> applications = new ArrayList<ZTL_SOLICITUD_Model>();
		
		ZTL_SOLICITUD_Model data = new ZTL_SOLICITUD_Model();
		data.setApplicationId( "50000430" );
		applications.add( data );
		ArrayList<IProxyOutputData> resultData = processImpl.getProductConvenioByApp( applications );
		
		log.info( resultData );
		
		assertEquals(true, resultData.isEmpty() );
	}


	 
}
