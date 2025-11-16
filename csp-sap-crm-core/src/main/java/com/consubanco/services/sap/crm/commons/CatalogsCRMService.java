package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface CatalogsCRMService {

	public ArrayList<IProxyOutputData> getGenericCatalog( String catalogId, String parentKeyId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getSepomexCatalog( String zipCode ) throws Exception;
	
	public ArrayList<IProxyOutputData> getProductsCatalog( String parentKeyId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getMotivesByCause( String useType, String causeId ) throws Exception;
	
	public ArrayList<IProxyOutputData> getRegimenFiscalCatalog( boolean isPhysicalPerson ) throws Exception;
}
