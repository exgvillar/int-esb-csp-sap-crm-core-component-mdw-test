package com.consupago.services.sap.crm.calendar;

import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.destinations.CustomDestinationDataProvider;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class CalendarServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CalendarServiceImplTC.class );
	
	/**
	 * 
	 */
	public CalendarServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public CalendarServiceImplTC(String name) {
		super(name);
		
	}
	
	public void testAuth( ) throws Exception {
		
		CalendarServiceImpl processImpl = new CalendarServiceImpl();
		
		CustomDestinationDataProvider.instance();
		Calendar c = Calendar.getInstance();
		ArrayList<IProxyOutputData> returnList = processImpl.calculateDate( c.getTime() , 5, "Z1", false);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


	 
}
