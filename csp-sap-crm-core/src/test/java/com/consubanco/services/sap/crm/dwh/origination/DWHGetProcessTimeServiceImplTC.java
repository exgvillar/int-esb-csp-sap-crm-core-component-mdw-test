package com.consubanco.services.sap.crm.dwh.origination;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.dwh.origination.ZRFC_GEN_GET_DATSOL_InputData;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class DWHGetProcessTimeServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( DWHGetProcessTimeServiceImplTC.class );
	
	/**
	 * 
	 */
	public DWHGetProcessTimeServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public DWHGetProcessTimeServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		DWHGetOriginationProcessTimeListImpl processImpl = new DWHGetOriginationProcessTimeListImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		 ArrayList<ZRFC_GEN_GET_DATSOL_InputData> inputParams = new ArrayList<ZRFC_GEN_GET_DATSOL_InputData>();
	        
		 ZRFC_GEN_GET_DATSOL_InputData input = new ZRFC_GEN_GET_DATSOL_InputData();
	     input.setRequestId("0050096281");        
	     inputParams.add( input );
		
		ArrayList returnList = processImpl.getOriginationProcessTimeList(inputParams);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
