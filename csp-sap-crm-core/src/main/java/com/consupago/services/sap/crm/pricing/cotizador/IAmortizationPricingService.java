package com.consupago.services.sap.crm.pricing.cotizador;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.cotizador.model.ZCRMTESO_TASA_AMORT_Model;

public interface IAmortizationPricingService {

	
	ArrayList<IProxyOutputData> getAmortizationTable( ZCRMTESO_TASA_AMORT_Model data ) throws Exception;
	
}
