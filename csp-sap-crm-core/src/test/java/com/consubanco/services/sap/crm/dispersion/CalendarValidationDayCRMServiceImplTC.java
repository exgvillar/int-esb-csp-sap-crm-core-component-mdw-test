package com.consubanco.services.sap.crm.dispersion;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.format.SAPFormatter;

/**
 * @author hsanchez
 *
 */
public class CalendarValidationDayCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CalendarValidationDayCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public CalendarValidationDayCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CalendarValidationDayCRMServiceImplTC(String name) {
		super(name);
		
	}
	
	public void test( ) throws Exception {
		
		DispersionCRMService processImpl = new DispersionCRMServiceImpl();
		
		
		boolean isLaborDay = processImpl.calendarValidatedDay( SAPFormatter.formatSAPDate( "13.12.2016" ) , "Z1");
		
		log.info( isLaborDay );
		
		assertTrue( isLaborDay );
	}

}
