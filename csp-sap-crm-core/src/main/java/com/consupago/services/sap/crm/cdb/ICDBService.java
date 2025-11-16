package com.consupago.services.sap.crm.cdb;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICDBService {

	public ArrayList<IProxyOutputData> getSalesAmountConvenio( String crmConvenio_Id ) throws Exception;
	
}
