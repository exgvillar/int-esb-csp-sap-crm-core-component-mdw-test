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
public class CMTotalByBranchImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CMTotalByBranchImplTC.class );
	
	/**
	 * 
	 */
	public CMTotalByBranchImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CMTotalByBranchImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		CommissionManagerServicesCoreImpl processImpl = new CommissionManagerServicesCoreImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList returnList = processImpl.getTotalPerBranch("112", 
									Date.valueOf("2012-10-01"), 
									Date.valueOf("2012-10-30"));
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
}
