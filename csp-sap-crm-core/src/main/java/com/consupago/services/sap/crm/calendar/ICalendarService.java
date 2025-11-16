package com.consupago.services.sap.crm.calendar;

import java.util.Date;
import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICalendarService {

	public ArrayList<IProxyOutputData> calculateDate( Date dateToBeCalculated, int daysToAdvance, String calendarType, boolean countWorkingDays) throws Exception;
}
