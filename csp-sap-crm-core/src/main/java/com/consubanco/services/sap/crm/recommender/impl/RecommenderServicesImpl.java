/**
 * 
 */
package com.consubanco.services.sap.crm.recommender.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.attachments.ZCRMORI_P008_ATTACH_FILE_OutputData;
import com.consubanco.sap.interfaces.commons.attachments.ZCRMORI_P008_ATTACH_FILE_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_E001_SEARCHREC_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_E002_ENROLREC_BY_STS_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_E004_GENERAI610RECO_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_E005_GETOSBYSTATUS_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P001_SAVE_ENROLREC_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P003_SAVE_CODENROLREC_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P005_UPDSTS_SO_RECO_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl;
import com.consubanco.sap.interfaces.recommender.ZCRMRECO_P011_PDSO_I610_ProxyImpl;
import com.consubanco.services.sap.crm.recommender.RecommenderServices;
import com.consubanco.services.sap.crm.recommender.model.DocumentModel;
import com.consubanco.services.sap.crm.recommender.model.SaveElegibilityRequest;
import com.consubanco.services.sap.crm.recommender.model.SaveEnrollmentTaskRequest;
import com.consubanco.services.sap.crm.recommender.model.SaveServiceOrderRequest;
import com.consubanco.services.sap.crm.recommender.model.SearchInterlocutorRequest;
import com.consubanco.services.sap.crm.recommender.model.TaskSOAssociateRequest;
import com.consubanco.services.sap.crm.recommender.model.UpdateServiceOrderStatusAndLoteRequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import sun.misc.BASE64Decoder;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class RecommenderServicesImpl implements RecommenderServices {

	private static Log log = LogFactory.getLog(RecommenderServicesImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consubanco.services.sap.crm.recommender.RecommenderServices#
	 * searchInterlocutor(com.consubanco.services.sap.crm.recommender.model.
	 * SearchInterlocutorRequest)
	 */
	public ArrayList<IProxyOutputData> searchInterlocutor(SearchInterlocutorRequest searchInterlocutorRequest)
			throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_E001_SEARCHREC_ProxyImpl proxy = new ZCRMRECO_E001_SEARCHREC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		if (StringUtils.isEmpty(searchInterlocutorRequest.getBp())) {
			input.setValue("");
		} else {
			input.setValue(Formatter.fillStringWithZerosOnLeft(searchInterlocutorRequest.getBp(), 10));
		}
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CLIENT");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getClientId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_RFC");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getRfc()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CURP");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getCurp()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NAME1");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getName1()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NAME2");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getName2()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_APEPAT");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getApePat()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_APEMAT");
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getApeMat()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setValue(StringUtils.trimToEmpty(searchInterlocutorRequest.getCompanyId()));
		input.setKey("I_COMPANY");
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);

	}

	public ArrayList<DocumentModel> attachDocuments(String documentId, String documentType,
			ArrayList<DocumentModel> documents) throws Exception {

		ArrayList<DocumentModel> returnDocuments = new ArrayList<DocumentModel>();

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		Iterator<DocumentModel> documentIter = documents.iterator();
		while (documentIter.hasNext()) {

			DocumentModel document = documentIter.next();

			OutputStream os = null;
			BASE64Decoder decoder = new BASE64Decoder();
			String path = "/BF/Recomendados/Spool/" + document.getFilename();
			try {
				os = new FileOutputStream(path);
				byte[] buf = decoder.decodeBuffer(document.getBase64Content());
				os.write(buf);
				os.close();
			} catch (Exception ex) {
				log.error("saving file", ex);
				throw ex;
			} finally {
				if (os != null)
					try {
						os.close();
						os = null;
					} catch (Exception ex) {
					}
			}

			File file = new File(path);

			ZCRMORI_P008_ATTACH_FILE_ProxyImpl proxy1 = new ZCRMORI_P008_ATTACH_FILE_ProxyImpl();

			ArrayList<ProxyInputParameter> inputParams1 = new ArrayList<ProxyInputParameter>();
			ProxyInputParameter input1 = new ProxyInputParameter();
			input1.setKey("LV_OBJECT");
			input1.setValue(Formatter.fillStringWithZerosOnLeft(documentId, 10));
			inputParams1.add(input1);
			input1 = new ProxyInputParameter();
			input1.setKey("LV_TIPDOC");
			input1.setValue(documentType);
			inputParams1.add(input1);
			input1 = new ProxyInputParameter();
			input1.setKey("LV_FILE_NAME");
			input1.setValue(file.getName());
			inputParams1.add(input1);
			input1 = new ProxyInputParameter();
			input1.setKey("LV_TIPO");
			input1.setValue("2");
			inputParams1.add(input1);

			ArrayList<IProxyOutputData> returnData1 = proxy1.executeRemoteFunction(destination, inputParams1, file);
			Iterator<IProxyOutputData> returnDocIter = returnData1.iterator();
			while (returnDocIter.hasNext()) {
				ZCRMORI_P008_ATTACH_FILE_OutputData returnDoc = (ZCRMORI_P008_ATTACH_FILE_OutputData) returnDocIter
						.next();
				DocumentModel returnDocument = new DocumentModel();
				returnDocument.setFilename(file.getName());
				returnDocument.setUrl(returnDoc.getUrl());
				returnDocuments.add(returnDocument);
			}

		}

		return (returnDocuments);
	}

	public ArrayList<IProxyOutputData> saveEnrollmentTask(SaveEnrollmentTaskRequest saveEnrollmentTaskRequest)
			throws Exception {
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P001_SAVE_ENROLREC_ProxyImpl proxy = new ZCRMRECO_P001_SAVE_ENROLREC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUM_TAREA");
		input.setValue(StringUtils.trimToEmpty(saveEnrollmentTaskRequest.getTaskId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADOR");
		input.setValue(Formatter.fillStringWithZerosOnLeft(saveEnrollmentTaskRequest.getRecommenderBp(), 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BP_EMPLEADO_RESP");
		input.setValue(Formatter.fillStringWithZerosOnLeft(saveEnrollmentTaskRequest.getEmployeeBP(), 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_MEDIO_CONTACTO");
		input.setValue(StringUtils.trimToEmpty(saveEnrollmentTaskRequest.getContactMedium()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_ORIGEN_CONTACTO");
		input.setValue(StringUtils.trimToEmpty(saveEnrollmentTaskRequest.getContactSource()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_OBSERVACIONES");
		input.setValue(StringUtils.trimToEmpty(saveEnrollmentTaskRequest.getObservations()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_PROCESS_BPM");
		input.setValue(StringUtils.trimToEmpty(saveEnrollmentTaskRequest.getProcessBPMid()));
		inputParams.add(input);
		
		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> updateStatusEnrollmentTask(String taskId, String statusId) throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl proxy = new ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_TAREA_ENROL");
		input.setValue(StringUtils.trimToEmpty(taskId));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CLAVE_ESTATUS");
		input.setValue(StringUtils.trimToEmpty(statusId));
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> getEnrollmentTaskByStatus(List<String> statusList) throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_E002_ENROLREC_BY_STS_ProxyImpl proxy = new ZCRMRECO_E002_ENROLREC_BY_STS_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();

		ProxyInputParameter input = null;

		for (String statusId : statusList) {
			input = new ProxyInputParameter();
			input.setKey("I_CLAVE_ESTATUS");
			input.setValue(StringUtils.trimToEmpty(statusId));
			inputParams.add(input);
		}

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> getVerifierCode(String taskId, String cellphone) throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P003_SAVE_CODENROLREC_ProxyImpl proxy = new ZCRMRECO_P003_SAVE_CODENROLREC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_TAREA_ENROL");
		input.setValue(StringUtils.trimToEmpty(taskId));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CELULAR");
		input.setValue(StringUtils.trimToEmpty(cellphone));
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> saveServiceOrder(SaveServiceOrderRequest saveServiceOrderRequest)
			throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl proxy = new ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_ORDEN_SERVICIO");
		input.setValue(StringUtils.trimToEmpty(saveServiceOrderRequest.getServiceOrderId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADOR");
		if(StringUtils.trimToNull( saveServiceOrderRequest.getRecommenderBp() ) != null)
			input.setValue(Formatter.fillStringWithZerosOnLeft(saveServiceOrderRequest.getRecommenderBp(), 10));
		else
			input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_EMP_RESPONSABLE");
		input.setValue(Formatter.fillStringWithZerosOnLeft(saveServiceOrderRequest.getEmployeeBp(), 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADO");
		input.setValue(Formatter.fillStringWithZerosOnLeft(saveServiceOrderRequest.getRecommendedBp(), 10));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_SOL_COT_RECOMENDADO");
		input.setValue(StringUtils.trimToEmpty(saveServiceOrderRequest.getFolioApplication()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CANAL_ORIGEN");
		input.setValue(StringUtils.trimToEmpty(saveServiceOrderRequest.getSourceChannel()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_MONTO");
		input.setValue(String.valueOf(saveServiceOrderRequest.getAmount()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_OBSERVACIONES");
		input.setValue(StringUtils.trimToEmpty(saveServiceOrderRequest.getObservations()));
		inputParams.add(input);	

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> updateStatusServiceOrder(String serviceOrderId, String statusId,
			String serviceOrderType) throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P005_UPDSTS_SO_RECO_ProxyImpl proxy = new ZCRMRECO_P005_UPDSTS_SO_RECO_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_ORDEN_SERVICIO");
		input.setValue(StringUtils.trimToEmpty(serviceOrderId));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CLAVE_ESTATUS");
		input.setValue(StringUtils.trimToEmpty(statusId));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_TIPO_ORDEN");
		input.setValue(StringUtils.trimToEmpty(serviceOrderType));
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> taskSOAssociate(TaskSOAssociateRequest taskSOAssociateRequest) throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl proxy = new ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUM_TAREA_ENROL");
		input.setValue(StringUtils.trimToEmpty(taskSOAssociateRequest.getEnrollmentTaskId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_ID_ORDEN_SERVICIO");
		input.setValue(StringUtils.trimToEmpty(taskSOAssociateRequest.getServiceOrderId()));
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADOR");
		input.setValue(Formatter.fillStringWithZerosOnLeft(taskSOAssociateRequest.getRecommenderBp(), 10));
		inputParams.add(input);

		return proxy.executeRemoteFunction(destination, inputParams);
	}

	public ArrayList<IProxyOutputData> saveElegibility( SaveElegibilityRequest saveElegibilityRequest ) throws Exception {
		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		return new ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl().executeRemoteFunction(destination, saveElegibilityRequest);
	}

	public ArrayList<IProxyOutputData> getI610ServiceOrders() throws Exception {
		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_E004_GENERAI610RECO_ProxyImpl proxy = new ZCRMRECO_E004_GENERAI610RECO_ProxyImpl();
		
		return proxy.executeRemoteFunction( destination, new ArrayList<ProxyInputParameter>() );
	}

	public ArrayList<IProxyOutputData> updateServiceOrderStatusAndLote( UpdateServiceOrderStatusAndLoteRequest request ) throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P011_PDSO_I610_ProxyImpl proxy = new ZCRMRECO_P011_PDSO_I610_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_ORDER");
		input.setValue(request.getIdOrdenServicio());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_ID_ESTATUS");
		input.setValue(request.getIdEstatus());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_LOTE_I610");
		input.setValue(request.getIdLote());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CONCEPTO_P_RSTM");
		input.setValue(request.getConcepto());
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CODIGO_S_RSTM");
		input.setValue(request.getCodigo());
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_ATM_RETIRO");
		input.setValue(request.getAtmRetiro());
		inputParams.add(input);
		
 
		return proxy.executeRemoteFunction(destination, inputParams);

	}

	public ArrayList<IProxyOutputData> getServiceOrdersByStatus( List<String> statusList ) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		ZCRMRECO_E005_GETOSBYSTATUS_ProxyImpl proxy = new ZCRMRECO_E005_GETOSBYSTATUS_ProxyImpl(); 					
		proxy.executeRemoteFunction(destination, statusList );
		
		return proxy.executeRemoteFunction(destination, statusList );
	}

}
