package com.consupago.services.sap.crm.recomendados;

import java.sql.Date;
import java.util.ArrayList;

import com.consubanco.sap.interfaces.recomendados.model.ESTATUS_MOTIVO_Model;
import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.services.sap.crm.recomendados.models.DocumentModel;
public interface RecommendedCRMService {
	
	public ArrayList<IProxyOutputData> startRecommended( String requestId ) throws Exception;

	public ArrayList<IProxyOutputData> getInfoCustomerRefer( String businessPartner ) throws Exception ;
	
	public ArrayList<IProxyOutputData> getServiceOrderByStatus( ArrayList<String> statusList ) throws Exception ;
	
	public ArrayList<IProxyOutputData> addUpdateServiceOrder( ORDEN_SERVICIO_Model serviceOrder ) throws Exception;
	
	public ArrayList<IProxyOutputData> updateStatusMotive( ESTATUS_MOTIVO_Model inputParamsData ) throws Exception;

	public ArrayList<IProxyOutputData> updateServiceOrderByReference( String reference, String status, Date fechaCobro ) throws Exception;
	
	public ArrayList<DocumentModel> attachDocuments( String serviceOrderId,  ArrayList<DocumentModel> documents ) throws Exception;
	
	public ArrayList<IProxyOutputData> updateServiceOrderBrmsBkr( ORDEN_SERVICIO_Model serviceOrder ) throws Exception;

	public ArrayList<IProxyOutputData> getExpirationDate( Date date ) throws Exception;
	
}