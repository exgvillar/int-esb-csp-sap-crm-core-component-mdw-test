package com.consupago.services.sap.crm.webpage;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IPricingService {

	public ArrayList<IProxyOutputData> getStates( ) throws Exception;
}
