package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.commons.models.MarketingAttributeInputParameter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SaveMktAttCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveMktAttCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveMktAttCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveMktAttCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
		public void testAuthSaveAddress( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<MarketingAttributeInputParameter> attributesList = new ArrayList<MarketingAttributeInputParameter>();
		
		//attribute1
		MarketingAttributeInputParameter attribute1 = new MarketingAttributeInputParameter();
		attribute1.setAttributeGroupId( "Z_MKT_TIPO_PROP" );
		attribute1.setAttributeGroupDesc( "" );
		attribute1.setAttributeId( "Z_MKT_ANIOS_RES" );
		attribute1.setAttributeDesc( "" );
		attribute1.setAttributeValue( "8" );
		attributesList.add( attribute1 );
		
		//attribute2
		MarketingAttributeInputParameter attribute2 = new MarketingAttributeInputParameter();
		attribute2.setAttributeGroupId( "Z_MKT_DATOSBANCA" );
		attribute2.setAttributeGroupDesc( "" );
		attribute2.setAttributeId( "Z_MKT_PRECALIFICACION" );
		attribute2.setAttributeDesc( "" );
		attribute2.setAttributeValue( "true" );
		attributesList.add( attribute2 );
		
		boolean returnResult = processImpl.saveAttributesMarketingBP("142", attributesList);
		
		log.info( returnResult );
		
		assertTrue( returnResult );

	}


		 
}
