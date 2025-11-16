package com.consubanco.services.sap.crm.cobranza;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface CobranzaCRMService {

	public ArrayList<IProxyOutputData> getInfoRequests( ArrayList<String> accounts ) throws Exception;
	
}
