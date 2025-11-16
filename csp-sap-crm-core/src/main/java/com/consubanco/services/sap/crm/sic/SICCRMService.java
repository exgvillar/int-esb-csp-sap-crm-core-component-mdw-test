package com.consubanco.services.sap.crm.sic;

import java.util.ArrayList;
import java.util.Date;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface SICCRMService {

	public ArrayList<IProxyOutputData> getAgreementsByBP( String bpId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getDependenceByAgreement( String agreementId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getDependenceDetail( String dependenceId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getOriginationDetail( String requestId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getDynamicsFieldsRequest( String requestId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getRequestsFormalized( Date start, Date end ) throws Exception;
	
}
