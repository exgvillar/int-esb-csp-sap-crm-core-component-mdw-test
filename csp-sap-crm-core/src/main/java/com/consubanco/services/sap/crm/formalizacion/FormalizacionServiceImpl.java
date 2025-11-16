package com.consubanco.services.sap.crm.formalizacion;

import java.util.ArrayList;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_OutputData;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class FormalizacionServiceImpl implements FormalizacionService {

	public ArrayList<ZCRMTESO_E001_INFO_FORMALIZA_OutputData> Formalizasolicitudes(ArrayList<String> arrIdSolicitudes)
			throws Exception {
		ArrayList<ZCRMTESO_E001_INFO_FORMALIZA_OutputData> arrSolicitudes = new ArrayList<ZCRMTESO_E001_INFO_FORMALIZA_OutputData>();
        for (String solicitud : arrIdSolicitudes) {
        	ZCRMTESO_E001_INFO_FORMALIZA_OutputData returnData = this.Formalizasolicitudes(solicitud);
        	arrSolicitudes.add(returnData);
		}
        return arrSolicitudes;
	}

	public ZCRMTESO_E001_INFO_FORMALIZA_OutputData Formalizasolicitudes( String idSolicitud) throws Exception {
 		CRMLocalConfigEnvironmentData.instance();
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl proxy = new ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl();
        System.out.println(destination.getClient());
        ProxyInputParameterWithTable inputParams = null;
        	inputParams = new ProxyInputParameterWithTable();
        	inputParams.setRecordParam( new ArrayList<Object>() );
        	ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter inputRecord = new ProxyInputParameter();
        	inputRecord.setKey("ZOBJECT_ID");
        	inputRecord.setValue( idSolicitud );
        	recordParams1.add( inputRecord );
        	inputParams.getRecordParam().add( recordParams1 );
        	ZCRMTESO_E001_INFO_FORMALIZA_OutputData returnData = proxy.executeRemoteFunction(destination, inputParams );
        return returnData;
	}

}
