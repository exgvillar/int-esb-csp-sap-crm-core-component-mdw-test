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
public class ProductsCatalogCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ProductsCatalogCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public ProductsCatalogCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public ProductsCatalogCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CatalogsCRMServiceImpl processImpl = new CatalogsCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		ArrayList returnList = processImpl.getProductsCatalog("BASE_FS_ACC02");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	
	 
}
