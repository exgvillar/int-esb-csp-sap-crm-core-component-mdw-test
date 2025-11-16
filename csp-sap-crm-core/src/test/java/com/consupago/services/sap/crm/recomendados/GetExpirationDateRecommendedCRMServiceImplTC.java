package com.consupago.services.sap.crm.recomendados;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.calendar.Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData;

/**
 * @author omar.corona
 *
 */
public class GetExpirationDateRecommendedCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetExpirationDateRecommendedCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public GetExpirationDateRecommendedCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetExpirationDateRecommendedCRMServiceImplTC(String name) {
		super(name);
		
	}

	public void testGetExpirationDate( ) throws Exception {
		
		RecommendedCRMServiceImpl processImpl = new RecommendedCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();

		ArrayList<IProxyOutputData> returnList = processImpl.getExpirationDate(new Date(System.currentTimeMillis()));
 
		Iterator<IProxyOutputData> iter = returnList.iterator();
		
		java.util.Date expirationDate = null;
			
		while (iter.hasNext()) {
			Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData data = (Z_RFC_BRMS_CRM_CALCULAFECHA_OutputData) iter
					.next();
			expirationDate = data.getFechaCalculada();
		}
	
		log.info( "Date Expiration Date:" + expirationDate.toString() );

		assertNotNull( returnList );
		
	}
	 
}
