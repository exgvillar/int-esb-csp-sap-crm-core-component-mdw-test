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
public class CatalogsCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CatalogsCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public CatalogsCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CatalogsCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuthGenericCatalog( ) throws Exception {
		
		CatalogsCRMServiceImpl processImpl = new CatalogsCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getGenericCatalog("1", "0");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	public void testAuthSepomexCatalog( ) throws Exception {
		
		CatalogsCRMServiceImpl processImpl = new CatalogsCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getSepomexCatalog( "90280" );
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	public void testAuthMotivesByCauseCatalog( ) throws Exception {
		
		CatalogsCRMServiceImpl processImpl = new CatalogsCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getMotivesByCause("TC","3");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

}
