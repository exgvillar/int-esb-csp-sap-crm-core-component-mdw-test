package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;
import java.util.List;

import com.consubanco.adobe.forms.cub.model.FileBORequest;
import com.consubanco.adobe.forms.cub.model.FileBOResponse;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consubanco.sap.interfaces.common.terminados.ZCRMCRT_P001_SAVE_CONYUGE_Model;
import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consubanco.services.sap.crm.commons.models.AddressInputParameter;
import com.consubanco.services.sap.crm.commons.models.MarketingAttributeInputParameter;
import com.consubanco.services.sap.crm.commons.models.PersonInputParameter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface CommonCRMService {

	public ArrayList<IProxyOutputData> searchInterlocutor( String bpId, String clientId, String rfc, String name1, String name2, String lastname1, String lastname2, String curp, String nameCompany, boolean getBasicData ) throws Exception;
	
	public ArrayList<IProxyOutputData> saveInterlocutor( PersonInputParameter person ) throws Exception;
	
	public String getBPIdByUsername( String username ) throws Exception;
	
	public ArrayList<IProxyOutputData> searchAddress( String bpId ) throws Exception;
	
	public ArrayList<IProxyOutputData> saveAddress( String bpId, ArrayList<AddressInputParameter> address ) throws Exception;
	
	public ArrayList<IProxyOutputData> getAttributesMarketingBP( String bpId ) throws Exception;
	
	public boolean saveAttributesMarketingBP( String bpId, ArrayList<MarketingAttributeInputParameter> attributes ) throws Exception;
	
	public  ArrayList<IProxyOutputData> getOrgData( String businessPartnerId, String documentType ) throws Exception;
		
	public ArrayList<IProxyOutputData> getSubordinates( String bpId, String relationType ) throws Exception;
	
	public List<IProxyOutputData> saveEmployeesByBP( List<ZTL_EMPLEOBP_Model> employees ) throws Exception;
	
	public ArrayList<IProxyOutputData> getEmployeesByBp( String bpId ) throws Exception;
	
	public ArrayList<IProxyOutputData> saveCustomerFlag(String bpId, String operationTyp, String source,String folioApp) throws Exception;
	
	public FileBOResponse getCUBSurveyByCustomer(String customerBp, String biotaskID, ArrayList<FileBORequest> fileList, String applicationId, boolean Idresources) throws Exception;

	public ZTL_PEPS_Model getF02Data(String customerBp, String folioApplication) throws Exception;

	public ArrayList<IProxyOutputData> saveMaritalStatusByBp(ZCRMCRT_P001_SAVE_CONYUGE_Model req) throws Exception;

}
