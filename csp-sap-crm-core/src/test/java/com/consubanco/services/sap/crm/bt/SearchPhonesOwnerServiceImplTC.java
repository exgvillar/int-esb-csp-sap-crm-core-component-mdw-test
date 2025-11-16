package com.consubanco.services.sap.crm.bt;

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
public class SearchPhonesOwnerServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SearchPhonesOwnerServiceImplTC.class );
	
	/**
	 * 
	 */
	public SearchPhonesOwnerServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SearchPhonesOwnerServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMBuroTelefonicoService processImpl = new CRMBuroTelefonicoServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		String bp = ""; //0000123938
		String rfc = "FOVY8208054I7"; //FOVY8208054I7
		String curp = ""; //FOVY820805MTLLLN07
		String name1 = ""; //YENITZE
		String name2 = ""; //ANALLELY
		String lastName1 = ""; //FLORES
		String lastName2 = ""; //VILLANUEVA
		
		ArrayList<IProxyOutputData> returnList = processImpl.searchPhoneByOwner(bp, rfc, curp, name1, name2, lastName1, lastName2);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


}
