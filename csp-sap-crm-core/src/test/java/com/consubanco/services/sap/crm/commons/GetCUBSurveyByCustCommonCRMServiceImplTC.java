/**
 * 
 */
package com.consubanco.services.sap.crm.commons;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.adobe.forms.cub.model.FileBORequest;
import com.consubanco.adobe.forms.cub.model.FileBOResponse;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;

import junit.framework.TestCase;

/**
 * @author estefania.montoya
 *
 */
public class GetCUBSurveyByCustCommonCRMServiceImplTC extends TestCase {
	private Log logger = LogFactory.getLog(GetCUBSurveyByCustCommonCRMServiceImplTC.class);

	public void testGetCustomerSurvey() throws Exception {
		CommonCRMService processImpl = new CommonCRMServiceImpl();

		CRMLocalConfigEnvironmentData.instance();

		String customerBp = "";
		String biotaskID = "1740023900";
		String applicationId = "CSB-CTE-APP"; //Identificador N4 //Venta asistida : OPPNP , promotor : ECSB
		boolean idResources = true;
		
		ArrayList<FileBORequest> fileList = new ArrayList<FileBORequest>();
		FileBORequest file = new FileBORequest();
		file = new FileBORequest();
		file.setName("anverso");
		file.setUrl(
				"https://storage.googleapis.com/pdi-mobile-main-qa.appspot.com/root_folder/100800129962/identificacion-oficial-anverso.png");
		fileList.add(file);

		file = new FileBORequest();
		file.setName("reverso");
		file.setUrl(
				"https://storage.googleapis.com/pdi-mobile-main-qa.appspot.com/root_folder/100800129962/identificacion-oficial-reverso.png");
		fileList.add(file);

		FileBOResponse response = processImpl.getCUBSurveyByCustomer(customerBp, biotaskID, fileList, applicationId, idResources);
		if (response != null) {
			logger.info("FileName: " + response.getName());
			logger.info("Base64: " + response.getBase64());
		}
	}
}
