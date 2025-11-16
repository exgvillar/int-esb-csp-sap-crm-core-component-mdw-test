/**
 * 
 */
package com.consubanco.services.sap.crm.recommender;

import java.util.ArrayList;
import java.util.List;

import com.consubanco.services.sap.crm.recommender.model.DocumentModel;
import com.consubanco.services.sap.crm.recommender.model.SaveElegibilityRequest;
import com.consubanco.services.sap.crm.recommender.model.SaveEnrollmentTaskRequest;
import com.consubanco.services.sap.crm.recommender.model.SaveServiceOrderRequest;
import com.consubanco.services.sap.crm.recommender.model.SearchInterlocutorRequest;
import com.consubanco.services.sap.crm.recommender.model.TaskSOAssociateRequest;
import com.consubanco.services.sap.crm.recommender.model.UpdateServiceOrderStatusAndLoteRequest;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public interface RecommenderServices {

	/**
	 * 
	 * @param searchInterlocutorRequest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> searchInterlocutor(SearchInterlocutorRequest searchInterlocutorRequest)
			throws Exception;

	/**
	 * 
	 * @param saveEnrollmentTaskRequest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> saveEnrollmentTask(SaveEnrollmentTaskRequest saveEnrollmentTaskRequest)
			throws Exception;

	/**
	 * 
	 * @param taskId
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> getVerifierCode(String taskId, String cellphone) throws Exception;

	/**
	 * 
	 * @param taskId
	 * @param statusId
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> updateStatusEnrollmentTask(String taskId, String statusId) throws Exception;

	/**
	 * 
	 * @param statusId
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> getEnrollmentTaskByStatus(List<String> statusList) throws Exception;

	/**
	 * 
	 * @param saveServiceOrderRequest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> saveServiceOrder(SaveServiceOrderRequest saveServiceOrderRequest)
			throws Exception;

	/**
	 * 
	 * @param serviceOrderId
	 * @param statusId
	 * @param serviceOrderType
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> updateStatusServiceOrder(String serviceOrderId, String statusId,
			String serviceOrderType) throws Exception;

	/**
	 * 
	 * @param taskSOAssociateRequest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> taskSOAssociate(TaskSOAssociateRequest taskSOAssociateRequest) throws Exception;

	/**
	 * 
	 * @param saveElegibilityRequest
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> saveElegibility(SaveElegibilityRequest saveElegibilityRequest) throws Exception;

	/**
	 * 
	 * @param documentId
	 * @param documentType
	 * @param documents
	 * @return
	 * @throws Exception
	 */
	public ArrayList<DocumentModel> attachDocuments(String documentId, String documentType, ArrayList<DocumentModel> documents) throws Exception;


	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> getI610ServiceOrders() throws Exception;
	
	/**
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> updateServiceOrderStatusAndLote(UpdateServiceOrderStatusAndLoteRequest request) throws Exception;
	
	/**
	 * 
	 * @param statusList
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> getServiceOrdersByStatus(List<String> statusList) throws Exception;

}
