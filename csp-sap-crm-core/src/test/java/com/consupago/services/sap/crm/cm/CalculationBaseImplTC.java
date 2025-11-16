package com.consupago.services.sap.crm.cm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
public class CalculationBaseImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CalculationBaseImplTC.class );
	
	/**
	 * 
	 */
	public CalculationBaseImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CalculationBaseImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		CalculationBaseImpl processImpl = new CalculationBaseImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList returnList = processImpl.getCalculationBase("CSCSP", null, "0");
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}

	
}
