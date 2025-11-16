package com.consupago.services.sap.crm.casemgt;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ICaseManagement {

	public String attachDocumentToQuotation( String requestId, String fileName, String base64Content ) throws Exception;
	
	public String getECMIFolder( String requestId ) throws Exception;
	
	public String getDocumentURLFromContentManager( String requestId, String caseId, String documentName  ) throws Exception;
	
	public ArrayList<IProxyOutputData> getFileListFromCMN( String requestId ) throws Exception;
}
