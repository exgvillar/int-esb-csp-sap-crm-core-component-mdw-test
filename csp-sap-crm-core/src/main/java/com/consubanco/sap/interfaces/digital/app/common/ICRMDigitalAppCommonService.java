package com.consubanco.sap.interfaces.digital.app.common;


import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;


public interface ICRMDigitalAppCommonService {

	public ArrayList<IProxyOutputData> checkTermConditionsByCustomer( String customerBp, String sourceChannelApp ) throws Exception;
	
	public ArrayList<IProxyOutputData> updateTermsConditionByCustomer( String customerBp, String sourceChannelApp, boolean termsConditionsAccepted ) throws Exception;
		
}
