package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SearchInterlocutorCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SearchInterlocutorCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public SearchInterlocutorCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SearchInterlocutorCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthBP( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.searchInterlocutor(
				"142", "", "", "", "", "", "", "", "", false);
				//"", "", "LOCM8301051", "", "", "", "", "");	
				//bpId, clientId, rfc, name1, name2, lastname1, lastname2, nameCompany);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	

	public void testAuthRFC( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.searchInterlocutor(
				"", "", "RELR66051", "", "", "", "", "", "", false);	
				//RELR66051772A
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
	public void testAuthName( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.searchInterlocutor(
				"", "", "", "MANUEL", "ALEJANDRO", "LOPEZ", "CASTILLO", "", "", true);	
				//bpId, clientId, rfc, name1, name2, lastname1, lastname2, nameCompany);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
	
	public void testAuthCurp( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.searchInterlocutor(
				"", "", "", "", "", "", "", "RACA720520HNEMRN03", "", true);	
				//bpId, clientId, rfc, name1, name2, lastname1, lastname2, curp, nameCompany);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
			 
}
