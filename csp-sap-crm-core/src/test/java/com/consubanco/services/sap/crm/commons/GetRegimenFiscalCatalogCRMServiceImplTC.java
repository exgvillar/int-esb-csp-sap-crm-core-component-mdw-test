package com.consubanco.services.sap.crm.commons;

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
public class GetRegimenFiscalCatalogCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetRegimenFiscalCatalogCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetRegimenFiscalCatalogCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetRegimenFiscalCatalogCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		CatalogsCRMService processImpl = new CatalogsCRMServiceImpl();
		
		boolean isPhysicalPerson = false;
		ArrayList<IProxyOutputData> returnList = processImpl.getRegimenFiscalCatalog(isPhysicalPerson);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

}
