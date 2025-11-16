package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.esb.validator.constants.CommonConstants;
import com.consubanco.services.sap.crm.commons.models.AddressInputParameter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

/**
 * @author hsanchez
 *
 */
public class SaveAddressBPCommonCRMServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( SaveAddressBPCommonCRMServiceImplTC.class );
	
	/**
	 * 
	 */
	public SaveAddressBPCommonCRMServiceImplTC() {
		
	}

	/**
	 * @param name
	 */
	public SaveAddressBPCommonCRMServiceImplTC(String name) {
		super(name);
		
	}
	
		public void testAuthSaveAddress( ) throws Exception {
		
		CommonCRMServiceImpl processImpl = new CommonCRMServiceImpl();
		
		CRMLocalConfigEnvironmentData.instance();
		
		ArrayList<AddressInputParameter> addressList = new ArrayList<AddressInputParameter>();
		
		//address1
		AddressInputParameter address1 = new AddressInputParameter();
		address1.setAddressId( "5360068" );
		address1.setAddressTypeId( "XXDEFAULT" );
		address1.setAddressTypeDesc( "Direc.pral." );
		address1.setAddressTypeViaId( "AV" );
		address1.setAddressTypeViaDesc( "AVENIDA" );
		address1.setStreet( "PASEO DE LA REFORMA" );
		address1.setInternalNumber( "PISO 12" );
		address1.setExternalNumber( "2654" );
		address1.setZipCode( "11950" );
		address1.setSuburb( "LOMAS ALTAS" );
		address1.setSettlementTypeId( "COL" );
		address1.setSettlementTypeDesc( "COLONIA" );
		address1.setTown( "MÉXICO, POB." );
		address1.setTownship( "MIGUEL HIDALGO" );
		address1.setCity( "DISTRITO FEDERAL" );
		address1.setState( "DF" );
		address1.setCountry( "MX" );
		address1.setBetweenStreet( "CONSTITUYENTES" );
		address1.setAndStreet( "REFORMA" );
		address1.addPhone( "50813390", "7615", CommonConstants.PHONETYPE_FIJO );
		address1.addPhone( "5512345678", "", CommonConstants.PHONETYPE_MOVIL );
		address1.addPhone( "50813390", "7616", CommonConstants.PHONETYPE_FAX );
		addressList.add( address1 );
		
		//address2
		AddressInputParameter address2 = new AddressInputParameter();
		address2.setAddressId( "" );
		address2.setAddressTypeId( "ALTER_TO" );
		address2.setAddressTypeDesc( "Dirección Alterna" );
		address2.setAddressTypeViaId( "AV" );
		address2.setAddressTypeViaDesc( "AVENIDA" );
		address2.setStreet( "SANTA FE" );
		address2.setInternalNumber( "PISO 16" );
		address2.setExternalNumber( "241" );
		address2.setZipCode( "01190" );
		address2.setSuburb( "SANTA FE" );
		address2.setSettlementTypeId( "COL" );
		address2.setSettlementTypeDesc( "Colonia" );
		address2.setTown( "MÉXICO, POB." );
		address2.setTownship( "CUAJIMALPA" );
		address2.setCity( "DISTRITO FEDERAL" );
		address2.setState( "DF" );
		address2.setCountry( "MX" );
		address2.setBetweenStreet( "CONSTITUYENTES" );
		address2.setAndStreet( "REFORMA" );
		address2.addPhone( "91777928", "7924", CommonConstants.PHONETYPE_FIJO );
		address2.addPhone( "5512345678", "", CommonConstants.PHONETYPE_MOVIL );
		address2.addPhone( "91777928", "7929", CommonConstants.PHONETYPE_FAX );
		addressList.add( address2 );
		
		ArrayList returnList = processImpl.saveAddress("142", addressList);
		
		log.info( returnList );
		
		assertNotNull( returnList );
	}


		 
}
