package com.consubanco.services.sap.crm.common.formatF02;

import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;


public interface FormatF02CRMService {

	public boolean saveFormatF02( String requestId, ZTL_PEPS_Model pepData ) throws Exception;
	
	public boolean saveQEQ( String customerId, String requestId, ZTL_PEPS_Model pepData ) throws Exception;
	
	public ZTL_PEPS_Model getFormatF02( String applicationId, String customerId ) throws Exception;
	
	
}
