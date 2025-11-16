package com.consupago.services.sap.crm.lcom;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ILCOM_SMS_Service {

	public ArrayList<IProxyOutputData> getLCOMPurchasedOperations( String status, ArrayList<String> categoryList ) throws Exception;
}
