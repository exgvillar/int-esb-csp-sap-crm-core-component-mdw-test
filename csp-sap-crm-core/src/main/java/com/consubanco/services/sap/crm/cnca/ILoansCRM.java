package com.consubanco.services.sap.crm.cnca;

import java.util.List;

import com.consubanco.services.sap.crm.cnca.model.CncaSipreResultsModel;
import com.consubanco.services.sap.crm.cnca.model.GetAccounstByFolioSipreModel;
import com.consubanco.services.sap.crm.cnca.model.GetCNCATaskByStatusModel;
import com.consubanco.services.sap.crm.cnca.model.GetCncaTaskModel;
import com.consubanco.services.sap.crm.cnca.model.GetInfoAppByCncaLoanModel;
import com.consubanco.services.sap.crm.cnca.model.SaveCncaTaskModel;
import com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel;
import com.consubanco.services.sap.crm.cnca.model.GetRequestsCncaModel;
import com.consubanco.services.sap.crm.cnca.model.SaveRequestLetterTaskModel;
import com.consubanco.services.sap.crm.cnca.model.UpdateStatusRequestLetterTaskModel;
import com.consubanco.services.sap.crm.cnca.model.RequestLetterSipreResultsModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public interface ILoansCRM {
	
	/**
	 * @param infoAppByCncaLoan
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> getInfoAppByCncaLoan(GetInfoAppByCncaLoanModel infoAppByCncaLoan) throws Exception;

	/**
	 * @param saveCncaTask
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> saveCncaTask(SaveCncaTaskModel saveCncaTask) throws Exception;	
	
	/**
	 * @param updateCncaTask
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> updateCncaTask(UpdateCncaTaskModel updateCncaTask) throws Exception;
	
	/**
	 * @param getCncaTask
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> getCncaTask(GetCncaTaskModel getCncaTask) throws Exception;
	
	/**
	 * @param getCNCATaskByStatus
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> getCncaTaskByStatus(GetCNCATaskByStatusModel getCNCATaskByStatus) throws Exception;
	
	/**
	 * @param cncaSipreResults
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> cncaSipreResults(CncaSipreResultsModel cncaSipreResults) throws Exception;
	
	/**
	 * @param getRequestsCnca
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> getRequestsCnca(GetRequestsCncaModel getRequestsCnca) throws Exception;
	
	/**
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> getAccounstByFolioSipre(GetAccounstByFolioSipreModel request) throws Exception;

	/**
	 * @param saveRequestLetterTask
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> saveRequestLetterTask(SaveRequestLetterTaskModel saveRequestLetterTask) throws Exception;
	
	/**
	 * @param updateStatusRequestLetterTask
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> updateStatusRequestLetterTask(UpdateStatusRequestLetterTaskModel updateStatusRequestLetterTask) throws Exception;
	
	/**
	 * @param requestLetterSipreResults
	 * @return
	 * @throws Exception
	 */
	public List<IProxyOutputData> requestLetterSipreResults(RequestLetterSipreResultsModel requestLetterSipreResults) throws Exception;

}
