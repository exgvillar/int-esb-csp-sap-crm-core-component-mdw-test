package com.consubanco.services.sap.crm.cnca.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_E002_GETCNCATASK_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_E004_GETACCOUNT_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_P001_SAVECNCATASK_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_P001_SAVEREQLETTER_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_P002_UPDSTSREQLETTER_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_P003_SAVECNCASIPRE_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMORI_P003_SAVEREQLETTSIPRE_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.ZCRMCXN_E010_SOLCNCAINT_ProxyImpl;
import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_FILES_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANDS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E001_GETINFBYACCOUNTID_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E002_GETCNCATASK_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E003_GETCNCATASKBYSTS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E004_GETACCOUNT_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P001_SAVECNCATASK_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P001_SAVEREQLETTER_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P002_UPDSTSCNCATASK_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P002_UPDSTSREQLETTER_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P003_SAVECNCASIPRE_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P003_SAVEREQLETTSIPRE_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMCXN_E010_SOLCNCAINT_Model;
import com.consubanco.services.sap.crm.cnca.ILoansCRM;
import com.consubanco.services.sap.crm.cnca.model.CncaSipreResultsModel;
import com.consubanco.services.sap.crm.cnca.model.FileModel;
import com.consubanco.services.sap.crm.cnca.model.GenericCatalogModel;
import com.consubanco.services.sap.crm.cnca.model.GetAccounstByFolioSipreModel;
import com.consubanco.services.sap.crm.cnca.model.GetCNCATaskByStatusModel;
import com.consubanco.services.sap.crm.cnca.model.GetCncaTaskModel;
import com.consubanco.services.sap.crm.cnca.model.GetInfoAppByCncaLoanModel;
import com.consubanco.services.sap.crm.cnca.model.GetRequestsCncaModel;
import com.consubanco.services.sap.crm.cnca.model.LoanModel;
import com.consubanco.services.sap.crm.cnca.model.LoansModel;
import com.consubanco.services.sap.crm.cnca.model.RequestLetterSipreResultsModel;
import com.consubanco.services.sap.crm.cnca.model.SaveCncaTaskModel;
import com.consubanco.services.sap.crm.cnca.model.SaveRequestLetterTaskModel;
import com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel;
import com.consubanco.services.sap.crm.cnca.model.UpdateStatusRequestLetterTaskModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class LoansCRMImpl implements ILoansCRM{
	
	private String jcoDestination = "CSPSAPCRM";

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#getInfoAppByCncaLoan(com.consubanco.services.sap.crm.cnca.model.GetInfoAppByCncaLoanModel)
	 */
	public List<IProxyOutputData> getInfoAppByCncaLoan(GetInfoAppByCncaLoanModel request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl proxy = new ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl();
		ZCRMORI_E001_GETINFBYACCOUNTID_Model inputParamsModel = new ZCRMORI_E001_GETINFBYACCOUNTID_Model();

		inputParamsModel.setCustomerBp(Formatter.fillStringWithZerosOnLeft(StringUtils.trimToEmpty(request.getCustomerBp()), 10));
		
		for(LoanModel loanModel: request.getLoans()) {
			I_LOANDS_Model model = new I_LOANDS_Model();
			model.setAccountId(loanModel.getAccountId());
			inputParamsModel.getLoans().add(model);
		}

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#saveCncaTask(com.consubanco.services.sap.crm.cnca.model.SaveCncaTaskModel)
	 */
	public List<IProxyOutputData> saveCncaTask(SaveCncaTaskModel request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_P001_SAVECNCATASK_ProxyImpl proxy = new ZCRMORI_P001_SAVECNCATASK_ProxyImpl();
		ZCRMORI_P001_SAVECNCATASK_Model inputParamsModel = new ZCRMORI_P001_SAVECNCATASK_Model();

		inputParamsModel.setTaskId(request.getTaskId());
		inputParamsModel.setCustomerBp(request.getCustomerBp());
		inputParamsModel.setPromotorBp(request.getPromotorBp());
		
		if(request.getEnterprise() != null){
			GENERIC_CATALOG_Model enterprise = new GENERIC_CATALOG_Model();
			enterprise.setKey(request.getEnterprise().getKey());
			enterprise.setDescription(request.getEnterprise().getDescription());		
			inputParamsModel.setEnterprise(enterprise);
		}
		if(request.getDistributor() != null){
			GENERIC_CATALOG_Model distributor = new GENERIC_CATALOG_Model();
			distributor.setKey(request.getDistributor().getKey());
			distributor.setDescription(request.getDistributor().getDescription());		
			inputParamsModel.setDistributor(distributor);
		}
		if(request.getBranch() != null){
			GENERIC_CATALOG_Model branch = new GENERIC_CATALOG_Model();
			branch.setKey(request.getBranch().getKey());
			branch.setDescription(request.getBranch().getDescription());		
			inputParamsModel.setBranch(branch);
		}
		if(request.getProduct() != null){
			GENERIC_CATALOG_Model product = new GENERIC_CATALOG_Model();
			product.setKey(request.getProduct().getKey());
			product.setDescription(request.getProduct().getDescription());		
			inputParamsModel.setProduct(product);
		}
		inputParamsModel.setRequestAmount(request.getRequestAmount());
		inputParamsModel.setTerm(request.getTerm());		
		
		for(LoansModel loansModel: request.getLoans()) {
			I_LOANS_Model model = new I_LOANS_Model();
			model.setAccountId(Formatter.fillStringWithZerosOnLeft(String.valueOf(loansModel.getAccountId()),12));
			model.setPortfolioOwner(loansModel.getPortfolioOwner());
			
			model.setFormalizationDate(loansModel.getFormalizationDate());
			model.setEnterpriseOrigination(loansModel.getEnterpriseOrigination());
			model.setTotalOfPayments(loansModel.getTotalOfPayments());
			model.setPaymentNumber(loansModel.getPaymentNumber());
			model.setFrecuency(loansModel.getFrecuency());
			model.setDiscountAmount(loansModel.getDiscountAmount());
			model.setLiquidAmount(loansModel.getLiquidAmount());
			model.setInterestRate(loansModel.getInterestRate());
			model.setCat(loansModel.getCat());
			model.setPensionType(loansModel.getPensionType());
			model.setFolioReleaseLetter(loansModel.getFolioReleaseLetter());			
			inputParamsModel.getLoans().add(model);
		}
		
		for(FileModel fileModel: request.getFiles()) {
			I_FILES_Model model = new I_FILES_Model();
			model.setFileName(fileModel.getFileName());
			model.setBase64(fileModel.getBase64());
			inputParamsModel.getFiles().add(model);
		}
		
		inputParamsModel.setSolicitudId(request.getSolicitudId());

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#updateCncaTask(com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel)
	 */
	public List<IProxyOutputData> updateCncaTask(UpdateCncaTaskModel request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl proxy = new ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl();
		ZCRMORI_P002_UPDSTSCNCATASK_Model inputParamsModel = new ZCRMORI_P002_UPDSTSCNCATASK_Model();

		GENERIC_CATALOG_Model status = new GENERIC_CATALOG_Model();
		status.setKey(request.getStatus().getKey());
		status.setDescription(request.getStatus().getDescription());
		
		inputParamsModel.setTaskId(request.getTaskId());	
		inputParamsModel.setStatus(status);		
		inputParamsModel.setComments(request.getComments());

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#getCncaTask(com.consubanco.services.sap.crm.cnca.model.GetCncaTaskModel)
	 */
	public List<IProxyOutputData> getCncaTask(GetCncaTaskModel request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_E002_GETCNCATASK_ProxyImpl proxy = new ZCRMORI_E002_GETCNCATASK_ProxyImpl();
		ZCRMORI_E002_GETCNCATASK_Model inputParamsModel = new ZCRMORI_E002_GETCNCATASK_Model();
		
		inputParamsModel.setTaskId(request.getTaskId());	
		inputParamsModel.setFindFiles(request.isFindFiles());

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#getCNCATaskByStatus(com.consubanco.services.sap.crm.cnca.model.GetCNCATaskByStatusModel)
	 */
	public List<IProxyOutputData> getCncaTaskByStatus(GetCNCATaskByStatusModel request) throws Exception{

		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl proxy = new ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl();
		ZCRMORI_E003_GETCNCATASKBYSTS_Model inputParamsModel = new ZCRMORI_E003_GETCNCATASKBYSTS_Model();

		for(GenericCatalogModel statusModel: request.getStatus()) {
			GENERIC_CATALOG_Model status = new GENERIC_CATALOG_Model();
			status.setKey(statusModel.getKey());
			status.setDescription(statusModel.getDescription());
			inputParamsModel.getStatus().add(status);
		}
		
		inputParamsModel.setPromotorBp(request.getPromotorBp());

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#cncaSipreResults(com.consubanco.services.sap.crm.cnca.model.CncaSipreResultsModel)
	 */
	public List<IProxyOutputData> cncaSipreResults(CncaSipreResultsModel request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_P003_SAVECNCASIPRE_ProxyImpl proxy = new ZCRMORI_P003_SAVECNCASIPRE_ProxyImpl();
		ZCRMORI_P003_SAVECNCASIPRE_Model inputParamsModel = new ZCRMORI_P003_SAVECNCASIPRE_Model();
		
		inputParamsModel.setTaskId(Formatter.fillStringWithZerosOnLeft(request.getTaskId(),10));
		
		if(StringUtils.trimToEmpty(request.getAccountId()) != null) {			
			/*Se convierte a número para agregar los ceros a la izquierda en caso de no cumplir con la longitud de 12*/
			Long accountId = Long.parseLong(request.getAccountId());
			inputParamsModel.setAccountId(Formatter.fillStringWithZerosOnLeft(String.valueOf(accountId),12));
		}
		
		if(request.getStatusSipre() != null) {
			GENERIC_CATALOG_Model statusSipre = new GENERIC_CATALOG_Model();
			statusSipre.setKey(request.getStatusSipre().getKey());
			statusSipre.setDescription(request.getStatusSipre().getDescription());		
			inputParamsModel.setStatusSipre(statusSipre);
		}
				
		for(FileModel fileModel: request.getFileEvidences()) {
			I_FILES_Model model = new I_FILES_Model();
			model.setFileName(fileModel.getFileName());
			model.setBase64(fileModel.getBase64());
			inputParamsModel.getFileEvidences().add(model);
		}
		
		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#getRequestsCnca(com.consubanco.services.sap.crm.cnca.model.GetRequestsCncaModel)
	 */
	public List<IProxyOutputData> getRequestsCnca(GetRequestsCncaModel request) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMCXN_E010_SOLCNCAINT_ProxyImpl proxy = new ZCRMCXN_E010_SOLCNCAINT_ProxyImpl();
		ZCRMCXN_E010_SOLCNCAINT_Model inputParamsModel = new ZCRMCXN_E010_SOLCNCAINT_Model();
		
		inputParamsModel.setInitialDate(request.getInitialDate());	
		inputParamsModel.setFinalDate(request.getFinalDate());

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
	public List<IProxyOutputData> getAccounstByFolioSipre(GetAccounstByFolioSipreModel request) throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_E004_GETACCOUNT_ProxyImpl proxy = new ZCRMORI_E004_GETACCOUNT_ProxyImpl();
		ZCRMORI_E004_GETACCOUNT_Model inputParams = new ZCRMORI_E004_GETACCOUNT_Model();
		
		inputParams.setAccount(request.getAccount());
		inputParams.setFolioReleaseLetter(request.getFolioReleaseLetter());
		inputParams.setTaskId(request.getTaskId());
        inputParams.setFindFiles(true);

		return proxy.executeRemoteFunction(destination, inputParams);
	}
  
  /* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#updateCncaTask(com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel)
	 */
	public List<IProxyOutputData> saveRequestLetterTask(SaveRequestLetterTaskModel request) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		

		ZCRMORI_P001_SAVEREQLETTER_ProxyImpl proxy = new ZCRMORI_P001_SAVEREQLETTER_ProxyImpl();
		ZCRMORI_P001_SAVEREQLETTER_Model inputParamsModel = new ZCRMORI_P001_SAVEREQLETTER_Model();

		inputParamsModel.setTaskId(request.getTaskId());
		inputParamsModel.setCustomerBp(Formatter.fillStringWithZerosOnLeft(request.getCustomerBp(),10));
		inputParamsModel.setPromotorBp(Formatter.fillStringWithZerosOnLeft(request.getPromotorBp(),10));
		
		GENERIC_CATALOG_Model enterprise = new GENERIC_CATALOG_Model();
		enterprise.setKey(request.getEnterprise().getKey());
		enterprise.setDescription(request.getEnterprise().getDescription());		
		inputParamsModel.setEnterprise(enterprise);
		
		GENERIC_CATALOG_Model distributor = new GENERIC_CATALOG_Model();
		distributor.setKey(request.getDistributor().getKey());
		distributor.setDescription(request.getDistributor().getDescription());		
		inputParamsModel.setDistributor(distributor);
		
		GENERIC_CATALOG_Model branch = new GENERIC_CATALOG_Model();
		branch.setKey(request.getBranch().getKey());
		branch.setDescription(request.getBranch().getDescription());		
		inputParamsModel.setBranch(branch);
		
		GENERIC_CATALOG_Model product = new GENERIC_CATALOG_Model();
		product.setKey(request.getProduct().getKey());
		product.setDescription(request.getProduct().getDescription());		
		inputParamsModel.setProduct(product);
		
		inputParamsModel.setRequestAmount(request.getRequestAmount());
		inputParamsModel.setTerm(request.getTerm());
		inputParamsModel.setSolicitudId(request.getSolicitudId());
		
		for(LoansModel loansModel: request.getLoans()) {
			I_LOANS_Model model = new I_LOANS_Model();
			model.setAccountId(Formatter.fillStringWithZerosOnLeft(String.valueOf(loansModel.getAccountId()),12));
			model.setPortfolioOwner(loansModel.getPortfolioOwner());
			
			model.setFormalizationDate(loansModel.getFormalizationDate());
			model.setEnterpriseOrigination(loansModel.getEnterpriseOrigination());
			model.setTotalOfPayments(loansModel.getTotalOfPayments());
			model.setPaymentNumber(loansModel.getPaymentNumber());
			model.setFrecuency(loansModel.getFrecuency());
			model.setDiscountAmount(loansModel.getDiscountAmount());
			model.setLiquidAmount(loansModel.getLiquidAmount());
			model.setInterestRate(loansModel.getInterestRate());
			model.setCat(loansModel.getCat());
			model.setPensionType(loansModel.getPensionType());
			model.setFolioReleaseLetter(loansModel.getFolioReleaseLetter());			
			inputParamsModel.getLoans().add(model);
		}
		
		inputParamsModel.setIsLcom(request.getIsLcom());
		inputParamsModel.setIsCnca(request.getIsCnca());
		inputParamsModel.setIsInter(request.getIsInter());
		
		for(FileModel fileModel: request.getFiles()) {
			I_FILES_Model model = new I_FILES_Model();
			model.setFileName(fileModel.getFileName());
			model.setBase64(fileModel.getBase64());
			inputParamsModel.getFiles().add(model);
		}

		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}

	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#updateCncaTask(com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel)
	 */
	public List<IProxyOutputData> updateStatusRequestLetterTask(UpdateStatusRequestLetterTaskModel request) throws Exception{
	
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_P002_UPDSTSREQLETTER_ProxyImpl proxy = new ZCRMORI_P002_UPDSTSREQLETTER_ProxyImpl();
		ZCRMORI_P002_UPDSTSREQLETTER_Model inputParamsModel = new ZCRMORI_P002_UPDSTSREQLETTER_Model();
	
		GENERIC_CATALOG_Model status = new GENERIC_CATALOG_Model();
		status.setKey(request.getStatus().getKey());
		status.setDescription(request.getStatus().getDescription());
		
		inputParamsModel.setTaskId(request.getTaskId());	
		inputParamsModel.setStatus(status);	
	
		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
	/* (non-Javadoc)
	 * @see com.consubanco.services.sap.crm.cnca.ILoansCRM#updateCncaTask(com.consubanco.services.sap.crm.cnca.model.UpdateCncaTaskModel)
	 */
	public List<IProxyOutputData> requestLetterSipreResults(RequestLetterSipreResultsModel request) throws Exception{
	
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination(jcoDestination);
		
		ZCRMORI_P003_SAVEREQLETTSIPRE_ProxyImpl proxy = new ZCRMORI_P003_SAVEREQLETTSIPRE_ProxyImpl();
		ZCRMORI_P003_SAVEREQLETTSIPRE_Model inputParamsModel = new ZCRMORI_P003_SAVEREQLETTSIPRE_Model();
	
		inputParamsModel.setTaskId(Formatter.fillStringWithZerosOnLeft(request.getTaskId(),10));
		
		if(StringUtils.trimToEmpty(request.getAccountId()) != null) {			
			/*Se convierte a número para agregar los ceros a la izquierda en caso de no cumplir con la longitud de 12*/
			Long accountId = Long.parseLong(request.getAccountId());
			inputParamsModel.setAccountId(Formatter.fillStringWithZerosOnLeft(String.valueOf(accountId),12));
		}
		
		if(request.getAccountStatus() != null) {
			GENERIC_CATALOG_Model accountStatus = new GENERIC_CATALOG_Model();
			accountStatus.setKey(request.getAccountStatus().getKey());
			accountStatus.setDescription(request.getAccountStatus().getDescription());		
			inputParamsModel.setAccountStatus(accountStatus);
		}
				
		for(FileModel fileModel: request.getFileEvidences()) {
			I_FILES_Model model = new I_FILES_Model();
			model.setFileName(fileModel.getFileName());
			model.setBase64(fileModel.getBase64());
			inputParamsModel.getFileEvidences().add(model);
		}
	
		return proxy.executeRemoteFunction(destination, inputParamsModel);
	}
	
}
