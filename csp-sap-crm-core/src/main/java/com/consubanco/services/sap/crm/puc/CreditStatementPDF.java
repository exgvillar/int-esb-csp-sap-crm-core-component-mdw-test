/**
 * 
 */
package com.consubanco.services.sap.crm.puc;

import com.consubanco.adobe.forms.cub.model.FileBOResponse;
import com.consubanco.services.sap.crm.puc.models.CreditBalancesPDF;

/**
 * @author estefania.montoya
 *
 */
public interface CreditStatementPDF {
	public FileBOResponse getCreditStatementPDF(String applicationId, String requestId, long creditId,
			CreditBalancesPDF crdBalance) throws Exception;

}
