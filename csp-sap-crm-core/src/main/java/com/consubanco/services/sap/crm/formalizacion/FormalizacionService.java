package com.consubanco.services.sap.crm.formalizacion;

import java.util.ArrayList;

import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_OutputData;

public interface FormalizacionService {

	public ArrayList<ZCRMTESO_E001_INFO_FORMALIZA_OutputData> Formalizasolicitudes(ArrayList<String> arrIdSolicitudes) throws Exception;

	public ZCRMTESO_E001_INFO_FORMALIZA_OutputData Formalizasolicitudes(String idSolicitud) throws Exception;

}
