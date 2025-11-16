/**
 * 
 */
package com.consupago.services.sap.crm.calendar;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.calendar.Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class CalendarServiceImpl implements ICalendarService {

	private static Log log = LogFactory.getLog( CalendarServiceImpl.class );
	/**
	 * 
	 */
	public CalendarServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consupago.services.sap.crm.calendar.ICalendarService#calculateDate(java.lang.String, int, java.lang.String)
	 */
	public ArrayList<IProxyOutputData> calculateDate(Date dateToBeCalculated, int daysToAdvance,
			String calendarType, boolean countWorkingDays) throws Exception {
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl proxy = new Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_FECHA");
        input.setDateValue( dateToBeCalculated  );
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DIAS");
        input.setValue( StringUtils.trimToEmpty( ""+daysToAdvance ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALENDARIO");
        input.setValue( StringUtils.trimToEmpty( calendarType ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DIASHAB");
        input.setValue( countWorkingDays ? "X" : "" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}

}
