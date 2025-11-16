package com.consupago.services.sap.crm.ivr;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IIVRService {

	public ArrayList<IProxyOutputData> getBusinessPartner( long clientId, int typeBussinesPartner) throws Exception;
	
	public ArrayList<IProxyOutputData> getCreditRequests( long clientId, int typeBussinesPartner, long creditRequestId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getInfoCRMTickets( String ticketId ) throws Exception;
}
