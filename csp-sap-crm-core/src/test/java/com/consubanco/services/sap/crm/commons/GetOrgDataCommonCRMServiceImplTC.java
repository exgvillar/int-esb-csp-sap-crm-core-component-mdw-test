/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

/**
 * @author rbecerra
 *
 */
public class GetOrgDataCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetOrgDataCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetOrgDataCommonCRMServiceImplTC() {
	}

	/**
	 * @param name
	 */
	public GetOrgDataCommonCRMServiceImplTC(String name) {
		super(name);
	}

	public void testServiceImplementation( ) throws Exception {
		CommonCRMServiceImpl serviceImpl = new CommonCRMServiceImpl();
		
//		ArrayList<IProxyOutputData> list = serviceImpl.getOrgData("0017102349", "ZSTC");
		ArrayList<IProxyOutputData> list = serviceImpl.getOrgData("0017102349", "");
		
		log.info( list.toString() );
		
		assertFalse( list.isEmpty() );
	}
}
