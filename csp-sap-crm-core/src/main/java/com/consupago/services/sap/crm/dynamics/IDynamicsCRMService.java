package com.consupago.services.sap.crm.dynamics;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IDynamicsCRMService {

	public ArrayList<IProxyOutputData> getValueFieldByConvenio( String crmConvenio, String brmsConvenio, String documentId, String fieldId, String value ) throws Exception;
	
	
}
