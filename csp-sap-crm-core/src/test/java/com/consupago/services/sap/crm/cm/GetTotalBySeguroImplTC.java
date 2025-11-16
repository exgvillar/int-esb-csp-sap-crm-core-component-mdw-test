package com.consupago.services.sap.crm.cm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author ramon.becerra
 *
 */
public class GetTotalBySeguroImplTC extends TestCase {

	private static Log log = LogFactory.getLog( GetTotalBySeguroImplTC.class );
	
	/**
	 * 
	 */
	public GetTotalBySeguroImplTC() {
		
	}

	/**
	 * @param name
	 */
	public GetTotalBySeguroImplTC(String name) {
		super(name);
		
	}
	
	public void _testAuth( ) throws Exception {
		
		CommissionManagerServicesCoreImpl processImpl = new CommissionManagerServicesCoreImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList returnList = processImpl.getBusinessPartnerSalesTotals("314061", "PROMO",
									Date.valueOf("2012-10-01"), 
									Date.valueOf("2012-10-30"));
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
	public void testAuth1( ) throws Exception {
		
		CommissionManagerServicesCoreImpl processImpl = new CommissionManagerServicesCoreImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList returnList = processImpl.getBusinessPartnerSalesTotals("10000500", "SUPERVISOR",
									Date.valueOf("2012-09-01"), 
									Date.valueOf("2012-09-30"));
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}
	
}
