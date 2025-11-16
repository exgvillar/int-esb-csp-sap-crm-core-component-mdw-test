package com.consubanco.services.sap.crm.csbe;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface CSBEmpresarialCRMService {

	public ArrayList<IProxyOutputData> getApplicationsTransitByBp( String bpId, String rfc ) throws Exception;
	
	
}
