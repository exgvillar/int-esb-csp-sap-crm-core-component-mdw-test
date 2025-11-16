package com.consupago.services.sap.crm.convenios;

import com.consupago.sap.interfaces.proxy.convenios.ZFM_FECHAS_JURIDICO_OutputData;

public interface IConveniosInfoService {

	public ZFM_FECHAS_JURIDICO_OutputData getConveniosLegalDates( String productId ) throws Exception;
}
