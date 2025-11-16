/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_E001_CATGENER_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_E004_BUSCACP_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_E012_LEE_PRODCB_ProxyImpl;
import com.consubanco.sap.interfaces.commons.ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class CatalogsCRMServiceImpl implements CatalogsCRMService {

	private static Log log = LogFactory.getLog( CatalogsCRMServiceImpl.class );
	/**
	 * 
	 */
	public CatalogsCRMServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons#getGenericCatalog( int catalogId, String parentKeyId ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getGenericCatalog( String catalogId, String parentKeyId ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_E001_CATGENER_ProxyImpl proxy = new ZCRMORI_E001_CATGENER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_IDCAT");
        input.setValue( StringUtils.trimToEmpty( catalogId ) );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_IDPARENTKEY");
        input.setValue( parentKeyId );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons#getSepomexCatalog( String zipCode ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getSepomexCatalog( String zipCode ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_E004_BUSCACP_ProxyImpl proxy = new ZCRMORI_E004_BUSCACP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CODPOS");
        input.setValue( StringUtils.trimToEmpty( ""+zipCode ) );
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
               
		return ( returnData );
	}

	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.commons#getProductsCatalog( String parentKeyId ) throws Exception;
	 */
	public ArrayList<IProxyOutputData> getProductsCatalog( String parentKeyId ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMORI_E012_LEE_PRODCB_ProxyImpl proxy = new ZCRMORI_E012_LEE_PRODCB_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_PARENT");
        input.setValue( parentKeyId );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}
	
	public ArrayList<IProxyOutputData> getMotivesByCause( String useType, String causeId ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
		ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl proxy = new ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CVEUSO");
        input.setValue( StringUtils.trimToEmpty( useType ) );
        inputParams.add( input );
               
        input = new ProxyInputParameter();
        input.setKey("I_IDCAUSA");
        input.setValue( StringUtils.trimToEmpty( causeId ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
       
		return ( returnData );
	}

	public ArrayList<IProxyOutputData> getRegimenFiscalCatalog( boolean isPhysicalPerson ) throws Exception 
	{
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
	    
		ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl proxy = new ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TIPOPERSONAQUEAPLICA");
        input.setValue( isPhysicalPerson ? "FISICA" : "MORAL" ); 
        inputParams.add( input );
	    
	    ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
	    
	
		return ( returnData );
	}
	
}
