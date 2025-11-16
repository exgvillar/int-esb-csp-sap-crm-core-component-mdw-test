/**
 * 
 */
package com.consupago.services.sap.crm.pricing.cotizador;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.esb.validator.utils.Formatter;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cotizador.ZCRMTESO_TASA_AMORT_ProxyImpl;
import com.consupago.sap.interfaces.proxy.cotizador.model.ZCRMTESO_TASA_AMORT_Model;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author juribe
 * 
 */
public class IAmortizationPricingServiceImpl implements IAmortizationPricingService {

	private static Log log = LogFactory.getLog(IAmortizationPricingServiceImpl.class);

	public IAmortizationPricingServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 * @see com.consupago.services.sap.crm.pricing.cotizador.IAmortizationPricingService#getAmortizationTable(com.consupago.sap.interfaces.proxy.cotizador.model.ZCRMTESO_TASA_AMORT_Model)
	 */
	public ArrayList<IProxyOutputData> getAmortizationTable( ZCRMTESO_TASA_AMORT_Model model ) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMTESO_TASA_AMORT_ProxyImpl proxy = new ZCRMTESO_TASA_AMORT_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_PROD");
		input.setValue(model.getProductId());
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_MONTO");
		input.setValue(model.getCreditAmount());
		input.setType("java.lang.Double");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_NUMPAG");
		input.setValue(model.getPlazo());
		input.setType("java.lang.Integer");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_FREC");
		
		String freq = model.getProductFrequency();
		if (StringUtils.trimToNull(freq) != null)
			freq = freq.substring(0, 1);
		
		input.setValue(freq);
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_SOL");
		
		if ( StringUtils.isEmpty( model.getRequestId() ) )
			input.setValue("");
		else
			input.setValue(Formatter.fillStringWithZerosOnLeft(model.getRequestId(), 10));
		inputParams.add(input);

		log.info(inputParams.toString());
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction( destination, inputParams );

		log.info(returnData.toString());
		
		return returnData;
	}

}
