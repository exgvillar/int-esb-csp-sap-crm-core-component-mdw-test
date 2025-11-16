package com.consupago.services.sap.crm.cis;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICISService {

	public ArrayList<IProxyOutputData> getCustomerData( String businessPartnerId ) throws Exception;
}
