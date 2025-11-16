package com.consubanco.services.sap.crm.dispersion;

import java.util.ArrayList;
import java.util.Date;

import com.consubanco.sap.interfaces.common.status.ZCRMLCOM_E004_GET_DOC_STATUS_OutputData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface DispersionCRMService {

	public ArrayList<IProxyOutputData> dispersionDuplicity( String documentId, String event, boolean remove ) throws Exception;
	
	public ZCRMLCOM_E004_GET_DOC_STATUS_OutputData checkDocumentStatus( String documentId, String documentType ) throws Exception;
	
	public boolean updateDispersionOnlineFlag( String flag ) throws Exception;
	
	public ArrayList<IProxyOutputData> getDispersionOnlineFlag( ) throws Exception;
	
	public boolean calendarValidatedDay( Date currentDate, String calendarType ) throws Exception;
	
	public boolean startSPEIDevueltoSubprocess( String applicationId, String requestId, String bpId, String dispersionMode ) throws Exception;
	
}
