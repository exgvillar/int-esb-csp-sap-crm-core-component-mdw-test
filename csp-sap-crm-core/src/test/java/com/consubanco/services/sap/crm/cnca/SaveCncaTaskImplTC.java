package com.consubanco.services.sap.crm.cnca;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.services.sap.crm.cnca.impl.LoansCRMImpl;
import com.consubanco.services.sap.crm.cnca.model.FileModel;
import com.consubanco.services.sap.crm.cnca.model.GenericCatalogModel;
import com.consubanco.services.sap.crm.cnca.model.LoansModel;
import com.consubanco.services.sap.crm.cnca.model.SaveCncaTaskModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

import junit.framework.TestCase;

public class SaveCncaTaskImplTC extends TestCase {
	
	private static Log log = LogFactory.getLog( SaveCncaTaskImplTC.class );

	public SaveCncaTaskImplTC() {
		super();
	}
	
	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		ILoansCRM loansCRMImpl = new LoansCRMImpl();
		
		SaveCncaTaskModel saveCncaTaskModel = new SaveCncaTaskModel();
		saveCncaTaskModel.setTaskId("");
		saveCncaTaskModel.setCustomerBp("1143");
		saveCncaTaskModel.setPromotorBp("10002446");
		
		GenericCatalogModel enterprise = new GenericCatalogModel();
		enterprise.setKey("50000004");
		enterprise.setDescription("");		
		saveCncaTaskModel.setEnterprise(enterprise);
		
		GenericCatalogModel distributor = new GenericCatalogModel();
		distributor.setKey("50000033");
		distributor.setDescription("");		
		saveCncaTaskModel.setDistributor(distributor);
		
		GenericCatalogModel branch = new GenericCatalogModel();
		branch.setKey("50000036");
		branch.setDescription("");		
		saveCncaTaskModel.setBranch(branch);
		
		GenericCatalogModel product = new GenericCatalogModel();
		product.setKey("1542");
		product.setDescription("");		
		saveCncaTaskModel.setProduct(product);
		
		saveCncaTaskModel.setRequestAmount(50000.00);
		saveCncaTaskModel.setTerm(15);
		
		List<LoansModel> loans = new ArrayList<LoansModel>();
		LoansModel loansModel = new LoansModel();
		loansModel.setAccountId(324939393L);
		
		loansModel.setPortfolioOwner("28374");
		loansModel.setFormalizationDate(new SimpleDateFormat("dd-MM-yyyy").parse("30-05-2024"));
		loansModel.setEnterpriseOrigination("53400999");
		loansModel.setTotalOfPayments(12);
		loansModel.setPaymentNumber(12);
		loansModel.setFrecuency("MENSUAL");
		loansModel.setDiscountAmount(334.00);
		loansModel.setLiquidAmount(222.00);
		loansModel.setInterestRate(300.00);
		loansModel.setCat(10.00);
		loansModel.setPensionType("NUEVO");
		loansModel.setFolioReleaseLetter("NUEVO");
		loans.add(loansModel);		
		saveCncaTaskModel.setLoans(loans);
		
		List<FileModel> files = new ArrayList<FileModel>();
		FileModel fileModel = new FileModel();
		fileModel.setFileName("PRUEBA.TXT");
		fileModel.setBase64("B0");
		files.add(fileModel);
		saveCncaTaskModel.setFiles(files);
		
		List<IProxyOutputData> returnList = loansCRMImpl.saveCncaTask(saveCncaTaskModel);
		assertNotNull("Respuesta de la operacion saveCncaTask vacia ", returnList);
		log.info( returnList );
	}
	

}
