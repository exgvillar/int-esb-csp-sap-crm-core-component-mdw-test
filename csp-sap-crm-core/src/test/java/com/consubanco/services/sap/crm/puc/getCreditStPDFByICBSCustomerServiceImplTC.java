/**
 * 
 */
package com.consubanco.services.sap.crm.puc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.adobe.forms.cub.model.FileBOResponse;
import com.consubanco.services.sap.crm.puc.models.CreditBalancesPDF;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

import junit.framework.TestCase;

/**
 * @author estefania.montoya
 *
 */
public class getCreditStPDFByICBSCustomerServiceImplTC extends TestCase {
	private Log logger = LogFactory.getLog(getCreditStPDFByICBSCustomerServiceImplTC.class);

	public void testGetCustomerSurvey() throws Exception {
		CreditStatementImpl processImpl = new CreditStatementImpl();

		CRMLocalConfigEnvironmentData.instance();

		long creditId = 7689358; /*DEV 7689358 - QA7775579 - 7775625 - 7775624*/
		String applicationId = "ECSB"; // Identificador N4 //Venta asistida :
										// OPPNP , promotor : ECSB

		CreditBalancesPDF crdB = new CreditBalancesPDF();
		FileBOResponse response = processImpl.getCreditStatementPDF(applicationId, "7775625", creditId, crdB);
		if (response.isSuccess()) {
			logger.info("FileName: " + response.getName());
			logger.info("Base64: " + response.getBase64());

		} else {
			logger.info("Success: " + response.isSuccess());
			logger.info("message: " + response.getMessage());

		}
	}

}
