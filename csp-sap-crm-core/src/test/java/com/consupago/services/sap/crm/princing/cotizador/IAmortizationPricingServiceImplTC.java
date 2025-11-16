/**
 * 
 */
package com.consupago.services.sap.crm.princing.cotizador;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.cotizador.model.ZCRMTESO_TASA_AMORT_Model;
import com.consupago.services.sap.crm.pricing.cotizador.IAmortizationPricingService;
import com.consupago.services.sap.crm.pricing.cotizador.IAmortizationPricingServiceImpl;

/**
 * @author juribe
 *
 */
public class IAmortizationPricingServiceImplTC extends TestCase {

	private static Log log = LogFactory.getLog( IAmortizationPricingServiceImplTC.class );
	
	
	/**
	 * 
	 */
	public IAmortizationPricingServiceImplTC() {
		super();
	}

	/**
	 * @param name
	 */
	public IAmortizationPricingServiceImplTC(String name) {
		super(name);
	}

	public void testDeberiaObtenerTablaDeAmortizacion() throws Exception{
		
		IAmortizationPricingService pricingServiceImpl = new IAmortizationPricingServiceImpl();
		
		
		ZCRMTESO_TASA_AMORT_Model model = new ZCRMTESO_TASA_AMORT_Model();

		model.setProductId("487");
		model.setCreditAmount("40000.0");
		model.setPlazo("48");
		model.setProductFrequency("Quincenal");
		model.setRequestId("");
		
		
		ArrayList<IProxyOutputData> amortizationTable = pricingServiceImpl.getAmortizationTable( model );
		
		log.info( amortizationTable.toString() );
		
		
	}
}
