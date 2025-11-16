package com.consupago.services.sap.crm.pricing;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface IConveniosByStatePricingService {

	ArrayList<IProxyOutputData> getConveniosByState( String siglaEmpresa, String estado ) throws Exception;
}
